package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ProductDTO;
import com.itbank.repository.ProductDAO;

@Service
public class ProductService {

	@Autowired private ProductDAO dao;
	
	
	private String saveDirectory = "C:\\upload";
	
	
	public ProductService() {
		
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	
	public List<ProductDTO> getList() {
		return dao.selectList();
	}

	public int add(ProductDTO dto) {
		String originalFileName1 = dto.getUpload().getOriginalFilename();
		
		
		//	파일 확장자만 출력하기 		마지막 .의 위치부터 끝까지 잘라냄 
		String ext1 = originalFileName1.substring(originalFileName1.lastIndexOf("."));
		
		
		//	새로 저장될 이름은 중복되지 않도록 UUID 를 사용
		String storedFileName1 = UUID.randomUUID().toString().replace("-", "");
		storedFileName1 += ext1;
		
		
		File f1 = new File(saveDirectory, storedFileName1);
		
		try {
			dto.getUpload().transferTo(f1);		
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		
		dto.setImg(originalFileName1);
		dto.setSave_img(storedFileName1);

		
		return dao.insertFile(dto);
	}


	public int update(ProductDTO dto) {
		return dao.update(dto);
	}


	public ProductDTO getIdx(int idx) {
		return dao.SelectOne(idx);
	}


	public int delete(int idx) {
		return dao.delete(idx);
	}






}
