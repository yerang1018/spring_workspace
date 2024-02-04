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

}
