package com.weicheng.aop.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@org.junit.Test
	public void test(){
		/*º”‘ÿxml≈‰÷√Œƒº˛*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/aop/config/applicationContext.xml");
		User user = (User) context.getBean("user");
		user.use();
	}
	
}
