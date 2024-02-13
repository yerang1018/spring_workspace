package com.itbank.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.service.Ex01Service;

@Controller
public class Ex01Controller {
	
	@Autowired private Ex01Service service;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	//	함수 내용은 똑같지만, 함수이름만 다름 
	@GetMapping("/ex01/js")
	public ModelAndView ex01Js() throws MalformedURLException, IOException {
		ModelAndView mav = ex01();
		mav.setViewName("ex01-js");
		return mav;
	}
	
	
	@GetMapping("/ex01")
	public ModelAndView ex01() throws MalformedURLException, IOException {
		ModelAndView mav = new ModelAndView();
		
		String json = service.getFastivalJSON();		//	JSON 데이터는 문자열 
		mav.addObject("json", json);
		
		System.out.println(json);
		
		
		
		//	json 형식의 문자열을 자바 객체로 변환하기 위한 코드가 추가적으로 필요
		JsonNode node = objectMapper.readTree(json);
		JsonNode item = node.get("getFestivalKr").get("item");		//	 (원본 데이터 구조 파악하기) item 안에는 객체가 있고, 
																	//	 	객체 안에는 컬럼들이 많음(==DTO 만들기)
		
		System.out.println("item : " + item.toPrettyString());
		

		
		//	DTO 안씀 (HashMap으로 mapping하기)
		// 	javaScript 객체를 java 로 변환해야지만 
		//	jsp페이지에서 c:forEach 사용 가능 
		@SuppressWarnings("unchecked")
		List<HashMap<String, Object>> list = Arrays.asList(
				objectMapper.readValue(item.toPrettyString(), HashMap[].class)
				);
		System.out.println(list.get(0).get("MAIN_TITLE"));
		
		mav.addObject("list", list);
		
		
		
		
//		DTO 사용하기	(필드이름이 복잡해서 제대로 mapping 되지 않음)
//		List<FestivalDTO> list = Arrays.asList(
//					objectMapper.readValue(item.toPrettyString(), FestivalDTO[].class)
//				);
//		
//		System.out.println(list.get(0).getMAIN_TITLE());

		
		return mav;
	}
	
}
