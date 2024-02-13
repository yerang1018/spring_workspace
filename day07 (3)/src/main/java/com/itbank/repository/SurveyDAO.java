package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.ChoiceDTO;
import com.itbank.model.SurveyDTO;

public interface SurveyDAO {



//		@Insert("insert into upload1 (memo, originalFileName, storedFileName) " 
//				+ " values (#{memo}, #{originalFileName}, #{storedFileName})" )
	
	@Insert("insert into survey(sur_title, sur_option1, sur_option2,"
			+ " sur_image1, sur_image2, sur_image_saved1, sur_image_saved2, sur_writer)"
			+ " values(#{sur_title}, #{sur_option1}, #{sur_option2}, #{sur_image1}, #{sur_image2}, "
			+ " #{sur_image_saved1}, #{sur_image_saved2}, #{sur_writer})")
	int insertFile(SurveyDTO dto);

	
	
	@Select("select * from survey order by sur_no")
	List<SurveyDTO> selectList();


	@Select("select * from survey where sur_no = #{sur_no}")
	SurveyDTO selectOne(int sur_no);


	@Insert("insert into choice(cho_surveyUserid, cho_surveyNo, cho_choice)"
			+ " values(#{cho_surveyUserid}, #{cho_surveyNo}, #{cho_choice})")
	int upload(ChoiceDTO dto);



	@Select("select count(case when cho_choice = 1 then 1 end) as count1," + 
			"           count(case when cho_choice = 2 then 1 end) as count2" + 
			"     from choice where cho_surveyNo = #{sur_no}")
	ChoiceDTO result(int sur_no);





	
	
	
	
	
}
