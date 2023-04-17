package com.platformCommons.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformCommons.dto.AddressDto;
import com.platformCommons.dto.CourseDto;
import com.platformCommons.dto.StudentDto;
import com.platformCommons.exception.AddressException;
import com.platformCommons.exception.CourseException;
import com.platformCommons.exception.InvalidCredentials;
import com.platformCommons.exception.StudentException;
import com.platformCommons.model.Address;
import com.platformCommons.model.Course;
import com.platformCommons.model.Student;
import com.platformCommons.repo.AddressrRepo;
import com.platformCommons.repo.CourseRepo;
import com.platformCommons.repo.StudentRepo;

@Service
public class StudentImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private AddressrRepo addressrRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	//save student
	@Override
	public StudentDto registerStudent(StudentDto studentDTO) {
		Student student = this.modelMapper.map(studentDTO, Student.class);
		Student savestudent = this.studentRepo.save(student);
		return this.modelMapper.map(savestudent, StudentDto.class);
	}

	//get student by id
	@Override
	public StudentDto findStudentById(Integer studentId) {
		Student student = this.studentRepo.findByStudentId(studentId).orElseThrow(()-> new StudentException("Student not found"+studentId));
		return this.modelMapper.map(student, StudentDto.class);
	}

	//get list of student by name
	@Override
	public List<StudentDto> getStudentsByName(String sname) throws StudentException  {
		List<Student> findStudent = this.studentRepo.findByName(sname);
		List<StudentDto> studentDtos = findStudent.stream().map((stud) -> this.modelMapper.map(findStudent, StudentDto.class)).collect(Collectors.toList());
		if(studentDtos.isEmpty()) {
			throw new StudentException("No student found with given name" + sname);
		}
		return studentDtos;
	}

	//update student details by id Can update profile details such as (email, mobile number , parents name,address)
	@Override
	public StudentDto updatStudentById(StudentDto studentDto, Integer studentId) throws StudentException{
		
		Optional<Student> sid = studentRepo.findById(studentId);
		if(sid.isPresent()) {
			Student st = sid.get();
			st.setEmail(studentDto.getEmail());
			st.setMobileNumber(studentDto.getMobileNumber());
			st.setFatherName(studentDto.getFatherName());
			studentRepo.save(st);
			return this.modelMapper.map(st, StudentDto.class);
		}else {
			throw new StudentException("Student not found with id" + studentId);
		}
		
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> findStudent = studentRepo.findAll();
		List<StudentDto> studentDtos = findStudent.stream().map((stud)-> this.modelMapper.map(findStudent,StudentDto.class)).collect(Collectors.toList());
		return studentDtos;
	}

	//update addresss
	@Override
	public StudentDto updateStudentAddress(AddressDto addressDto, Integer student_Id) {
		Student student = validateStudentId(student_Id);
		List<Address> list = student.getAdddress();
		
		for(Address address : list) {
			if(address.getAddressId().equals(addressDto.getAddress().getAddressId())) {
				addressrRepo.save(addressDto.getAddress());
			}
		}
		Student updateAddress = studentRepo.findById(student.getStudentId())
				.orElseThrow(()-> new AddressException("Invalid studentid " + student.getStudentId()));
		return this.modelMapper.map(updateAddress, StudentDto.class);
	}

	//add new address
	@Override
	public StudentDto addnewAdd(AddressDto addressDto, Integer studentId) {
		Student student = validateStudentId(studentId);
		List<Address> list = student.getAdddress();
		List<Address> address = list.stream().filter(add -> add.getAddressType()
				.equals(addressDto.getAddress().getAddressType())).collect(Collectors.toList());
		
		if(!address.isEmpty()) {
			throw new AddressException("Given Address "+ addressDto.getAddress().getAddressType()+" is already added. Please add new address.");
		}
		
		student.getAdddress().add(addressDto.getAddress());
		Student updatedStud = studentRepo.save(student);
		return this.modelMapper.map(updatedStud, StudentDto.class);
	}

	public Student validateStudentId(Integer studentId ) {
		Optional<Student> sid  = studentRepo.findById(studentId);
		if(sid.isPresent()) {
			Student stud = sid.get(); 
			return stud;
		}else {
			throw new InvalidCredentials("Invalid StudentId");
		}
	}

	//course admit
	@Override
	public List<CourseDto> getCourseAssign(Integer studentId) {
		Student student = validateStudentId(studentId);
		List<Course> courses = student.getCourses();
		List<CourseDto> courseDtos = courses.stream().map(course -> modelMapper.map(course, CourseDto.class)).collect(Collectors.toList());
		if(courseDtos.isEmpty()) {
			throw new CourseException("No course assigned to Student with studentId : " +  studentId);
		}
		return courseDtos;
	}

	//leave course
	@Override
	public StudentDto leaveCourse(Integer courseId, Integer studentId) {
	
		Student student = validateStudentId(studentId);
		Course course = courseRepo.findById(studentId).orElseThrow(() -> new CourseException("course doesnt exists with given courseId: +" + courseId));
		if(student.getCourses().contains(course)) {
			student.getCourses().remove(course) ;
		}
		
		if(course.getStudents().contains(student)) {
			course.getStudents().remove(student) ;
		}
		else {
			throw new CourseException("Course with given course Id "+ courseId+ " not assigned to the student with studentId : " + studentId);
		}
		
		Student savestud = studentRepo.save(student);
		
		return this.modelMapper.map(savestud,StudentDto.class);
	}

}
