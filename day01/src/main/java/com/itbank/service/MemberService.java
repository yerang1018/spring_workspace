package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import com.itbank.member.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;

	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = dao.selectList();
		list.forEach(dto -> dto.setUserpw("******"));
		return list;
	}

	public List<MemberDTO> getMemberSearchList(HashMap<String, String> paramMap) {
//		mybatis 함수는 인자를 하나만 전달하거나, 아예 전달하지 않는다 (= 인자를 2개이상 전달하지 않음. 즉, 파라미터는 묶어서 전달해야함)
		List<MemberDTO> list = dao.selectSearchList(paramMap);
		list.forEach(dto -> dto.setUserpw("******"));
		return list;
	}

	public int add(MemberDTO dto) {
		int row = dao.insert(dto);
		return row;
	}

	public int delete(int idx) {
		int row = dao.delete(idx);
		return row;
	}
	
}
