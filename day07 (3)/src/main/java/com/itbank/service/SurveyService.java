package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ChoiceDTO;
import com.itbank.model.SurveyDTO;
import com.itbank.repository.SurveyDAO;

@Service
public class SurveyService {

	@Autowired private SurveyDAO dao;
	
	private String saveDiretory = "C:\\upload";
	
	public SurveyService() {

		File dir = new File(saveDiretory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	
	public int add(SurveyDTO dto) {
		String originalFileName1 = dto.getUpload1().getOriginalFilename();
		String originalFileName2 = dto.getUpload2().getOriginalFilename();
		
		
		//	파일 확장자만 출력하기 		마지막 .의 위치부터 끝까지 잘라냄 
		String ext1 = originalFileName1.substring(originalFileName1.lastIndexOf("."));
		String ext2 = originalFileName2.substring(originalFileName2.lastIndexOf("."));
		
		
		//	새로 저장될 이름은 중복되지 않도록 UUID 를 사용
		String storedFileName1 = UUID.randomUUID().toString().replace("-", "");
		storedFileName1 += ext1;
		
		String storedFileName2 = UUID.randomUUID().toString().replace("-", "");
		storedFileName2 += ext2;
		
		File f1 = new File(saveDiretory, storedFileName1);
		File f2 = new File(saveDiretory, storedFileName2);
		
		try {
			dto.getUpload1().transferTo(f1);		
			dto.getUpload2().transferTo(f2);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		
		dto.setSur_image1(originalFileName1);
		dto.setSur_image_saved1(storedFileName1);
		
		dto.setSur_image2(originalFileName2);
		dto.setSur_image_saved2(storedFileName2);
		
		return dao.insertFile(dto);
	}


	public List<SurveyDTO> getList() {
		return dao.selectList();
	}


	public SurveyDTO getSurvey(int sur_no) {
		return dao.selectOne(sur_no);
	}


	public int upload(ChoiceDTO dto) {
		return dao.upload(dto);
	}


	public ChoiceDTO getResult(int sur_no) {
		return dao.result(sur_no);
	}


	
	



	
	
}
