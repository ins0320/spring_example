package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean으로 등록
public class UsedGoodsBO {
	
	@Autowired //Dependanct Injection (DI): 의존성 주입(스프링 빈을 가져오겠다.)
	private UsedGoodsMapper usedGoodsMapper; // Spring Bean을 가져온다.
	
	// input: X (따로 조건 없이 컨트롤러한테 그냥 전체를 받아온다.) 
	// output: (Repository한테 받은 것을) List<UsedGoods> (컨트롤러한테 준다)
	public List<UsedGoods> getUsedGoodsList(){ // ():input 부분 , class type: output 부분
		return usedGoodsMapper.selectUsedGoodsList(); //repository에게 가져온 값을 컨트롤러에게 넘겨줌
		
	}
}
