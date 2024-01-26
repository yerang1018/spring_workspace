package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
@RequestMapping("/member")		//	: 	/member/list
public class MemberController {
	
	@Autowired private MemberService memberService;
	
	
	@GetMapping("/list")		//	: 	/member/list
	public ModelAndView memberList() {
		//	ModelAndView 에서도 viewName 을 비워두면 void와 마찬가지로 작동
		//	요청주소를 구성하는 문자열을 viewName 으로 활용
		// 	"WEB_INF/views/member/list.jsp"
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = memberService.getMemberList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/{idx}")		//		/member 부분은 RequestMapping 으로 처리되어 있으니까 굳이 앞에 /member 안해도됨
	public ModelAndView member(@PathVariable("idx") int idx) {
		//	PathVariable 을 사용한다면 반드시  viewName 을 지정한다
		//	요청 주소가 제각각이므로, JSP의 이름을 고정 시켜야한다
		ModelAndView mav = new ModelAndView("/member/info");
		MemberDTO dto = memberService.getMember(idx);
		mav.addObject("dto", dto);
		return mav;
		
	}
	
	@GetMapping("/login")		//	Get 으로 들어오면 jsp 페이지만 띄워주고 끝나니까, 내용이 없어도 된다 
	public void login() {}
	
	@PostMapping("/login")		//	form 에 작성한 내용을 받고 나서의 처리 
	public String login(MemberDTO dto, HttpSession session) {	//	session 은 service로 넘어가지 않기 때문에
		MemberDTO login = memberService.login(dto);				//	파라미터를 하나로 묶어서 보내지 않아도 된다 
		session.setAttribute("login", login);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();		//	세션 만료시킨 후 
		return "redirect:/";		//	바로 대문페이지로 리다이렉트 
	}
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")		//	form 에 작성한 내용을 받고 나서의 처리 
	public String join(MemberDTO dto) {
		int row = memberService.add(dto);
		
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/member/login";	
		
	}
	
	
	@GetMapping("/delete/{idx}")			//	요청에서는 @RequestMapping("/member") 사용가능하지만 
	public String delete(@PathVariable("idx") int idx) {		//	반환형 정해주기 애매하면 String 으로 해주기 
		int row = memberService.delete(idx);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		return "redirect:/member/list";		//	응답에서는 사용할 수 없다 
	}
	
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/member/modify");
		MemberDTO dto = memberService.getMember(idx);
		mav.addObject("dto", dto);

		return mav;
	}
	
	
	@PostMapping("/modify/{idx}") 
	public String modify(MemberDTO dto) {
		
		//	Mapping의 {idx} 는 DTO 의 필드이름과 일치하면 자동으로 값이 입력됨 (@PathVariable 를 활용하기)
		System.out.println(dto.getIdx());	//	출력 해보면 똑같이 나오는것을 알 수 있다
		
		int row = memberService.modify(dto);
		System.out.println(row != 0 ? "수정 성공" : "수정실패");
		
		
		return "redirect:/member/{idx}";	//	Mapping 의 {idx} 는 리다이렉트 경로로 사용할 수 있다
	}
	
	@GetMapping("/resetPass") 
	public void resetPass() {}
	
	@PostMapping("/resetPass") 
	public ModelAndView resetPass(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		String pass = memberService.resetPass(dto);
		
		mav.addObject("msg", "변경된 비밀번호는 [" + pass + "] 입니다");
		mav.addObject("url", pass != null ? "/member/login" : "");
		return mav;
	}
	
	
}
