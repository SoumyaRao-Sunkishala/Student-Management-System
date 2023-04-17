package com.platformCommons.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.platformCommons.dto.CourseDto;
import com.platformCommons.dto.StudentCourseDto;
import com.platformCommons.dto.StudentDto;
import com.platformCommons.exception.CourseException;
import com.platformCommons.exception.StudentException;

@Component
public interface CourseService {

	CourseDto addCourse(CourseDto courseDto);
	
	List<CourseDto> getCourseByTopic(String topic)throws CourseException;

    CourseDto removeCourseById(Integer courseId)throws CourseException;
	
    StudentCourseDto commitCourseToStudent(Integer studentId , Integer courseId) throws CourseException , StudentException;

	List<StudentDto> getStudentByCourseId(Integer courseId) throws CourseException;

	List<CourseDto> findByCourseName(String courseName);
}
 