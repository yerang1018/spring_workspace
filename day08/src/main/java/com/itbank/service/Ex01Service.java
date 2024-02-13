package com.itbank.service;

import org.springframework.stereotype.Service;

import com.itbank.utils.Exp;




@Service
public class Ex01Service {


	//	java.lang.ArithmeticException: / by zero 라는 예외를 처리하기 위해서는
	//			예외를 직접 처리하지 않고, Caller 에게 예외 처리를 전가 시킴
	//			1) 예외 발생 유형과 원인을 파악해야한다
	//			2) 컨트롤러 하위의 스프링빈에서는 예외를 전가시켜서 컨트롤러까지 도달시킨다
	//			3) 즉, 컨트롤러에 예외를 어떻게 처리할지를 작성해야함 
	public int calc(int n1, String operator, int n2) throws ArithmeticException {
		int answer = 0;
		
//		if(operator.equals("+")) {		:	특정 값만 받아옴 (check 제약조건 처럼..)
//			answer = n1 + n2;
//		}
//		
//		if(operator.equals("-")) {
//			answer = n1 - n2;
//		}
//		
//		if(operator.equals("*")) {
//			answer = n1 * n2;
//		}
//		
//		if(operator.equals("/")) {
//			answer = n1 / n2;
//		}
//		
		Exp oper = Exp.valueOf(operator);	//	PLUS, MINUS, MULTI, DIVIDE 
		answer = oper.getAnswer(n1, n2);
		
		
		return answer;
	}

	
}
