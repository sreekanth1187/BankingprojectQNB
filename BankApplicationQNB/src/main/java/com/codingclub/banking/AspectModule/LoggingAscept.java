package com.codingclub.banking.AspectModule;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Aspect
@Component
public class LoggingAscept {
	
	@Autowired
	public LoggingAscept(ObjectMapper objectmapper) {
		this.objectmapper = objectmapper;
	}
	
	 private static final Logger logger = LoggerFactory.getLogger(LoggingAscept.class);
	 private ObjectMapper objectmapper;
	
	@Pointcut("execution(* com.codingclub.banking.controller.ApiController..*(..))")
	public void loggerpointcut() {
		//System.out.println("Before Invoke the method save...");
	}
	
	@Before("loggerpointcut()")
	public void pointcut(JoinPoint joinpoint) {
		//System.out.println("Before Invoke the method save...");
		System.out.println("Before invoking method: " + joinpoint.getSignature().getName());
	}
	
	 @Before("loggerpointcut()")
	    public void logBefore(JoinPoint joinPoint) {
	        Object[] args = joinPoint.getArgs();
	        try {
	            String jsonArgs = objectmapper.writeValueAsString(args);
	            System.out.println("Before objectmapper method: " + joinPoint.getSignature().getName() + " with arguments: " + jsonArgs);
	        } catch (Exception e) {
	        	System.out.println("Error logging method arguments"+ e);
	        }
	    }
	
	@AfterReturning(pointcut = "loggerpointcut()", returning = "intiation"  )
    public void logAfterReturning(JoinPoint joinPoint, Object intiation) throws JsonProcessingException {
		
		String jsonArgs = objectmapper.writeValueAsString(intiation);
		System.out.println("Method executed: " + joinPoint.getSignature().getName());
		System.out.println("Return value intiation : " + intiation + "  jsonArgs :: "+ jsonArgs);
    }
	

	
}
