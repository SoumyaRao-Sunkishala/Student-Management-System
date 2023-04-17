package com.platformCommons.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String name;
	private String fatherName;
	private String email;
	private String mobileNumber;
	private LocalDate dob;
	private Gender gender;
	
	@OneToMany(cascade = CascadeType.ALL )
	private List<Address> adddress = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy = "students")
	List<Course> courses = new ArrayList<>();
}
