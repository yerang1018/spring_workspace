package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		List<BoardDTO> list = boardService.getBoardList();
		mav.addObject("list", list);
		return mav;
		
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/view");		//	ModelAndView("뷰 네임") : @PathVariable 사용하면 뷰네임을 반드시 지정해주어야함
		BoardDTO dto = boardService.getBoard(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {		//	반환형 void 라면, 더 작성할 내용이 없다 (넣어줄 내용이 없다)
		System.out.println("write");	//	controller 함수가 실행되는지 확인하기 위한 용도 (인터셉트 추가되었을때)
										//	로그인이 되어있는 상태에서 글작성하면  write 가 콘솔에 출력되지만
										//	로그인이 안되어있는 상태라면  return false  에 의해서  controller 이 실행이 안된다
	}
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		int row = boardService.write(dto);
		System.out.println(row != 0 ? "작성 성공" : "작성 실패");
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable("idx") int idx) {
		//	if(session.getAttribute("login") == null) {
		//			return "redirect:/member/login";
		//	}
		//	컨트롤러에 들어오는 요청을 가로채서 특정 작업(예를 들어 로그인 여부 파악)을 수행하고 		(== 요청을 가로채다 : 인터셉터)
		//	기존 경로로 계속 안내하거나, 처리를 중단하고 새로운 응답을 반환하는 스프링 빈이 필요하다 
		ModelAndView mav = new ModelAndView("alert");
		int row = boardService.delete(idx);
		String url = "/board/list";
		String msg = row != 0 ? "삭제 성공" : "삭제 실패";
		mav.addObject("url", url);
		mav.addObject("msg", msg);
		return mav;
	}
	
	
	
	
	//	어떤 데이터를 jsp에 보내려면 ModelAndView
	//	데이터를 보내지 않으면 String 혹은 void
	
	//	@PathVariable 때문에 뷰네임을 강제로 지정해야하면 스트링 혹은 모델 앤드 뷰
	//	요청 주소 그대로 jsp 의 이름을 지정하려면 void
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/modify");
		
		BoardDTO dto = boardService.getBoard(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public ModelAndView modify(BoardDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		
		int row = boardService.modify(dto);
		
		String msg = row != 0 ? "수정 성공" : "수정 실패";
		String url = "/board/view/" + dto.getIdx();			//	주소 이동할때는 스크립트이기 때문에 {idx} 사용 못한다 
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
}
