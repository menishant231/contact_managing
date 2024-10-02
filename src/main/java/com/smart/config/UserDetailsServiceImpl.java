package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.dao.UserRepository;
import com.smart.entities.Users;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository user2;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user3= user2.getUserByUserName(username);
		if (user3 == null) {
            throw new UsernameNotFoundException("User not found");
        }
		
		CustomUserDetails cd = new CustomUserDetails(user3);
		return cd;
		
	}
	
	

}
