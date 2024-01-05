package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repotiroty.StudentRepository;


@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private StudentRepository studentRepository;

	// JPA로 insert
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {

		StudentEntity student = StudentEntity.builder() // builder 세팅 열기
				.name(name).phoneNumber(phoneNumber).email(email).dreamJob(dreamJob).createdAt(ZonedDateTime.now()) // @UpdateTimeStamp가
																													// 있으면
																													// 생략
																													// 가능
				.build(); // builder 닫기
		return studentRepository.save(student); // select한 완벽한 data를 return
	}

	// Mybatis로 insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
