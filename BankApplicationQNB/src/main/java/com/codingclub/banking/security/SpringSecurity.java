package com.codingclub.banking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;

import com.codingclub.banking.service.UserDetailservice;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurity  {
	
	
	@Bean
	// This is all about authentication 
	public UserDetailsService detailsService() {
		
		//UserDetails admin  = User.withUsername("ALIENMKR1")
		//		.password(encoder.encode("test@12"))
		//		.roles("ADMIN")
		//		.build();
		
		//UserDetails user  = User.withUsername("Sreekanth")
		//		.password(encoder.encode("pwd"))
		//		.roles("ADMIN")
		//		.build();
		
	//	return new InMemoryUserDetailsManager(admin,user);
		
		return new UserDetailservice();
		
		
	}
	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		return httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/api/WelCome","/api/usercreation").permitAll().and()
				.authorizeHttpRequests().requestMatchers("/api/**").authenticated().and().formLogin().and().build();

	}
	@Bean
	public AuthenticationProvider authenticationprovider() {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(detailsService());
		authenticationProvider.setPasswordEncoder(passwordencoder());
		return authenticationProvider;
	}
	 
}


