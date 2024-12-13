package com.codingclub.banking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BankApplicationQnbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplicationQnbApplication.class, args);
		
	
	}

	@Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
