package com.smart.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.entities.Users;

public class CustomUserDetails implements UserDetails {
	
	
	private Users user1;
	
	

	public CustomUserDetails(Users user1) {
		super();
		this.user1 = user1;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user1.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user1.getEmail();
	}

}
