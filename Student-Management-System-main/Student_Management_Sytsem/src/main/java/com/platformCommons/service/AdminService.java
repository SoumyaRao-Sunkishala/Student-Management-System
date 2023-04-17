package com.platformCommons.service;

import com.platformCommons.dto.AdminDto;
import com.platformCommons.exception.AdminException;

public interface AdminService {
  
	public AdminDto registerAdmin(AdminDto userDTO) throws AdminException;
	
	
	
}
