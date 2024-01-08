package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;


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

	// JPA로 업데이트
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		
		// select
		StudentEntity student = studentRepository.findById(id).orElse(null); // 객체를 가져왔을 때, 존재하면 객체를 없다면 null을 반환
		
		// update - save
		if(student != null) {
			student = student.toBuilder() // 기존 필드값 유지, dreamJob만 변경
				.dreamJob(dreamJob)
				.build();  // 반드시 다시 저장한다!!
			
			// update
			student = studentRepository.save(student);
		}	
		
		return student; // student or null (update 실패시 null)
	}
	
	// JPA로 delete
	public void deleteStudentById(int id) {
		// select
		// 방법1)
//		StudentEntity student =  studentRepository.findById(id).orElse(null);
//		if(student != null) { // null이 아닐때 삭제
//			studentRepository.delete(student);
//		}
		 // delete
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
