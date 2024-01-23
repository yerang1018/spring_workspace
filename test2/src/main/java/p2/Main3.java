package p2;

import org.springframework.context.support.GenericXmlApplicationContext;

import p2.Toy;


//	Main3는 Toy만 불러와서 실행했을 뿐인데 toy 의 내용이 나온다 ! 
//		이 메인코드에는 배터리에 대한 내용이 없는데도 
//		배터리에 대한 처리가 이루어짐 
public class Main3 {
	public static void main(String[] args) {
		
	GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("classpath:toy-context.xml");

	//	스프링 컨테이너에서 불러온 스프링 빈은 에너지 수치 및 배터리 설정이 모두 완료된 상태로 불러옴 
	Toy toy = context.getBean(Toy.class);
	
	System.out.println("toy1");
	for(int i = 0; i <= 20; i++) {
		toy.run();
	}
	
	
	
	//	직접 생성한 객체는
	//	Battery에 대한 의존성과 Battery 의 energy 속성이 준비되어 있지 않음 
	//	== 	Dependency injection (DI)
	
	System.out.println("toy2");
	Toy toy2 = new Toy(new BatteryAA()); 
	toy2.run();
	
	context.close();

	}
}
