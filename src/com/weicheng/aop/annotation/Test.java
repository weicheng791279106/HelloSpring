package com.weicheng.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@org.junit.Test
	public void test(){
		/*º”‘ÿxml≈‰÷√Œƒº˛*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/aop/annotation/applicationContext.xml");
		User user = (User) context.getBean("user");
		user.use();
	}
	
}
