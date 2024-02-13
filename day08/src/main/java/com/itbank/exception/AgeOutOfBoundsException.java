package com.itbank.exception;


public class AgeOutOfBoundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "나이의 값이 범위를 초과합니다";
	}
	
}
