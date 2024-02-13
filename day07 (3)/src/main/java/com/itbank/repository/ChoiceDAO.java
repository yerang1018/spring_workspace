package com.itbank.repository;

import org.apache.ibatis.annotations.Insert;

import com.itbank.model.ChoiceDTO;

public interface ChoiceDAO {

	@Insert("insert into choice(cho_surveyUserid, cho_surveyNo, cho_choice)"
			+ " values(#{cho_surveyUserid}, #{cho_surveyNo}, #{cho_choice})")
	int upload(ChoiceDTO dto);

	

	
	
}
