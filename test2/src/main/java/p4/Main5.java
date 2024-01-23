package p4;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;


//	Main은 컨트롤러를 이용해 list 를 가져와서 출력하는 역할 뿐 

//	컨트롤러에 어노테이션을 이용해 스프링 빈으로 등록되어 있어야한다 

public class Main5 {
	public static void main(String[] args) throws Exception {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:board-context.xml");
		
		
		BoardController controller = context.getBean(BoardController.class);
		List<BoardDTO> list = controller.getBoardList();
		
		for(BoardDTO dto : list) {
			System.out.printf("%d) %s %s\n", dto.getIdx(), dto.getTitle(), dto.getWriter());
		}
		System.out.println();
		
		context.close();
		
		
	}
}
