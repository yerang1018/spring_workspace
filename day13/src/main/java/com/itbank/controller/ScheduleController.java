package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.ScheduleDTO;
import com.itbank.repository.ScheduleDAO;

@RestController
@RequestMapping("/schedules")

//	http://localhost:8080 : 서버 또는 도메인 주소

//	단순히 어노테이션만 걸어두면 모두에게 나의 데이터가 공유됨
//	CrossOrigin 안에 배열에 나의 데이터를 공유하고 싶은 서버들만 넣어두기 
@CrossOrigin(origins = {  "http://localhost:8080", "http://192.168.112.31:8080", "http://192.168.112.24:8080"
				, "http://192.168.112.7:8080", "http://192.168.112.18:8080" , "http://192.168.112.17:8080",
				"http://192.168.112.22:8080",
})
public class ScheduleController {

	@Autowired private ScheduleDAO dao;
	
	@GetMapping
	public List<ScheduleDTO> selectList() {
		return dao.selectList();
	}

	@PostMapping
	@CrossOrigin
	public int add(@RequestBody ScheduleDTO dto) {	//	JSON 으로 전달되는 데이터를 DTO 로 맵핑하려면 @RequestBody 사용
		//	자바 객체를 반환하면 JSON 형식의 문자열을 반환하기 위해서 @ResponseBody 를 사용함(생략가능함 : RestController 내부는 @ResponseBody 가 기본값이기 때문
		int row = 0;
		
//		매개변수 잘 받아오는지 확인용 
//		System.out.println(dto.getMemo());
//		System.out.println(dto.getsDate());
		
		row = dao.insert(dto);
		return row;
	}
	
	@DeleteMapping("/{idx}")
	public int delete(@PathVariable("idx") int idx) {
		int row = 0;
		row = dao.delete(idx);
		return row;
	}
	
}
