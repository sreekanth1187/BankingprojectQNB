package com.codingclub.banking.annotations;

import org.springframework.stereotype.Component;

@Component
public class EagerLoading {

	public EagerLoading() {
		System.out.println("Eager Loading Invoked By Default....");
	}
	
	

}
