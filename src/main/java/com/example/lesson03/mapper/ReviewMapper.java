package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {

	public Review selectReview(int id);
	
	// input: Review  output: 성공한 행의 개수(int)
	// 파라미터가 하나면 map으로 감쌀 필요 없다: @Param X!
	public int insertReview(Review review);
	
	public int insertReviewAsFiled(
			// 여러개의 파라미터를 map으로 감싸주는 @Param
			@Param("storeId") int storeId1
			,@Param("menu") String menu1
			,@Param("userName") String userName
			,@Param("point") Double point
			,@Param("review") String review		
			);
	
	// input: id, review     output: 성공한 행의 개수
	public int updateReviewById(
			@Param("id") int id
			,@Param("review") String review);
}
