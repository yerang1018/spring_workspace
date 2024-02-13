package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

//		sur_no      number                  generated as identity primary key,
//		sur_title   varchar2(500)           not null,
//		sur_option1 varchar2(500)           not null,
//		sur_option2 varchar2(500)           not null,
//		sur_image1  varchar2(500)           not null,
//		sur_image2  varchar2(500)           not null,
//		sur_image_saved1  varchar2(500)     ,
//		sur_image_saved2  varchar2(500)     ,
//		sur_writer   varchar2(500)          references member1(userid) on delete set null

public class SurveyDTO {
	
	private int sur_no;
	private String sur_title;
	private String sur_option1;
	private String sur_option2;
	private String sur_image1;
	private String sur_image2;
	private String sur_image_saved1;
	private String sur_image_saved2;
	private String sur_writer;		
	
	private MultipartFile upload1;
	private MultipartFile upload2;
	
	
	public int getSur_no() {
		return sur_no;
	}
	public void setSur_no(int sur_no) {
		this.sur_no = sur_no;
	}
	public String getSur_title() {
		return sur_title;
	}
	public void setSur_title(String sur_title) {
		this.sur_title = sur_title;
	}
	public String getSur_option1() {
		return sur_option1;
	}
	public void setSur_option1(String sur_option1) {
		this.sur_option1 = sur_option1;
	}
	public String getSur_option2() {
		return sur_option2;
	}
	public void setSur_option2(String sur_option2) {
		this.sur_option2 = sur_option2;
	}
	public String getSur_image1() {
		return sur_image1;
	}
	public void setSur_image1(String sur_image1) {
		this.sur_image1 = sur_image1;
	}
	public String getSur_image2() {
		return sur_image2;
	}
	public void setSur_image2(String sur_image2) {
		this.sur_image2 = sur_image2;
	}
	public String getSur_image_saved1() {
		return sur_image_saved1;
	}
	public void setSur_image_saved1(String sur_image_saved1) {
		this.sur_image_saved1 = sur_image_saved1;
	}
	public String getSur_image_saved2() {
		return sur_image_saved2;
	}
	public void setSur_image_saved2(String sur_image_saved2) {
		this.sur_image_saved2 = sur_image_saved2;
	}
	public String getSur_writer() {
		return sur_writer;
	}
	public void setSur_writer(String sur_writer) {
		this.sur_writer = sur_writer;
	}
	public MultipartFile getUpload1() {
		return upload1;
	}
	public void setUpload1(MultipartFile upload1) {
		this.upload1 = upload1;
	}
	public MultipartFile getUpload2() {
		return upload2;
	}
	public void setUpload2(MultipartFile upload2) {
		this.upload2 = upload2;
	}
	
	
	
	
	
	
	
	
}
