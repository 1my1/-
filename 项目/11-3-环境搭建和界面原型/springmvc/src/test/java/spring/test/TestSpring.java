package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	
	@Test
	public void test(){
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		HelloWorld hello=(HelloWorld)context.getBean("hello");
	    System.out.println(hello.getName());
		
	}

}
