package com.platformCommons.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

	private Integer courseId;

	@NotBlank
	@NotEmpty @NotNull
	@Size(min = 3 , max = 40 , message = "name size should be of min 3 chars and max 40 chars")
	private String courseName;
	
	@NotBlank
	@NotEmpty @NotNull
	@Size(min = 3 , max = 225 , message = "description size should be of min 3 chars and max 225chars")
	private String description;
	
	@NotBlank
	@NotEmpty @NotNull
	private String courseType;
	
	@NotBlank
	@NotEmpty @NotNull
	private String duration;
	
	@NotBlank
	@NotEmpty @NotNull
	private String topics;
}
