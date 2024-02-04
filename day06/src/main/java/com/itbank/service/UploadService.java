package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.Upload1DTO;
import com.itbank.repository.UploadDAO;

@Service
public class UploadService {

	@Autowired private UploadDAO dao;
	
	
	private String saveDiretory = "C:\\upload";
	
	
	public UploadService() {
		//	스프링 빈이 생성될때(= 서버가 시작될때) saveDirectory 경로를 체크하고 없으면 새로 만든다
		
		File dir = new File(saveDiretory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public int upload(Upload1DTO dto) {
		String originalFileName = dto.getUpload().getOriginalFilename();
		System.out.println(originalFileName);
		
		//	파일 확장자만 출력하기 		마지막 .의 위치부터 끝까지 잘라냄 
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));

		
		
		//	새로 저장될 이름은 중복되지 않도록 UUID 를 사용
		String storedFileName = UUID.randomUUID().toString().replace("-", "");
		storedFileName += ext;
		
		File f = new File(saveDiretory, storedFileName);
		try {
			dto.getUpload().transferTo(f);		//	transferTo(f) : 실제 파일이 생성되는 함수 (MultipartFile 에 내장되어있는 함수)
												//	(서버 메모리안에 있는) MultipartFile -> (지정한 위치의 저장장치) java.io.File 로 전송됨
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		
		dto.setOriginalFileName(originalFileName);
		dto.setStoredFileName(storedFileName);
		
		return dao.insert(dto);
	}

	public List<Upload1DTO> getList() {
		
		return dao.selectList();
	}

	public int delete(int idx) {
		//	DB에서 데이터를 삭제하기 전에, 먼저 !! 데이터를 불러와서 실제 저장된 파일도 삭제한 뒤에 DB 데이터 삭제
		
		Upload1DTO dto = dao.selectOne(idx);		//	삭제할 것 하나를 불러올 함수 
		
		File f = new File(saveDiretory, dto.getStoredFileName());	//	지정한 위치(upload)에 있는 저장된 파일이름을 불러와서 (== f)
		if(f.exists()) {	//	그 위치에 파일이 존재한다면 
			f.delete();		//	삭제해라
		}
		
		int row = dao.delete(idx);
		
		return row;
	}
	
	
	
}
