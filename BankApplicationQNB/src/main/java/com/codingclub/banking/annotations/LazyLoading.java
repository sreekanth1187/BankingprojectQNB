package com.codingclub.banking.annotations;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyLoading {

	public LazyLoading() {
		
		System.out.println("Lazy Loading Class Invoked...");
	}

	
	
}
