package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01") //공통 주소
@RestController // @Controller + @ResponseBody
public class Lesson01Ex01RestController {
 
	// URL: http://localhost.lesson01/ex01/03
	@RequestMapping("/03")
	public String ex01_03(){
		return "@RestController를 이용하여 string 리턴";
	}
	
	// URL: http://localhost.lesson01/ex01/04
	@RequestMapping("/04")
	public Map<String, String> ex01_01(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "1111");
		map.put("bbb","2222");
		map.put("ccc", "3333");
		
		return map; // => JSON
	}
	
	// URL: http://localhost.lesson01/ex01/05
	@RequestMapping("/05")
	public Data ex01_05() {
		Data data = new Data(); // 일반 자바 bean(객체)
		data.setId(10);
		data.setName("신보람");
		
		return data; // 일반 bean 객체도 JSON으로 변환된다.
	}
	
	// URL: http://localhost.lesson01/ex01/06
		@RequestMapping("/06")
		public ResponseEntity<Data> ex01_06(){
			Data data = new Data();
			data.setId(11);
			data.setName("바다");
			
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // ok-200, Internal_server_error-500
		}
}
