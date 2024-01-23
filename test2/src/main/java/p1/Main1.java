package p1;

public class Main1 {

	public static void main(String[] args) {
		
		Hello ob1 = new Hello();
		String text1 = ob1.getText();
		System.out.println(text1);
		
		Hello ob2 = new Hello();
		String text2 = ob2.getText();
		System.out.println(text2);
		
		System.out.println(ob1 == ob2); 	//	ob1 과 ob2 는 같은 대상을 바라보고 있는가?
		
		//	ob1 과 ob2 는 같은 클래스에 의해 생성된 객체
		//	클래스 구성상 두 객체는 기능적으로 완전 동일
		//	객체마다 서로 다른 값을 저장하지도 않음
		
		//	프로그램 주요 내용이 시작된 이후 객체를 생성하는 일은 시간이 오래걸림
		//	커넥션 풀 같은 복잡한 구성의 객체는 미리 만들어두는 것이 유리 
		
		
	}
	
	
	
}
