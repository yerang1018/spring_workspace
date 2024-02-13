package com.itbank.utils;



interface IntOperator {			//	함수형 인터페이스를 사용하면서 제어문이 사라짐 
								
	int calc(int x, int y);
	
}


public enum Exp {

	//	private static final PLUS = "+";
	PLUS("+", (x, y) -> x + y),			//	이 함수를 실행하기 위해서  		
	MINUS("-",  (x, y) -> x - y),		//	바로 위에 함수형 인터페이스(IntOperator)가 있음
	MULTI("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y);
	
	private final String operator;
	private final IntOperator lambda;
	
	
	private Exp(String operator, IntOperator lambda) {
		this.operator =	operator; 
		this.lambda = lambda;
	}

	public String getOperator() {
		return operator;
	}
	
	public int getAnswer(int x, int y) {
		return lambda.calc(x, y);
	}
	
}
