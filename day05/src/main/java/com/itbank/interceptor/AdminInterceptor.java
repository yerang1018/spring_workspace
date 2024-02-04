package com.itbank.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.itbank.model.MemberDTO;

public class AdminInterceptor implements HandlerInterceptor{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("1. 관리자 계정 로그인 확인용 : preHandle");
		
		HttpSession session = request.getSession();
		
//		String url = request.getRequestURL().toString();
	//	String msg = "관리자 계정만 접근가능합니다.\n";
		
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		
		if(dto == null || dto.getUserid().equals("admin") == false) {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/alert2.jsp");
			
			request.setAttribute("url", "/");
			request.setAttribute("msg", "관리자 계정만 접근가능");
			rd.forward(request, response);
		
			return false;
		}
		return true;
	}
}
