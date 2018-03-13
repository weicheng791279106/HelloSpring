package com.weicheng.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**通过无参构造方法创建对象*/
	@org.junit.Test
	public void test(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/annotation/applicationContext.xml");
		User user = (User) context.getBean("user");
		user.use();
	}
	
	/**scope属性演示*/
	@org.junit.Test
	public void testScope(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/annotation/applicationContext.xml");
		
		/*singleton演示*/
		SingletonUser singletonUser1 = (SingletonUser) context.getBean("singletonUser");
		SingletonUser singletonUser2 = (SingletonUser) context.getBean("singletonUser");
		System.out.println("singletonUser1:" + singletonUser1 + " singletonUser2:" + singletonUser2);
		
		/*prototype演示*/
		PrototypeUser prototypeUser1 = (PrototypeUser) context.getBean("prototypeUser");
		PrototypeUser prototypeUser2 = (PrototypeUser) context.getBean("prototypeUser");
		System.out.println("prototypeUser1:" + prototypeUser1 + " prototypeUser2:" + prototypeUser2);
	}
	
	/**set方法注入对象属性演示*/
	@org.junit.Test
	public void testSetObjArg(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/annotation/applicationContext.xml");
		User user = (User) context.getBean("user");
		/*@Autowired属性属性使用演示*/
		user.eatWithLeftHand();
		/*@Resource属性属性使用演示*/
		user.eatWithRightHand();
	}
	
	
}
