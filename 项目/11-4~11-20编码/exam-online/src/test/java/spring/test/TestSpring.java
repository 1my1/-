package spring.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nuc.spring.dao.AdminMapper;
import cn.edu.nuc.spring.dao.TitleMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml","classpath:springmvc-context.xml"})
public class TestSpring {
	@Autowired
	private TitleMapper titleMapper;
	
	@Test
	public void test(){
//		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-context.xml");
//		HelloWorld hello=(HelloWorld)context.getBean("hello");
//	    System.out.println(hello.getName());
		//System.out.println(adminMapper.updateSessionID("123","wh1234","wh1234"));
		//System.out.println(new Date());
		System.out.println(titleMapper.courseLists().size());
	}
	

}
