package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.repository.McdonaldDAO;


@Service
public class McdonaldService {

	
	@Autowired private McdonaldDAO dao;
	
	public List<McdonaldDTO> getMcdonaldList() {
		List<McdonaldDTO> list = dao.selectList();
		return list;
	}


	public List<McdonaldDTO> getCategoryList(String category) {
		List<McdonaldDTO> list = dao.selectCategoryList(category);
		return list;
	}


	public int addDTOMenu(McdonaldDTO dto) {
		int row = 0;
		row = dao.addMenu(dto);
		
		return row;
	}


	public int DeleteMenu(int idx) {
		int row = 0;
		
		row = dao.DeleteIdx(idx);
		return row;
	}


	public McdonaldDTO viewOne(int idx) {
		McdonaldDTO dto = new McdonaldDTO();
		
		dto = dao.SelectOne(idx);
		
		return dto;
	}


	public McdonaldDTO modifyOne(int idx) {
		McdonaldDTO dto = new McdonaldDTO();
		
		dto = dao.modifyIdx(idx);
		
		return dto;
	}


}
