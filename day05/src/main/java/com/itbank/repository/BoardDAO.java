package com.itbank.repository;

import java.util.List;

import com.itbank.model.BoardDTO;

public interface BoardDAO {

	
	//	어노테이션 안쓰고 xml로 sql구문 처리
	//	board-mapper.xml 에 추가 작성해주기 
	
	
	
	List<BoardDTO> selectList();

	
	//	<select id="selectOne" parameterType="int" resultType="board">
	
	//	resultType 		= 	BoardDTO
	//	id 				= 	selectOne
	//	parameterType 	= 	int
	BoardDTO selectOne(int idx);


	int insert(BoardDTO dto);


	int delete(int idx);

								//	xml에 추가 
	int update(BoardDTO dto);	//	<update id="update">	id 는 함수 이름을 적는 것
								//	파라미터가 있다면 파라미터 타입도 적기 




}
