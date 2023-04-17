package com.platformCommons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.platformCommons.dto.AdminDto;
import com.platformCommons.service.AdminService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
   
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin/register")
	public ResponseEntity<AdminDto> saveAdmin(@Valid @RequestBody AdminDto adminDto){
		return new ResponseEntity<AdminDto>(adminService.registerAdmin(adminDto),HttpStatus.CREATED);
	}
}

