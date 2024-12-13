package com.codingclub.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.codingclub.banking.entity.UserCreationMaster;
import com.codingclub.banking.repositry.UserCreationJPA;
import com.codingclub.banking.security.UsercreationUseerDetails;

@Component
public class UserDetailservice  implements UserDetailsService{

	@Autowired
	private UserCreationJPA usercreationjpa; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<UserCreationMaster> usercreation=	usercreationjpa.findByLoginid(username);
	   return usercreation.map(UsercreationUseerDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("User not found exception " + username ));
		
	}

}
