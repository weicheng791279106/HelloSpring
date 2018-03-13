package com.weicheng.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**ͨ���޲ι��췽����������*/
	@org.junit.Test
	public void test(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/annotation/applicationContext.xml");
		User user = (User) context.getBean("user");
		user.use();
	}
	
	/**scope������ʾ*/
	@org.junit.Test
	public void testScope(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/annotation/applicationContext.xml");
		
		/*singleton��ʾ*/
		SingletonUser singletonUser1 = (SingletonUser) context.getBean("singletonUser");
		SingletonUser singletonUser2 = (SingletonUser) context.getBean("singletonUser");
		System.out.println("singletonUser1:" + singletonUser1 + " singletonUser2:" + singletonUser2);
		
		/*prototype��ʾ*/
		PrototypeUser prototypeUser1 = (PrototypeUser) context.getBean("prototypeUser");
		PrototypeUser prototypeUser2 = (PrototypeUser) context.getBean("prototypeUser");
		System.out.println("prototypeUser1:" + prototypeUser1 + " prototypeUser2:" + prototypeUser2);
	}
	
	/**set����ע�����������ʾ*/
	@org.junit.Test
	public void testSetObjArg(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/annotation/applicationContext.xml");
		User user = (User) context.getBean("user");
		/*@Autowired��������ʹ����ʾ*/
		user.eatWithLeftHand();
		/*@Resource��������ʹ����ʾ*/
		user.eatWithRightHand();
	}
	
	
}
