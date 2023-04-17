package com.platformCommons.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformCommons.model.Admin;

public interface AdminRepo  extends JpaRepository<Admin, Integer>{
     
	

	Optional<Admin> findByEmail(String email);
}
