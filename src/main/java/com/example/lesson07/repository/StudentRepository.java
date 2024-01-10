package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;



public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// Spring data JPA
	
	// 기본 제공 메소드
	// 엔티티 객체 save(엔티티) -> 1.insert(id가 null), 2.update(객체 or null)
	// Optional<엔티티객체> findById(id);
	// void delete(엔티티객체);
	// List<엔티티객체>
	
	// ex02/1 JPQL(함수이름을 잘 만들어 놓으면, SQL 구문처럼 사용 할 수 있다.)
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();	
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContaining(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	
	// ex02/2 - JPQL(Entity에 조회)
	// @Query(value="select st from StudentEntity st where st.dreamJob =:dreamJob") // JPQL(엔티티조회), entity 조회문(!! 쿼리문 아님) , * -> 별칭, table 명-> entity명, StudentEntity st-> StudentEntity AS st
	@Query(value="select * from new_student where dreamJob=:dreamJob" , nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob); // @Param -> ibatis 아닌 쿼리 param
}
