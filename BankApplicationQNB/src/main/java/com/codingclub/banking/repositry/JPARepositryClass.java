package com.codingclub.banking.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingclub.banking.entity.EntityClassForIntiation;


@Repository
public interface JPARepositryClass extends JpaRepository<EntityClassForIntiation, Integer> {
    boolean existsByBeneaccountnumberAndBenecurrencyAndSubproduct(String beneaccountnumber, String benecurrency, String subproduct);
}

