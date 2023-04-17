package com.platformCommons.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformCommons.dto.AdminDto;
import com.platformCommons.exception.AdminException;
import com.platformCommons.model.Admin;
import com.platformCommons.repo.AdminRepo;

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
