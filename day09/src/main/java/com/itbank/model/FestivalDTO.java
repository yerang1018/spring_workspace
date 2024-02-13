package com.itbank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//	JSON 데이터 중에서 DTO에 명시되지 않은 속성은 무시하겠다는 어노테이션
@JsonIgnoreProperties(ignoreUnknown = true)


//	JSON의 속성이름을 자바 네이밍 컨벤션(camelCase)으로 변환하는 과정이 맞아야함 
public class FestivalDTO {

	
	
	
	//	DTO로 mapping 하려면 ...
	//	@JsonProperty("UC_SEQ")		private int UC_SEQ;		대신에 모든 필드를 어노테이션 해주어야함 
	
	private int UC_SEQ;
	private String MAIN_TITLE;
	private String GUCUN_NM;
	private String HOMEPAGE_URL;
	private String MAIN_IMG_NORMAL;
	private String ITEMCNTNTS;
	
	
	public int getUC_SEQ() {
		return UC_SEQ;
	}
	public void setUC_SEQ(int uC_SEQ) {
		UC_SEQ = uC_SEQ;
	}
	public String getMAIN_TITLE() {
		return MAIN_TITLE;
	}
	public void setMAIN_TITLE(String mAIN_TITLE) {
		MAIN_TITLE = mAIN_TITLE;
	}
	public String getGUCUN_NM() {
		return GUCUN_NM;
	}
	public void setGUCUN_NM(String gUCUN_NM) {
		GUCUN_NM = gUCUN_NM;
	}
	public String getHOMEPAGE_URL() {
		return HOMEPAGE_URL;
	}
	public void setHOMEPAGE_URL(String hOMEPAGE_URL) {
		HOMEPAGE_URL = hOMEPAGE_URL;
	}
	public String getMAIN_IMG_NORMAL() {
		return MAIN_IMG_NORMAL;
	}
	public void setMAIN_IMG_NORMAL(String mAIN_IMG_NORMAL) {
		MAIN_IMG_NORMAL = mAIN_IMG_NORMAL;
	}
	public String getITEMCNTNTS() {
		return ITEMCNTNTS;
	}
	public void setITEMCNTNTS(String iTEMCNTNTS) {
		ITEMCNTNTS = iTEMCNTNTS;
	}
	
	
}
