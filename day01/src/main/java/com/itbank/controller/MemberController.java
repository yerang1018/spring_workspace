package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.MemberService;

import java.util.HashMap;
import java.util.List;
import com.itbank.member.MemberDTO;

@Controller
public class MemberController {

	@Autowired private MemberService ms;
		
	@GetMapping("/member")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView("member-list");
		
		List<MemberDTO> list = ms.getMemberList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/member")
	public ModelAndView memberSearchList(@RequestParam HashMap<String, String> paramMap) {
		//	DTO 에 정의 되어 있지 않은 값을 여러개 받을 때는
		//	HashMap 을 사용할 수 있다 !!
		//	단, HashMap은 파라미터 처리외에도 다양한 기능들이 있기 때문에
		//	어노테이션 RequestParam 으로 파라미터 처리를 하라는 명시를 해주자  
		
		ModelAndView mav = new ModelAndView("member-list");
		List<MemberDTO> list = ms.getMemberSearchList(paramMap);
		mav.addObject("list", list);
		return mav;
	}
	
	
	
	//	a 태그를 이용한 이동에는 @GetMapping 으로 처리 
	@GetMapping("/member/add")	
	public ModelAndView memberAdd() {
		
		ModelAndView mav = new ModelAndView("member-add");
		return mav;
	}
	
	@PostMapping("/member/add")	
	public ModelAndView memberAdd(MemberDTO dto) {
		
		//	form 의 input name과 dto의 필드이름이 일치하다면 
		//	자동으로 파라미터가 입력된다
		ModelAndView mav = new ModelAndView("redirect:/member");
		int row = ms.add(dto);
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return mav;
	}
	
	@GetMapping("/member/delete/{idx}")
	public ModelAndView delete(@PathVariable("idx")int idx) {
		//	PathVariable (경로변수)	:	요청 주소 상의 특정 경로의 값을 정수 및 문자열 형태로 전달받아서
		//								파라미터와 유사하게 사용 가능
		//								쿼리스트링을 안써도 됨 (= url 에서 view.jsp?idx= ~~) 
		ModelAndView mav = new ModelAndView("alert");
		int row = ms.delete(idx);
		
		String message = row != 0 ? "삭제 성공" : "삭제 실패";
		String url = "/member";
		mav.addObject("message", message);
		mav.addObject("url", url);
		
		return mav;
		
	}
	
		
}
