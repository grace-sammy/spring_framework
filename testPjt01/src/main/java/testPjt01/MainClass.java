package testPjt01;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//기존 자바 방식, 스프링에서 이 기존방법 사용해도 되지만 효율적인 업무를 위해선 ...X
		//TransportationWalk transportationWalk = new TransportationWalk();
		//transportationWalk.move();
		
		//appliationContext 접근하는 클래스, 컨테이너를 가져옴, 가로 안에 리소스 내용 적기
		//컨테이너가 생성됨
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//컨테이너에 있는 Bean 가져오기, id로 찾아옴, 컨테이너에 의해 생성된 객체를 bean이라고 한다.
		TransportationWalk transportationWalk =ctx.getBean("tWalk", TransportationWalk.class);
		transportationWalk.move();
		
		//자원 사용 후 닫아줘야한다.
		ctx.close();
		
		
	}

}
