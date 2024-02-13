package com.itbank.model;

//		idx         number          generated as identity primary key,
//		userid      varchar2(200)   unique not null,
//		userpw      varchar2(500)   not null


public class MemberDTO {
	
	private int idx;
	private String userid;
	private String userpw;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	
	
	
}
