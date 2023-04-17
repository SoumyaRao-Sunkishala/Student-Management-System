package com.platformCommons.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseDto {
    
	private Integer StudentId;
	private String name;
	
	private List<CourseDto> courses = new ArrayList<>();
}
