package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired private MemberService memberService;
	
	@GetMapping("/join")
	public void join() {}
	
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = memberService.join(dto);
		
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/member/login";
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberDTO dto, String url, HttpSession session) {
		MemberDTO login = memberService.login(dto);
		session.setAttribute("login", login);
		
		if(url == null) {
			url = "/";
		}
		return "redirect:" + url;
	}
}
