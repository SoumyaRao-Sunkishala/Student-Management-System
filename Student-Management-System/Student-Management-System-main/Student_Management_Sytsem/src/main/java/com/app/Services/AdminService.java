package com.app.Services;

import com.app.Java.Dto.AdminDto;
import com.app.Java.Exception.AdminException;

public interface AdminService {
  
	public AdminDto registerAdmin(AdminDto userDTO) throws AdminException;
	
	
	
}
