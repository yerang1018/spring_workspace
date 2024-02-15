package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {

	
//		PRODUCT1 테이블
	
//		이름    		널?       유형             
//		----- -------- -------------- 
//		IDX   NOT NULL 		NUMBER         
//		NAME  NOT NULL 		VARCHAR2(500)  
//		IMG            		VARCHAR2(1000) 
//		PRICE NOT NULL 		NUMBER         
//		COUNT          		NUMBER 
//		SAVE_IMG				
	
	private int idx;
	private String name;
	private String img;
	private int price;
	private int count;
	
	//	UUID로 변경한 값 
	private String save_img;
	
	//	파일 업로드
	private MultipartFile upload;
	
	
	
	
	public String getSave_img() {
		return save_img;
	}
	public void setSave_img(String save_img) {
		this.save_img = save_img;
	}

	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	
}
