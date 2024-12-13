package com.codingclub.banking.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingclub.banking.entity.EntityClassForIntiation;
import com.codingclub.banking.entity.UserCreationMaster;

@Repository
public interface GetTransactionDetailsJPA extends JpaRepository< EntityClassForIntiation, Integer> {
	
	 @Query("SELECT e FROM EntityClassForIntiation e WHERE e.id = :id and   e.availablebal = :availablebal ")
	 Optional<EntityClassForIntiation> findByReference(@Param("id") int id , @Param("availablebal") double availablebal );

}
