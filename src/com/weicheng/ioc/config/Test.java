package com.weicheng.ioc.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * */
public class Test {

	/**通过无参构造方法创建对象*/
	@org.junit.Test
	public void test(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("user");
		user.use();
	}
	
	/**通过静态工厂创建对象*/
	@org.junit.Test
	public void testStaticFactory(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("staticFactoryUser");
		user.use();
	}
	
	/**通过普通工厂创建对象*/
	@org.junit.Test
	public void testFactory(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("factoryUser");
		user.use();
	}
	
	/**scope属性演示*/
	@org.junit.Test
	public void testScope(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		
		/*singleton演示*/
		User singletonUser1 = (User) context.getBean("singletonUser");
		User singletonUser2 = (User) context.getBean("singletonUser");
		System.out.println("singletonUser1:" + singletonUser1 + " singletonUser2:" + singletonUser2);
		
		/*prototype演示*/
		User prototypeUser1 = (User) context.getBean("prototypeUser");
		User prototypeUser2 = (User) context.getBean("prototypeUser");
		System.out.println("prototypeUser1:" + prototypeUser1 + " prototypeUser2:" + prototypeUser2);
	}
	
	/**有参构造方法注入属性演示*/
	@org.junit.Test
	public void testConstructorArg(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("constructorArgUser");
		user.use();
	}
	
	/**set方法注入普通属性演示*/
	@org.junit.Test
	public void testSetArg(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("setArgUser");
		user.use();
	}
	
	/**set方法注入对象属性演示*/
	@org.junit.Test
	public void testSetObjArg(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("userWithHand");
		user.eat();
	}
	
	/**set方法注入复杂对象属性演示*/
	@org.junit.Test
	public void testcomplexArg(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/ioc/config/applicationContext.xml");
		User user = (User) context.getBean("complexArgUser");
		user.printSons();
	}
	
	
	
	
}
