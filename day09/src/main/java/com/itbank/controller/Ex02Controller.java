package com.itbank.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbank.service.Ex01Service;

@Controller
public class Ex02Controller {

	@Autowired private Ex01Service service;
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@GetMapping(value="/ex02/js", produces="application/json; charset=utf-8")
	@ResponseBody			//	컨트롤러의 함수가 viewName 을 반환하지 않고, 응답 그 자체를 반환함 (반환값이 문자열이니까, 우리가 필요한건 문자열 그 자체)
	public String ex02Js() throws MalformedURLException, IOException {
		String json = service.getFastivalJSON();	//	service 에서 getFastivalJSON 함수를 부르면 반환값이 "문자열"임 
		return json;
	}
}
