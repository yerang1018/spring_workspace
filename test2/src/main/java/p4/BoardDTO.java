package p4;

public class BoardDTO {		//	DTO 는 싱글톤 X  = 그렇기 때문에 스프링빈으로 등록시키지 않는다 
	
	private int idx;
	private String title;
	private String writer;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
