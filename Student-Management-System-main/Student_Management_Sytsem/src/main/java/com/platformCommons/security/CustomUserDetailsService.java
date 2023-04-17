package com.platformCommons.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.platformCommons.exception.AdminException;
import com.platformCommons.model.Admin;
import com.platformCommons.repo.AdminRepo;

class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Admin> admin = adminRepo.findByEmail(username);
		if(!admin.isPresent()) {
			throw new AdminException("Admin with given email id not found");
		}
		Admin admin2 = admin.get();
		return admin2;
		
	}
	
	

}