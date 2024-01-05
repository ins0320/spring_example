package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// c: create
	@GetMapping("/ex01/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber = "01011112222";
		String email = "bada@naver.com";
		String dreamjob = "개발자";
		
		// 방금 인서트된 pk id로 바로 얻어낼 수 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamjob);
	}
}
