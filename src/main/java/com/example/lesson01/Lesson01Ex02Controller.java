package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// JSP로 보내는 컨트롤러
@Controller // @ResponseBody가 있으면 안된다!!(@RestController도 안됨)
public class Lesson01Ex02Controller {

	// url: http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // Request path 주소!!
	public String ex02() {
		//return 되는 String은 jsp의 경로이다.(@ResponseBody가 없을 때: html로 인식하기에)
		return "lesson01/ex02"; // Response view 경로!!  (prefix=/WEB-INF/jsp/ 와 suffix=.jsp 로 설정되어 앞 끝 부분 생략함)
	}
	
}
