package com.platformCommons.controller;

import java.util.List;
import java.util.Set;

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

import com.platformCommons.dto.CourseDto;
import com.platformCommons.dto.StudentCourseDto;
import com.platformCommons.dto.StudentDto;
import com.platformCommons.exception.CourseException;
import com.platformCommons.exception.StudentException;
import com.platformCommons.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public ResponseEntity<CourseDto> registerCourse(@Valid @RequestBody CourseDto courseDTO) throws CourseException {
		
		CourseDto saveCourse = courseService.addCourse(courseDTO);
		
		return new ResponseEntity<CourseDto>(saveCourse,HttpStatus.CREATED);
	}
	
		//get course by topic
	@GetMapping("/topic")
	public ResponseEntity<List<CourseDto>> getCoursesByTopic(@RequestParam String topicName) throws CourseException {
		
		List<CourseDto> courses =  courseService.getCourseByTopic(topicName);
		
		return new ResponseEntity<List<CourseDto>>(courses,HttpStatus.OK);
	}

 //remove course
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/")
	public ResponseEntity<CourseDto> removeCourse(@RequestParam Integer courseId) throws CourseException {
		
		CourseDto removedCourse =  courseService.removeCourseById(courseId);
		
		return new ResponseEntity<CourseDto>(removedCourse,HttpStatus.OK) ;
	}
	
	
 	//assign course to student
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/assign")
	public ResponseEntity<StudentCourseDto> assginStudentToCourse(@RequestParam("studentId") Integer sttudentId,
																	@RequestParam("courseId") Integer courseId) throws CourseException, StudentException {
		
		StudentCourseDto assignedCourse =  courseService.commitCourseToStudent(sttudentId, courseId) ;
		return ResponseEntity.ok(assignedCourse);
	
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getStudByCourse(@RequestParam Integer courseId) throws CourseException {
		
		List<StudentDto> courseStudents =  courseService.getStudentByCourseId(courseId);
		return ResponseEntity.ok(courseStudents);
		
	}
	
	@GetMapping("/{courseName}")
	public ResponseEntity<List<CourseDto>> findCourseByName(@Valid @PathVariable String courseName)
	{
		List<CourseDto> courseset = courseService.findByCourseName(courseName);
		return ResponseEntity.ok(courseset);
		
	}
	
}
