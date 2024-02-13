package com.itbank.model;


public class ChoiceDTO {

//		cho_idx               number            generated as identity primary key,
//	    cho_surveyUserid      varchar2(200)     references member1(userid) on delete set null, 
//	    cho_surveyNo          number            references survey(sur_no) on delete set null,
//	    cho_choice            number            check(cho_choice in(1,2))
 
	private int cho_idx;
	private String cho_surveyUserid;
	private int cho_surveyNo;
	private int cho_choice;
	

	private int count1;		//	as 별칭을 사용한 필드는 따로 DTO에서 필드 만들어주자(값을 저장할 공간이 필요하기 때문)
	private int count2;
	
//	@Select("select count(case when cho_choice = 1 then 1 end) as count1," + 
//			"           count(case when cho_choice = 2 then 1 end) as count2" + 
//			"     from choice where cho_surveyNo = #{sur_no}")
//	ChoiceDTO result(int sur_no);

	//	controller에 있는 이 함수는 ChoiceDTO 를 반환하는 함수임. 이때 사용된 as count1 과 as count2 는 필드가 따로 필요하다 
	
	
	public int getCount1() {
		return count1;
	}
	public void setCount1(int count1) {
		this.count1 = count1;
	}
	public int getCount2() {
		return count2;
	}
	public void setCount2(int count2) {
		this.count2 = count2;
	}
	public int getCho_idx() {
		return cho_idx;
	}
	public void setCho_idx(int cho_idx) {
		this.cho_idx = cho_idx;
	}
	public String getCho_surveyUserid() {
		return cho_surveyUserid;
	}
	public void setCho_surveyUserid(String cho_surveyUserid) {
		this.cho_surveyUserid = cho_surveyUserid;
	}
	public int getCho_surveyNo() {
		return cho_surveyNo;
	}
	public void setCho_surveyNo(int cho_surveyNo) {
		this.cho_surveyNo = cho_surveyNo;
	}
	public int getCho_choice() {
		return cho_choice;
	}
	public void setCho_choice(int cho_choice) {
		this.cho_choice = cho_choice;
	}
	
	
	
}
