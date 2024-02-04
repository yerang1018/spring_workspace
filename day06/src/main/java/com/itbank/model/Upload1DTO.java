package com.itbank.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Upload1DTO {

//		IDX              NOT NULL NUMBER(38)    
//		MEMO             NOT NULL VARCHAR2(100) 
//		ORIGINALFILENAME NOT NULL VARCHAR2(500) 
//		STOREDFILENAME   NOT NULL VARCHAR2(500) 
//		IMAGE            NOT NULL VARCHAR2(500) 
//		UPLOADDATE                DATE    
	
	
	//	DB에 저장한 컬럼과 매치되는 필드
	private int idx;
	private String memo;
	private String originalFileName;
	private String storedFileName;
	private Date uploadDate;
	
	//	form 태그의 file 을 파라미터로 받아오기 위한 필드 (DB에 저장 X)
	private MultipartFile upload;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
}

