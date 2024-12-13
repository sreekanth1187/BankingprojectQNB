package com.codingclub.banking.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.codingclub.banking.entity.UserCreationMaster;

public class UsercreationUseerDetails  implements UserDetails{

	private String loginid;
	private String password;
	private List<GrantedAuthority> authorities;
	
	
	public UsercreationUseerDetails(UserCreationMaster usercreationmaster) {
		
		this.loginid = usercreationmaster.getLoginid();
		this.password = usercreationmaster.getPassword();
		this.authorities = Arrays.stream(usercreationmaster.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password ;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return loginid;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
