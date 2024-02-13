package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ChoiceDTO;
import com.itbank.repository.ChoiceDAO;

@Service
public class ChoiceService {

	@Autowired private ChoiceDAO dao;


	public int add(ChoiceDTO dto) {
		return dao.upload(dto);
	}

}
