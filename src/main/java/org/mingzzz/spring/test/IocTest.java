package org.mingzzz.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.mingzzz.spring.po.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
	ApplicationContext ac = null;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("/config/spring.xml");
	}
	
	@Test
	public void TestIoc(){
		User user = (User) ac.getBean("user");
		user.setUname("hello");
		System.out.println(user.getUname());
	}
}
