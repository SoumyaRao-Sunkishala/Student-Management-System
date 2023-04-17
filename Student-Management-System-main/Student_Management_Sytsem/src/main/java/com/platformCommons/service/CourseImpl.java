package com.platformCommons.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformCommons.dto.CourseDto;
import com.platformCommons.dto.StudentCourseDto;
import com.platformCommons.dto.StudentDto;
import com.platformCommons.exception.CourseException;
import com.platformCommons.exception.StudentException;
import com.platformCommons.model.Course;
import com.platformCommons.model.Student;
import com.platformCommons.repo.CourseRepo;
import com.platformCommons.repo.StudentRepo;

@Service
public class CourseImpl implements CourseService{
	
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
   //add course
	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		Course course = this.modelMapper.map(courseDto, Course.class);
		Course saveCourse = this.courseRepo.save(course);
		return this.modelMapper.map(saveCourse, CourseDto.class);
	}


    //find course by topic
	@Override
	public List<CourseDto> getCourseByTopic(String topic) throws CourseException {
		List<Course> courses = courseRepo.findByTopics(topic);
		List<CourseDto> list = new ArrayList<>();
		list = courses.stream().filter(course -> course.getTopics().contains(topic)).map(course -> this.modelMapper.map(course, CourseDto.class))
		.collect(Collectors.toList());
		return list;
	}
	//remove course
	@Override
	public CourseDto removeCourseById(Integer courseId) throws CourseException{
		Course course = courseRepo.findById(courseId).orElseThrow(() -> new CourseException("Invalid CourseId "+courseId));
		courseRepo.delete(course);
		return this.modelMapper.map(course, CourseDto.class);
	}

	//add course
	@Override
	public StudentCourseDto commitCourseToStudent(Integer studentId, Integer courseId) throws CourseException ,StudentException{
		Course course = courseRepo.findById(courseId).orElseThrow(() -> new CourseException("Invalid courseId "+ courseId));
		Student student = studentRepo.findById(courseId).orElseThrow(() -> new StudentException("Invalid studentId "+ studentId));
		 course.getStudents().add(student);
		 student.getCourses().add(course);
		 
		 StudentCourseDto studentCourseDto = this.modelMapper.map(studentRepo.save(student),StudentCourseDto.class);
		 
		List<CourseDto> courseDtos = student.getCourses().stream().map(c -> this.modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
		 
		 studentCourseDto.setCourses(courseDtos);
		return studentCourseDto;
	}

	//student by course id
	@Override
	public List<StudentDto> getStudentByCourseId(Integer courseId) throws CourseException {
		Course course = courseRepo.findById(courseId).orElseThrow(() -> new CourseException("Invalid courseId "+ courseId));
		List<Student> list = course.getStudents();
		List<StudentDto> studentDtos = list.stream().map(stud -> this.modelMapper.map(list, StudentDto.class)).collect(Collectors.toList());
		if(studentDtos.isEmpty()) {
			throw new CourseException("No student is committed with course "+ course.getCourseName());
		}
		return studentDtos;
	}

	//course by name
	@Override
	public List<CourseDto> findByCourseName(String courseName) {
		List<Course> course = courseRepo.findByCourseName(courseName);
		
		List<CourseDto> courseDtos = course.stream().map(c -> this.modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
		if(courseDtos.isEmpty()) {
			throw new CourseException("Invalid CourseName");
		}
		return courseDtos;
	}

}
