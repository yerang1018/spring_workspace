package com.itbank.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.MemberDTO;

public interface MemberDAO {

	@Insert("insert into member1(userid, userpw) values(#{userid}, #{userpw})")
	int join(MemberDTO dto);
	
	@Select("select * from member1 where userid = #{userid} and userpw = #{userpw}")
	MemberDTO login(MemberDTO dto);
	
	
}
