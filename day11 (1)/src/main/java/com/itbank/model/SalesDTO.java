package com.itbank.model;

import java.sql.Date;

public class SalesDTO {

	
	//	Sales1 테이블
	
//			이름            널?       유형     
//			------------- -------- ------ 
//			S_IDX         NOT NULL NUMBER 
//			S_DATE                 DATE   
//			S_PRODUCT_IDX          NUMBER 
//			S_COUNT       NOT NULL NUMBER 
//			S_DELETE               NUMBER 
	
	
	private int s_idx;
	private Date s_date;
	private int s_product_idx;
	private int s_count;
	private int s_delete;
	
	
	
	// 	join 사용해서 다른 테이블에 있는  필드의 내용을 가져왔을때에는
	//	결과물의 필드명과 일치해야하고
	//	DTO에만 필드를 하나 추가하자. 
	private String s_name;
	
	

	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_idx() {
		return s_idx;
	}
	public void setS_idx(int s_idx) {
		this.s_idx = s_idx;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public int getS_product_idx() {
		return s_product_idx;
	}
	public void setS_product_idx(int s_product_idx) {
		this.s_product_idx = s_product_idx;
	}
	public int getS_count() {
		return s_count;
	}
	public void setS_count(int s_count) {
		this.s_count = s_count;
	}
	public int getS_delete() {
		return s_delete;
	}
	public void setS_delete(int s_delete) {
		this.s_delete = s_delete;
	}
	
	
	
	
	
}
