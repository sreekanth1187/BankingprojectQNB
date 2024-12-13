package com.codingclub.banking.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigurationBean {

	@Bean
	public TestBean Beanmethod() {
		return new TestBean();
	}
	
	
	
}
