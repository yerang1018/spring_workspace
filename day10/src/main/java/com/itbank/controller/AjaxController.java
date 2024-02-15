package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;


//	Ajax 이용한 코드들은 @RestController 선언한  Controller에 모아두기 !! 


@RestController		//	문서 내용을 응답하지 않고, 순수 데이터를 응답하기 위한 AJAX 전용 컨트롤러
					//	모든 함수에 자동으로 @ResponseBody 가 적용된다 (포워드 및 리다이렉트가 기본값이 아님)
					//	포워딩을 안함. 요청 받은 그대로를 전달함 

public class AjaxController {

	
	@Autowired private MemberService service;
	
	
	//	AJAX 요청에 대응하는 컨트롤러 함수는 기본 자료형 배열, 리스트, 맵, DTO 등 여러타입을 반환할 수 있다
	//	반환값이 viewName 이 아닌, 응답 그 자체임을 명시해야한다 
	@GetMapping("/ex01Ajax")
	@ResponseBody
	public int ex01Ajax(int n1, int n2) {
		return n1 + n2;
	}
	
	
	
	@PostMapping("/ex03Ajax")
	@ResponseBody		//	@ResponseBody : 반환하는 내용 그 자체가 응답이다
	public HashMap<String, Object> ex03Ajax(@RequestBody HashMap<String, Object> param) {	//	@RequestBody : 요청에 담긴 내용이 파라미터로 그대로 사용
																							//	즉, 요청 그 자체가 파라미터이다
		System.out.println("userid : " + param.get("userid"));
		HashMap<String, Object> map = new HashMap<>();
		int count = service.checkDuplicate(param);
		map.put("count", count);
		map.put("msg", count != 0 ? "이미 사용중인 아이디 입니다" : "사용가능한 아이디 입니다");
		
//		String result = objectMapper.writeValueAsString(map);
//		원래는, 자바 객체를 JSON 규칙에 맞춰 문자열로 변환한 후에 반환해야하지만,
//		ObjectMapper 가 자동으로 변환을 처리함 
		
		return map;
	}
	
	
	@GetMapping("/ex04Ajax")
	public List<MemberDTO> ex04Ajax() {
		return service.getMemberList();
	}
	
	
}
