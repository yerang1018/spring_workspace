package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;



//	Component 는 Controller, Service, Repository 에 해당하지 않지만
//	특정 내용에 대한 코드를 수행하기 위해 작동하는 스프링 빈 
//	주로, Service에서 많이 호출하지만 다른데에서도 호출할 수 있다  
//	매번 호출하기 귀찮으니까 컴포넌트로 묶어두는것 
@Component	
public class HashComponent {
	
	//	문자열 input 을 전달받아서 sha-512 해시 알고리즘이 적용된 output 을 반환하는 함수
	//	입력값이 같으면 출력값도 같다
	//	비밀번호 일치 여부를 확인할 수 있다 ( equals()함수로 확인가능 )
	//	DB에는 해시처리된 값이 저장되므로, DB관리자도 패스워드를 확인할 수 없다
	
	
	public String getHash(String input) {
		MessageDigest md;
		
		String output = null;
		
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(input.getBytes());
			output = String.format("%0128x", new BigInteger(1, md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return output;
	}
}
