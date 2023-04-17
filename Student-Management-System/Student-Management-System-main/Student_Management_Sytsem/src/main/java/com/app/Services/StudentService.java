package com.app.Services;

import java.util.List;

import com.app.Java.Dto.AddressDto;
import com.app.Java.Dto.CourseDto;
import com.app.Java.Dto.StudentDto;
import com.app.Java.Exception.StudentException;
import com.app.Java.Model.Student;


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
