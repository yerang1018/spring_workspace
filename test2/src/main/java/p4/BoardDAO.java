package p4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


//	컨트롤러를 작동하기 위해서 dao 를 생성했는데
//	dao와 컨트롤러 간의 관계에 따라서 타입에 맞게 객체를 생성해주기 위해서 어노테이션을 사용하면
//	자동으로 스프링이 알아서 객체를 생성한다 
@Component
public class BoardDAO {

	public List<BoardDTO> selectList() throws Exception {
		ArrayList<BoardDTO>list = new ArrayList<>();
		
		String sql = "select * from board2 order by idx desc fetch next 10 rows only";
		String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
		String user = "c##itbank";
		String password = "it";
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setIdx(rs.getInt("idx"));
			dto.setTitle(rs.getString("title"));
			dto.setWriter(rs.getString("writer"));
			list.add(dto);
			
		}
		if(rs != null)		rs.close();
		if(pstmt != null)	pstmt.close();
		if(conn != null)	conn.close();
		return list;
	}

}
