package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	@Autowired
	private ReviewMapper reviewMapper;
	
	// input: id  output: Review ( 리스트 아닌 하나만 리턴 하니까)//ReviewMapper에서 받아옴
	public Review getReview(int id) { // null 허용 없음: int
		return reviewMapper.selectReview(id);
	}
	
	// input: Review  output: 성공한 행의 개수(int)
	public int addReview(Review review) {
		return	reviewMapper.insertReview(review);
	}
	
	// addReviewAsFiled(4, "콤비네이션R", "바다", 5.0, "역시 맛있다!");
	public int addReviewAsFiled(
			int storeId, String menu,
			String userName, Double point
			,String review) {
	
		return reviewMapper.insertReviewAsFiled(storeId, menu, userName, point, review);
	}
	
	// input: id, review     output: 성공한 행의 개수
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
}
