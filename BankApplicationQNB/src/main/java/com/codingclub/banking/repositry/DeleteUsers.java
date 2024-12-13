package com.codingclub.banking.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingclub.banking.entity.EntityClassForIntiation;
import com.codingclub.banking.entity.UserCreationMaster;

@Repository
public interface DeleteUsers extends JpaRepository< UserCreationMaster, Integer> {
	
	List<UserCreationMaster> findByDeletedTrue();

}
