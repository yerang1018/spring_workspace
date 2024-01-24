package com.itbank.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.repository.Test3DAO;

@Service
public class TestService {
	
//	@Autowired private TestDAO testDAO;		//	mybatis 안쓰고 DAO 써서 처리해보기(JdbcTemplate)

//	@Autowired private Test2DAO test2DAO;	//	mybatis 사용해서 (sqlSessionTemplate)
	
	
	
	@Autowired private Test3DAO test3DAO;	//	mapper auto injection (myBatis-spring)
	
	public String getDBVersion() {
		String version = test3DAO.selectBanner();
		return version;
	}

	public Date getSysDate() {
		Date sysdate = test3DAO.selectSysdate();
		return sysdate;
	}

}
