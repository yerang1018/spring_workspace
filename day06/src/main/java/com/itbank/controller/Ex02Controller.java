package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/ex02")
public class Ex02Controller {

	@GetMapping
	public void ex02() {}
	
	
	@PostMapping
	public String ex02(MultipartFile upload, RedirectAttributes rttr) 	//	<input type="file" name="upload"  ... 
			throws IllegalStateException, IOException {				//	매개변수 이름(upload) == input name 의 이름(upload) 이 같아야함
										
		
		//	MultipartRequest 를 일일히 매개변수에 받지않고,
		//	String 파라미터를 매개변수를 통해 전달받는것과 같이
		//	파일도 매개변수를 통해 전달받을수있다 
		
		//	RedirectAttributes rttr : addObject 의 또 다른 방식 (파일 업로드와는 연관없음)
		//	리다이렉트시에 mav.addObject 를 수행하면 쿼리스트링으로 주소창에 노출되지만 
		//	RedirectAttributes 는 Model 을 extends 하는 클래스.
		//	세션에 잠시 저장해두었다가, Model 로 이동시키는 역할을 수행
		//	따라서, 값도 전달할 수 있으면서도 주소창에 노출시키지도 않음 
		
		rttr.addFlashAttribute("fileName" , upload.getOriginalFilename());
		rttr.addFlashAttribute("fileSize", upload.getSize());
		File f = new File("C:\\upload", upload.getOriginalFilename());
		upload.transferTo(f);	//	사용자가 전송한 upload 를 지정한 위치의 파일 f로 전송. 
								//	jsp와는 다르게, 파일 위치를 지정해야함(jsp는 그냥 보내짐)
		
		return "redirect:/ex02";
	}
	
}
