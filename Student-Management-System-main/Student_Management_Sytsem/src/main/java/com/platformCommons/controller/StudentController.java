package com.platformCommons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platformCommons.dto.AddressDto;
import com.platformCommons.dto.CourseDto;
import com.platformCommons.dto.StudentDto;
import com.platformCommons.exception.AddressException;
import com.platformCommons.exception.CourseException;
import com.platformCommons.exception.StudentException;
import com.platformCommons.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
    
	@Autowired
	private StudentService studentService;
	
	//save student
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto studentDto)throws StudentException{
		return new ResponseEntity<StudentDto>(studentService.registerStudent(studentDto),HttpStatus.CREATED);
	}
	
	//get list of student
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/allStudents")
	public ResponseEntity<List<StudentDto>> getAllStudent() throws StudentException{
	
		return ResponseEntity.ok(this.studentService.getAllStudent());
	}
	
	//student list by name
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/studentname")
	public ResponseEntity<List<StudentDto>> getStudentByName(@RequestParam("name") String name) throws StudentException{
		List<StudentDto> list = studentService.getStudentsByName(name);
		return ResponseEntity.ok(list);
	}

//	//get student by id
	@GetMapping("/studentid/{id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Integer id) throws StudentException{
		StudentDto stud = studentService.findStudentById(id);
				return ResponseEntity.ok(stud);
	}
	//update student by id
	@PutMapping("/update/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto , @PathVariable Integer studentId) throws StudentException{
		StudentDto updatedStud = studentService.updatStudentById(studentDto,studentId);
		return ResponseEntity.ok(updatedStud);
	}
	
	//add new address
	@PutMapping("/add/newAdress/{studentId}")
	public ResponseEntity<StudentDto> addNewAddress(@Valid @RequestBody AddressDto addressDto , @PathVariable Integer studentId)throws AddressException{
		return ResponseEntity.ok(studentService.addnewAdd(addressDto, studentId));
	}
	
	//update address
	@PutMapping("/update/Adress/{studentId}")
	public ResponseEntity<StudentDto> updateAddress(@Valid @RequestBody AddressDto addressDto , @PathVariable Integer studentId)throws AddressException{
		return ResponseEntity.ok(studentService.addnewAdd(addressDto, studentId));
	}
	
	//add course to student
	@GetMapping("/courses")
	public ResponseEntity<List<CourseDto>> getStudentCourse(@Valid @RequestParam Integer studentId) throws CourseException{
		List<CourseDto> courseAssign = studentService.getCourseAssign(studentId);
		return ResponseEntity.ok(courseAssign);
	}
	
	//leave course
	@DeleteMapping("/courses")
	public ResponseEntity<StudentDto> leaveCourse(@Valid @RequestParam Integer courseId , @RequestParam Integer studentId)throws CourseException{
		 StudentDto studentDtos = studentService.leaveCourse(courseId, studentId);
		 return ResponseEntity.ok(studentDtos);
	}

}
