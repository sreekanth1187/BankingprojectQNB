package com.codingclub.banking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingclub.banking.Dto.EntityClassDTO;
import com.codingclub.banking.Dto.UserClassDTO;
import com.codingclub.banking.entity.EntityClassForIntiation;
import com.codingclub.banking.entity.UserCreationMaster;


@Service
public interface Serviceclass {

	public EntityClassDTO createTransaction(EntityClassForIntiation tansaction);

	public boolean Duplicatetransactioncheck(EntityClassForIntiation tansaction);

	public UserClassDTO usercreation(UserCreationMaster usercreation);

	public boolean DupliacteLoginId(UserCreationMaster usercreation);
	
	public EntityClassForIntiation GETtransactionDetails(int referenceNo , double amount);

	public List<UserCreationMaster> getAllUsers();
	public List<UserCreationMaster> deleteAllUsers();
	public List<EntityClassForIntiation> getAllTransactions();
}
