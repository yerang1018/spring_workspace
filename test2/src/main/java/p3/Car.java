package p3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	
		
//	@Autowired		:	스프링 빈으로 등록된 객체 중에서 
					//	타입이 맞는 객체를 찾아서 자동으로 의존성을 주입
					//	스프링 빈 중에서 맞는애들을 직접 참조시켜버리는 
	
	
	@Autowired				//	[타입이 맞는 객체] 의 의미 
	private Tire tire;		//	클래스 Car 는 Tire 필드를 가지고 있음
							//	원래는 자동으로 tire 객체에 null 값을 주는데
							//	스프링 빈으로 등록되어있기 때문에
							//	Tire 객체 tire 는 Tire 자료형을 갖게된다 
							//	즉, tire 를 출력시키면 null 이 아니게 된다 !! (== 객체가 있다는 의미)
							//	내용이 없는 것을 null 이라 하는게 아니고, 참조의 대상이 없으면 null 이라고 한다 
	
	//	IOC : 객체 생성부터 소멸까지 스프링 컨테이너가 담당한다.
	
	
	public void run() {
		if(tire != null) {
			System.out.println("부릉부릉");
		}
		else {
			System.out.println("타이어를 먼저 장착해야 합니다");
		}
	}
}
