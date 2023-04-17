package com.app.Java.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Java.Model.Admin;

public interface AdminRepo  extends JpaRepository<Admin, Integer>{
     
	

	Optional<Admin> findByEmail(String email);
}
