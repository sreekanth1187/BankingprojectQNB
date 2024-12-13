package com.codingclub.banking.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingclub.banking.Dto.EntityClassDTO;
import com.codingclub.banking.Dto.UserClassDTO;
import com.codingclub.banking.annotations.ConfigurationBean;
import com.codingclub.banking.annotations.Configurationproperties;
import com.codingclub.banking.annotations.LazyLoading;
import com.codingclub.banking.annotations.TestBean;
import com.codingclub.banking.entity.EntityClassForIntiation;
import com.codingclub.banking.entity.UserCreationMaster;
import com.codingclub.banking.exception.NoTransactionFoundException;
import com.codingclub.banking.service.ServiceImpl;
import com.codingclub.banking.service.Serviceclass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private Serviceclass service;

	@Autowired
	private ModelMapper modelMapper;

	
	private ObjectMapper objectmapper;
	
	//@Autowired
	/*
	 * @Value("${Debitaccountnumber}") private String debitaccountnumber;
	 * 
	 * @Value("${phonenumber}") private String phonenumberfetch;
	 */
	
	
	
	@Autowired
	private LazyLoading lazyLoading ;
	
	@Autowired
	private Configurationproperties congig;
	
	@Autowired
	private TestBean testBean;
	
	
	public ApiController(ObjectMapper objectmapper) {
		this.objectmapper = objectmapper;
	}

	@PostMapping("/intiate")
	public ResponseEntity<?> savetransaction(@RequestBody EntityClassForIntiation intiation)
			throws JsonProcessingException {
		boolean duplicateflaging = false;
		
		duplicateflaging = service.Duplicatetransactioncheck(intiation);
		
		
		if (duplicateflaging) {
			return new ResponseEntity<>("Duplicate Transaction", HttpStatus.BAD_REQUEST);
		} else {
                   
			EntityClassDTO inserted = service.createTransaction(intiation);
            return new ResponseEntity<>(inserted,  HttpStatus.OK);
			}
	}
	
	@GetMapping("/WelCome")
	public ResponseEntity<String> WelcomePage()
			throws JsonProcessingException {
		String WelcomeMessage = " Welcome to Qatar National Bank ";
            return new ResponseEntity<String>(WelcomeMessage,  HttpStatus.OK);
			}
	
	
	@PostMapping("/usercreation")
	public ResponseEntity<?> usercreation(@RequestBody UserCreationMaster usercreationmaster) throws JsonProcessingException{
		String Jsonobj = objectmapper.writeValueAsString(usercreationmaster);
		System.out.println("Json Object Printinng : : " + Jsonobj);
       // System.out.println("Data Retrived from Application properties :: "+ debitaccountnumber);
       // System.out.println("Data Retrived from Custom properties :: "+ phonenumberfetch);
       // System.out.println("Data Retrived From configurationBean :: "+ testBean.Method());
		System.out.println("Custom Properties from prefix ::: " + congig.getMailbody() + "  " + congig.getMailType()
				+ "  " + congig.getMailsign());
        testBean.Method();
        boolean loginidexits=false;
		loginidexits= service.DupliacteLoginId(usercreationmaster);
		
		  if(loginidexits) { return new
		  ResponseEntity<String>(" Login ID Already Exits", HttpStatus.BAD_REQUEST);
		  }else {
		 
			  UserClassDTO userDTO = service.usercreation(usercreationmaster);
			return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}
		
		
	}
	
	@GetMapping("/GET_TXN/{id}/{amount}") 
	@PreAuthorize("hasAuthority('ROLE_MAKER')")
	public ResponseEntity<?> getTransaction(@PathVariable("id") int id, @PathVariable("amount") double amount   ) throws NoTransactionFoundException{
	  
		EntityClassForIntiation entityClassForIntiation =service.GETtransactionDetails(id,amount);
	  if(entityClassForIntiation != null) {
		 
		  return new ResponseEntity<>(entityClassForIntiation, HttpStatus.OK );
	  }else {
		  throw new NoTransactionFoundException(" Forbidden....!  No Transaction Found with ID " + id +"  and  " + amount + "  amount Combination");
		  
	  }
	 
	  }
	
	
	@GetMapping("/FetchAllUsers") 
	@PreAuthorize("hasAuthority('ROLE_MAKER_AUTHORIZER')")
	public ResponseEntity<List<UserCreationMaster>> getAllUsers(){
		//SuperClass subclasstwo = ComputerFactoryDesign.getComputer("server","16 GB","1 TB","2.9 GHz");
		
		//System.out.println("Factory subclasstwo Config::"+subclasstwo);
      return  ResponseEntity.ok(service.getAllUsers());
	 
	  }
	

	@GetMapping("/FetchAllTransaction") 
	@PreAuthorize("hasAuthority('ROLE_MAKER_AUTHORIZER')")
	public ResponseEntity<List<EntityClassForIntiation>> getAllTransactions(){
		System.out.println("Custom Properties from prefix ::: " + congig.getMailbody() + "  " + congig.getMailType()
		+ "  " + congig.getMailsign());
		testBean.Method();
		
		//SuperClass subclassone = ComputerFactoryDesign.getComputer("pc","2 GB","500 GB","2.4 GHz");
		//System.out.println("Factory subclassone Config::"+subclassone);
      return  ResponseEntity.ok(service.getAllTransactions());
	 
	  }
	 
	@DeleteMapping("/DeleteAllUsers") 
	@PreAuthorize("hasAuthority('ROLE_MAKER_AUTHORIZER')")
		public ResponseEntity<List<UserCreationMaster>> deleteAllUsers() {

			 return ResponseEntity.ok(service.deleteAllUsers());

		}
	
	

}
