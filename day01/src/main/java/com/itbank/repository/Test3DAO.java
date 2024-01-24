package com.itbank.repository;

import java.sql.Date;

import org.apache.ibatis.annotations.Select;


//	인터페이스의 함수는 내용을 적을 수 없음 


//	인터페이스는 기본 생성자로 객체생성할 수 없기 때문에 
// @Repository		:	스프링빈으로 설정할 필요가 없다
public interface Test3DAO {

	
	//	sqlSessionTemplate 를 직접 참조할때와 같이 xml mapper 를 사용하는 방법
	//	namespace : package + Interface Name (com.itbank.repository.Test3DAO)
	//	id : 함수이름 (selectBanner)
	
	String selectBanner();	//	함수 내용을 작성할 수 없는 [추상 메서드]
	//	나 대신, 직접 sql 구문을 생성하는 프록시 구문

	
	//	간단한 sql구문을 어노테이션으로 처리하여 mapper 를 생략할 수 있음
	@Select("select sysdate from dual")
	Date selectSysdate();

	
}
