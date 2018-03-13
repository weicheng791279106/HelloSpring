package com.weicheng.ioc.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ������
 * */
public class Test {

	/**ͨ���޲ι��췽����������*/
	@org.junit.Test
	public void test(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("user");
		user.use();
	}
	
	/**ͨ����̬������������*/
	@org.junit.Test
	public void testStaticFactory(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("staticFactoryUser");
		user.use();
	}
	
	/**ͨ����ͨ������������*/
	@org.junit.Test
	public void testFactory(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("factoryUser");
		user.use();
	}
	
	/**scope������ʾ*/
	@org.junit.Test
	public void testScope(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		
		/*singleton��ʾ*/
		User singletonUser1 = (User) context.getBean("singletonUser");
		User singletonUser2 = (User) context.getBean("singletonUser");
		System.out.println("singletonUser1:" + singletonUser1 + " singletonUser2:" + singletonUser2);
		
		/*prototype��ʾ*/
		User prototypeUser1 = (User) context.getBean("prototypeUser");
		User prototypeUser2 = (User) context.getBean("prototypeUser");
		System.out.println("prototypeUser1:" + prototypeUser1 + " prototypeUser2:" + prototypeUser2);
	}
	
	/**�вι��췽��ע��������ʾ*/
	@org.junit.Test
	public void testConstructorArg(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("constructorArgUser");
		user.use();
	}
	
	/**set����ע����ͨ������ʾ*/
	@org.junit.Test
	public void testSetArg(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("setArgUser");
		user.use();
	}
	
	/**set����ע�����������ʾ*/
	@org.junit.Test
	public void testSetObjArg(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("userWithHand");
		user.eat();
	}
	
	/**set����ע�븴�Ӷ���������ʾ*/
	@org.junit.Test
	public void testcomplexArg(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("complexArgUser");
		user.printSons();
	}
	
	
	
	
}
