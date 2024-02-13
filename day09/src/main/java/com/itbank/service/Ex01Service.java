package com.itbank.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Service;


@Service
public class Ex01Service {
	//	공공 데이터 포털, 부산 축제 정보
	
	
	private final String serviceKey = "fPywZzdX80yEsvW3nt%2F4DyY9NZVrqZDUOFBN5Kuw7UkhbMsuXNXY%2FzsT4iAZm6Z1ILayJYsElZPCr4JWUooiQg%3D%3D";
			
	
	public String getFastivalJSON() throws MalformedURLException, IOException {
		//	1) 요청 주소 및 파라미터 준비
		String url = "https://apis.data.go.kr/6260000/FestivalService/getFestivalKr";

		HashMap<String, String> param = new HashMap<>();
		
		param.put("pageNo", "1");
		param.put("numOfRows", "10");
		param.put("resultType", "json");
		param.put("serviceKey", serviceKey);
		
		
		url += "?";		//	기본 주소에다가 ? 를 붙이고
		for(String key : param.keySet()) {		//	그 뒤부터는 	키 = 벨뉴	형태를 반복  (== 쿼리스트링 형식)
			url += key + "=" + param.get(key) + "&";
			
		}
		
		//	2) 요청을 전송하여 응답을 받아서 저장 
		Scanner sc = null;
		String response = "";
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		
		if(conn.getResponseCode() == 200) {		//	정상		200번 서버 뜨면 정상을 의미 
			 sc = new Scanner(conn.getInputStream());
			 while(sc.hasNextLine()) {
				 response += sc.nextLine();
			 }
			 sc.close();
			 conn.disconnect();
		}
		
		return response;
	}

	
	
}
