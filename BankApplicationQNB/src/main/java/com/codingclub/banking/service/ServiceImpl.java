package com.codingclub.banking.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.codingclub.banking.Dto.EntityClassDTO;
import com.codingclub.banking.Dto.UserClassDTO;
import com.codingclub.banking.entity.EntityClassForIntiation;
import com.codingclub.banking.entity.UserCreationMaster;
import com.codingclub.banking.repositry.DeleteUsers;
import com.codingclub.banking.repositry.GetTransactionDetailsJPA;
import com.codingclub.banking.repositry.JPARepositryClass;
import com.codingclub.banking.repositry.UserCreationJPA;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServiceImpl implements Serviceclass {

	@Autowired
	private JPARepositryClass jparepo;

	@Autowired
	private UserCreationJPA userjpa;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ObjectMapper objectmapper;
	@Autowired
	private UserCreationJPA usercreationjpa;
	
	@Autowired
	private GetTransactionDetailsJPA gettransactiondetailsJPA ;
	
	@Autowired
	private DeleteUsers deleteUsers;
    
	@Value("${TELTRF}")
	private String txndescription;
	
	@Value("${RV}")
	private String statusdesc;
	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Override
	public EntityClassDTO createTransaction(EntityClassForIntiation tansaction) {
		// TODO Auto-generated method stub
	String txntype=	tansaction.getTxntype();
	
	if("TELTRF".equals(txntype)) {
		
		tansaction.setTxndesc(txndescription);
		
	}else {
		tansaction.setTxndesc("Unknown Transaction Forgery....!");
	}
	String odstatus = tansaction.getOdstatus();
	System.out.println("Json Object Printinng odstatus : : " +odstatus);
	if("RV".equals(odstatus))
		tansaction.setStatusdesc(statusdesc);
	else
		tansaction.setStatusdesc("Failed");
	
		EntityClassForIntiation Intiation = jparepo.save(tansaction);
		EntityClassDTO entitydto = this.modelMapper.map(Intiation, EntityClassDTO.class);
		return entitydto;
	}

	@Override
	public boolean Duplicatetransactioncheck(EntityClassForIntiation tansaction) {

		boolean existflag = false;
		String beneaccnumber = tansaction.getBeneaccountnumber();
		String benecurrency = tansaction.getBenecurrency();
		String subproductcode = tansaction.getSubproduct();

		existflag = jparepo.existsByBeneaccountnumberAndBenecurrencyAndSubproduct(beneaccnumber, benecurrency,
				subproductcode);

		return existflag;
	}

	@Override
	public UserClassDTO usercreation(UserCreationMaster usercreationmaster) {
		//String password = usercreationmaster.getPassword();
		usercreationmaster.setPassword(passwordencoder.encode(usercreationmaster.getPassword()));
		
		UserCreationMaster usermaster = userjpa.save(usercreationmaster);
		UserClassDTO userclassdto=	this.modelMapper.map(usermaster, UserClassDTO.class);
		return  userclassdto;
	}

	@Override
	public boolean DupliacteLoginId(UserCreationMaster usercreation) {
		boolean loginIdExits = false;
		String Jsonobj;
		try {
			Jsonobj = objectmapper.writeValueAsString(usercreation);
			System.out.println("Json Object Printinng : : " +Jsonobj);
			System.out.println("usercreation.getLoginid() : : " +usercreation.getLoginid());
			//loginIdExits = usercreationjpa.findByLoginid(usercreation.getLoginid());
			 Optional<UserCreationMaster> user = usercreationjpa.findByLoginid(usercreation.getLoginid());
			System.out.println("loginIdExits or not : : " +user.isPresent());
			loginIdExits = user.isPresent();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: : " +e);
		}
		return loginIdExits;
	}

	@Override
	public EntityClassForIntiation GETtransactionDetails(int id,double amount) {
		
		 EntityClassForIntiation entityClassForIntiation =gettransactiondetailsJPA.findByReference(id,amount).orElse(null);
		return entityClassForIntiation;
	}

	@Override
	public List<UserCreationMaster> getAllUsers() {
		
		return userjpa.findAll();
	}

	@Override
	public List<EntityClassForIntiation> getAllTransactions() {
		
		return jparepo.findAll();
	}

	@Override
	public List<UserCreationMaster> deleteAllUsers() {
		//List<UserCreationMaster> =	
		List<UserCreationMaster> deletedUsers = deleteUsers.findByDeletedTrue();
		
		deleteUsers.deleteAll();
		return  deletedUsers;
	}

	

}
