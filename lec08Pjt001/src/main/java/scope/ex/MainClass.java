package scope.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InjectionBean injectionBean = 
				ctx.getBean("injectionBean", InjectionBean.class);
		
		DependencyBean dependencyBean01 = 
				ctx.getBean("dependencyBean", DependencyBean.class);
		
		DependencyBean dependencyBean02 = 
				ctx.getBean("dependencyBean", DependencyBean.class);
		
		// 빈의 범위
		//싱글톤 : 스프링 컨테이너에서 생성된 빈 객체의 경우 동일한 타입에 대해서는 기본적으로 한 개만 생성이 되며,
		//getBean메소드로 호출될 때 동일한 객체가 반환된다.
		if(dependencyBean01.equals(dependencyBean02)) {
			//기본 default는 싱글톤이지만, scope=prototype 설정 시 객체가 생성될 때마다 다른 객체 생성
			//싱글톤 범위와 반대의 개념, 프로토타입 범위
			System.out.println("dependencyBean01 == dependencyBean02");
		} else {
//			기본 default는 싱글톤, 
			System.out.println("dependencyBean01 != dependencyBean02");
		}
		
		
		ctx.close();
		
	}
	
}
