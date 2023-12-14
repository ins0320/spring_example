package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository // spring bean 으로 등록
public interface UsedGoodsMapper {

	// input: X (BO로부터 받아오는 것), 조건 없음
	// output: (Service한테 주는 것) List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
}
