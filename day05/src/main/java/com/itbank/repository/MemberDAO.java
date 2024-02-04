package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;


@Repository			//	인터페이스는 어노테이션이 필요없긴하다(가독성 높이기 위해서 사용)
public interface MemberDAO {

	@Select("select * from member order by idx")
	List<MemberDTO> selectList();

	
	@Select("select * from member where idx=#{idx}")
	MemberDTO selectOne(int idx);

	
	@Insert("insert into member (userid, userpw, username, email) "
			+ " values ( #{userid}, #{userpw}, #{username}, #{email} )")
	int insert(MemberDTO dto);

	
//	@Select("select .. 		이 부분을 주석 처리한 다음에 xml 로 바꿔본다면? 
//		1. DAO 해당함수의 어노테이션 지우기
//		2. member-mapper.xml만들기 (board-mapper 랑 똑같지만 member로 바꾸기)
//		3. member-mapper.xml에 sql문도 만들기 ( 	<select id="selectList" ... )
//		3. root-context 에 		<value>classpath:mybatis/member-mapper.xml</value> 넣어주기
	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login(MemberDTO dto);


	@Delete("delete from member where idx=#{idx}")
	int delete(int idx);

	
	@Update("update member set userid=#{userid}, userpw=#{userpw}, username=#{username}, email=#{email}"
			+ " where userid = #{userid} and idx = #{idx}")
	int update(MemberDTO dto);

	
	@Update("update member set userpw=#{userpw}"
			+ " where userid=#{userid} and email=#{email}")
	int updatePassword(MemberDTO dto);
	

}
