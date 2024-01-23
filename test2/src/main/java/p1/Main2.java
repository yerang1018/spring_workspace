package p1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		//	Context init = new InitialContext();
		
		GenericXmlApplicationContext context =
					new GenericXmlApplicationContext("classpath:hello-context.xml");
		
		
		//	지정한 타입의 객체가 컨테이너 안에 하나만 있다면 자료형을 이용하여 불러올 수 있다
		Hello ob1 = context.getBean(Hello.class);
		
		
		//	컨테이너 안에 객체가 2개 이상 있다면, id를 지정하여 불러올 수 있다
		Hello ob2 = context.getBean("hello", Hello.class);
		
		
		System.out.println(ob1.getText());
		System.out.println(ob2.getText());
		System.out.println();
		
		System.out.println(ob1 == ob2);		//	true 로 나옴 : 동일한 대상을 바라보고 있다 (싱글톤)
		
		
		
		//	스프링은 내부에 스프링 컨테이너라는 객체 보관소를 가진다
		//	스프링 컨테이너 내부에 준비된 객체를 스프링 빈이라고 부른다
		//	스프링 빈은 별도의 추가 설정이 없다면, 기본적으로 싱글톤으로 구현됨
		
		//	스프링 컨테이너에 객체를 생성하기 위해서 xml 설정 파일을 활용하여 처리
		//	이때, xml 파일은  컨테이너 내부에 객체를 준비하기 위한 주문서 개념으로 생각 
		//	주문서를 참고하여 스프링이 알아서 객체를 만든다
		
											
		
		context.close();
		
	}
}
