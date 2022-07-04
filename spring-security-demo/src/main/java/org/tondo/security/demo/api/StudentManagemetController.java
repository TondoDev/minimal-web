package org.tondo.security.demo.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagemetController {
	
	// TODO: refactor wotith StudenController
	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1, "Ignac"),
			new Student(2, "Peter"),
			new Student(3, "Rado"),
			new Student(4, "Miso")
			);
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public List<Student> getAllStudends() {
		return STUDENTS;
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public void registerNewStudent(@RequestBody Student newStudent) {
		System.out.println("Register a new Student: " + newStudent.getStudentName());
	}
	
	@DeleteMapping("{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer studentId) {
		System.out.println("deleting student " + studentId);
	}
	
	@PutMapping("{studentId}")
	public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
		System.out.println("Updating student id " + studentId);
	}

}
