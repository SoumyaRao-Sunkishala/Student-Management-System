package com.app.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Java.Dto.AdminDto;
import com.app.Java.Exception.AdminException;
import com.app.Java.Model.Admin;
import com.app.Java.Repositories.AdminRepo;

@Service
public class AdminImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired(required=true)
	private ModelMapper modelMapper;

	@Override
	public AdminDto registerAdmin(AdminDto adminDTO) throws AdminException {
	
		 Admin admin = this.modelMapper.map(adminDTO, Admin.class);
		 Admin adminDtos =  this.adminRepo.save(admin);
		 return this.modelMapper.map(adminDtos, AdminDto.class);
		}


//	public Admin dtoToUser(AdminDto adminDto) {
//		return this.modelMapper.map(adminDto, Admin.class);
//	}
//	
//	public AdminDto userToDTO(Admin admin) {
//		return this.modelMapper.map(admin, AdminDto.class);
//	}
}
