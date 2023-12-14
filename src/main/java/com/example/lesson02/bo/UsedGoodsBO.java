package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean으로 등록
public class UsedGoodsBO {

	// input: X (따로 조건 없이 컨트롤러한테 그냥 전체를 받아온다.) 
	// output: (Repository한테 받은 것을) List<UsedGoods> (컨트롤러한테 준다)
	public List<UsedGoods> getUsedGoodsList(){ // ():input 부분 , class type: output 부분
		return;
		
	}
}
