package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//	스프링 4.0 에서는 exnteds HandlerInterceptorAdapter
//	스프링 5에서는 implements HandlerInterceptor


//	HandlerInterceptor 는 인터페이스이지만, 내부함수가 default 키워드로 처리되어 있음
//	인터페이스에서 default 함수는 바디를 가질 수 있다
//	미구현된 메서드만 구현하면 된다 
//	추상 메서드가 아니라서 모든 메서드를 의무적으로 오버라이딩 할 필요는 없다 

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//	PreHandle :	요청이 컨트롤러에 도착하기 전에 요청을 가로채서 작업을 수행
		//	반환값에 따라 예정된 내용을 그대로 처리할지, 다른 내용을 수행할지 결정한다
		System.out.println("1. PreHandle");
		HttpSession session = request.getSession();
		
		String url = request.getRequestURL().toString();
		System.out.println("url : " + url);
		
		if(session.getAttribute("login") == null) {		//	만약 세션에 로그인이 없으면 
			String cpath = request.getContextPath();
			response.sendRedirect(cpath + "/member/login?url=" + url);
			System.out.println("로그인 상태가 아니므로, 로그인 페이지로 이동합니다.\n");
			return false;								//	진행 중지 == (그냥 흰색 화면만 나오니까 추가적으로 리다이렉트 걸어주기)
														//	진행 중지되고 나서는 login 페이지로 이동 
		}
		
		
		return true;
	}
	
	
	
	
	//	인터셉터를 사용할 예시 >> 
	//	쿠키 : 사용자가 웹 사이트 내에서 이용한 기록
	//	매개변수인 request 를 이용하여 request.getCookies() 로 쿠키 꺼내올 수 있고 , 그것을 ModelAndView(== jsp에 어떤 정보를 강제로 넘길 수 있음) 에 넣을 수 있다.
	//	이런 과정을 매번하는 것보다는 interceptor 를 이용하여 일괄처리할 수 있도록 만드는 것이 더 효율적임
	//	공통적으로 처리할 수 있는 내용을 담당하기 좋다
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		//	컨트롤러의 처리가 끝났고, jsp 로 넘어가기전에 작동한다
		//	jsp로 forword 가 이루어지기 전에, request, cookie, session 등에서 필요한 값을 확인하고 판별하여
		//	ModelAndView 를 이용하여 특정 데이터를 넣어주는데 활용할 수 있다
		//	header.jsp 를 사용할수도 있으나, 모든 페이지에 영향을 주기 때문에 일부페이지에만 적용하기 쉽지않다 (== 그래서 PostHandle 을 쓰자!)
		System.out.println("2. postHandle");
		mav.addObject("test1", "Hello, Interceptor");
		
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//	사용자에게 jsp의 화면이 모두 전달되고, 응답이 완료된 후에 작동함 
		//	만약, 예외가 발생한다면 로그에 기록하거나 알림을 처리할 수도 있다.
		
		//	afterCompletion 대신에 사용할 수 있는 것 >>
		//		- @ExceptionHandler,	@ControllerAdvice 는 예외를 처리하는데에 특화되어있음 
		//		-  Log4j 와 같은 로그 라이브러리도 있다 
		System.out.println("3. afterCompletion");
	}
	
}
