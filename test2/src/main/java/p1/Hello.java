package p1;

public class Hello {
	//	Hello 클래스는 서로 다른 데이터를 저장하기 위한 용도가 아님
	//	즉, 객체마다 서로 다른 값을 지정할 수 없다 (무조건 동일한 내용이 출력되기 때문)
	//	따라서, Hello를 통해 출력하는 Main 클래스는
	//	싱글톤이 적용되어도 상관없는것이다
	
	
	
	//	자바 빈즈 형태로 만들기
	//	빈즈는
	//	private형태의 필드 + 게터 세터 + public형태의 생성자 가 갖춰진 형태이다 
	
	
	//	자바 빈즈형태의 클래스에는 싱글톤 적용 X (== DTO)
	//	(= 객체마다 다른 정보를 가져야함)
	//	객체 1) 짱구, 5살    객체 2) 짱아, 2살 ..
	
	
	
	//	Handler 클래스에는 싱글톤 적용 O (== DAO)
	//	(= 여러개의 클래스를 만들어도 기능 상의 차이가 없기 때문)
	
	
	
	//	static 으로 싱글톤을 어느정도 구현할 수 있음
	//	: a객체와 b객체를 동일한 배열을 참조할 수 있게 만들어버림
	//	  static은 객체가 아닌, 클래스 기준이기 때문에
	//	   굳이 지정해주지 않아도 동일한 것을 바라보게 만든다 
	
	private String text = "Hello world";

	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
