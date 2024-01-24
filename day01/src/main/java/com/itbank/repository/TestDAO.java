package com.itbank.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {			
	
	@Autowired private JdbcTemplate jdbcTemplate;	//	root-context 가보면	jdbc template 가 있다
													//	

	public String selectBanner() {
		String sql = "select banner from v$version";
		
		
		//	RowMapper : 함수형 인터페이스(= 람다식 사용가능)
//		RowMapper<String> rowMapper = new RowMapper<String>() {		//	익명 내부 클래스		
//																	//	RowMapper 는 맵핑함수랑 동일
//			
//			@Override
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return rs.getString("banner");
//			}
//		};
		
		RowMapper<String> rowMapper = (rs, rownum) -> rs.getString("banner");	//	banner : 컬럼이름
		
		
		String version = jdbcTemplate.queryForObject(sql, rowMapper);
		return version;
	}

	public String selectDate() {
		String sql = "select sysdate from dual";
		
		RowMapper<String> rowMapper = (rs, rownum) -> rs.getString("sysdate");
		
		String sysdate = jdbcTemplate.queryForObject(sql, rowMapper);
		
		return sysdate;
	}
	
	//	rowMapper 안쓰기
//		public Date selectSysdate() {
//		
//			String sql = "select sysdate from dual";
//		
//			Date sysdate = jdbcTemplate.query(sql, Date.class);
//		
//			return sysdate;
//		}

}
