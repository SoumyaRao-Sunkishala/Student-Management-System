package com.app.Java.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Java.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	Optional<Student>  findByStudentId(Integer studentId);
	
	
	 List<Student>  findByName(String name); 
}
