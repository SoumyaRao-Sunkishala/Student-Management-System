package com.app.Services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.app.Java.Dto.CourseDto;
import com.app.Java.Dto.StudentCourseDto;
import com.app.Java.Dto.StudentDto;
import com.app.Java.Exception.CourseException;
import com.app.Java.Exception.StudentException;

@Component
public interface CourseService {

	CourseDto addCourse(CourseDto courseDto);
	
	List<CourseDto> getCourseByTopic(String topic)throws CourseException;

    CourseDto removeCourseById(Integer courseId)throws CourseException;
	
    StudentCourseDto commitCourseToStudent(Integer studentId , Integer courseId) throws CourseException , StudentException;

	List<StudentDto> getStudentByCourseId(Integer courseId) throws CourseException;

	List<CourseDto> findByCourseName(String courseName);
}
 