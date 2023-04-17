package com.platformCommons.dto;



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
public class AdminDto {

	private Integer id;
	
	
	@NotBlank
	@NotEmpty @NotNull
	@Size(min = 3 , max = 15 , message = "name size should be of min 3 chars and max 15 chars")
	private String name;
	
	@Email
	private  String email;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	

	private String password;
	
	@NotBlank
	@NotEmpty @NotNull
	private String role;
	
	
	
}
