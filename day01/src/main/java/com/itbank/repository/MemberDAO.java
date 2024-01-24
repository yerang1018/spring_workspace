package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.member.MemberDTO;

//	인터페이스는 어노테이션이 필요없다


//	그러나, 가독성때문에 쓰긴 함

@Repository
public interface MemberDAO {
	
	@Select("select * from member order by idx")
	List<MemberDTO> selectList();

	
	//	pstmt 에는 ?에 대응하는 표현식이 2개 있다
	//		${} 안에는 따옴표를 넣지 않음
	//		#{} 안에는 자료형에 따라서 따옴표를 적절히 넣어줌 
	@Select("select * from member where ${searchType} like '%' || #{searchKeyword} || '%' order by idx")
	List<MemberDTO> selectSearchList(HashMap<String, String> paramMap);

	
	@Insert("insert into member (userid, userpw, username, email)"
			+ " values ( #{userid}, #{userpw} , #{username}, #{email} )")
	int insert(MemberDTO dto);


	@Delete("delete from member where idx = #{idx}")
	int delete(int idx);
	
}
