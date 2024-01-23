package p4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//	컨트롤러에는 스프링빈으로 되어있어야한다  == 어노테이션을 이용하는 이유 
@Component
public class BoardController {

	@Autowired private BoardDAO dao;	//	컨트롤러가 정상 작동이 되기 위해서는 dao가 필요
	
	
	public List<BoardDTO> getBoardList() throws Exception {
		
		return dao.selectList();
	}

}
