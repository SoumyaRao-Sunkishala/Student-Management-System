package com.platformCommons.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;

	private String courseName;
	private String description;
	private String courseType;
	private String duration;
	private String topics;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Student> students = new ArrayList<>();
}
