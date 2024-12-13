package com.codingclub.banking.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingclub.banking.entity.UserCreationMaster;


public interface UserCreationJPA extends JpaRepository<UserCreationMaster, Integer>{

	
	
	 Optional<UserCreationMaster> findByLoginid(String loginid);
	 
}
