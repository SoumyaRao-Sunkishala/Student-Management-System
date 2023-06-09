package com.app.Java.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Java.Model.Course;


@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

	
	List<Course> findByTopics(String topics);
	
	List<Course> findByCourseName(String courseName);
}
