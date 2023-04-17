package com.platformCommons.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.platformCommons.model.Address;
import com.platformCommons.model.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	private Integer studentId;
	
	@NotBlank
	@NotEmpty @NotNull
	@Size(min = 3 , max = 50 , message = "name size should be of min 3 chars and max 50 chars")
	private String name;
	
	@NotBlank
	@NotEmpty @NotNull
	@Size(min = 3 , max = 50 , message = "name size should be of min 3 chars and max 50 chars")
	private String fatherName;
	
	@Email
	private String email;

	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender; 
	
	private List<Address> address = new ArrayList<>();
	
}
