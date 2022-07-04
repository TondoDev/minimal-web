package org.tondo.security.demo.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1, "Ignac"),
			new Student(2, "Peter"),
			new Student(3, "Rado"),
			new Student(4, "Miso")
			);
	
	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return STUDENTS.stream()
				.filter(s -> s.getStudentId().equals(studentId)).findFirst()
				.orElseThrow(() -> new IllegalStateException("Student with Id '"+ studentId + "' doesn't exist!"));
	}
}
