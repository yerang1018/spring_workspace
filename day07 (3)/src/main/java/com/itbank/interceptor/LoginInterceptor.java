package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
			System.out.println("preHandler 확인");
			HttpSession session = request.getSession();
			
			String url = request.getRequestURL().toString();
			
			if(session.getAttribute("login") == null) {
				
				String cpath = request.getContextPath();
				
				response.sendRedirect(cpath + "/member/login?url=" + url); 
				
				System.out.println("로그인 해야함");
				
				return false;
			}
			
		return true;
	}
}
