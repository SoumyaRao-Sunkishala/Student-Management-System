package com.platformCommons.service;

import java.util.List;


import com.platformCommons.dto.AddressDto;
import com.platformCommons.dto.CourseDto;
import com.platformCommons.dto.StudentDto;
import com.platformCommons.exception.StudentException;
import com.platformCommons.model.Student;


public interface StudentService {
	StudentDto registerStudent(StudentDto studentDTO);
	
	StudentDto findStudentById(Integer studentId)  ;
	
 	List<StudentDto> getStudentsByName(String sname) ;
 	
 	StudentDto updatStudentById(StudentDto studentDto ,Integer studentId)throws StudentException;
 	
 	List<StudentDto> getAllStudent();
 	
 	StudentDto updateStudentAddress(AddressDto addressDto , Integer student_Id) ;
 	
 	StudentDto addnewAdd(AddressDto addressDto, Integer studentId);
	
 	List<CourseDto> getCourseAssign(Integer studentId);
 	
 	StudentDto leaveCourse(Integer courseId, Integer studentId);
}
