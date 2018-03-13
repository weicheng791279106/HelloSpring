package com.weicheng.ioc.annotation;

public class Hello {

	/**
	 * spring的注解方式实现IOC操作演示
	 * 
	 * 本示例中主要演示以下相关知识点：
	 * 	1、注解创建对象
	 * 	2、注解注入属性
	 * 
	 * spring注解开发准备：
	 * 	1、导入相关jar包
	 * 		(1)基础的spring jar包
	 * 		(2)aop的jar包：spring-aop-4.2.4.RELEASE.jar
	 * 
	 * 
	 * 注解创建对象步骤：
	 * 	1、创建xml配置文件，引入相应schema约束，开启注解扫描
	 *  2、创建对象类，并在类名上加入注解@Component
	 *  
	 * 创建对象有四个注解：
	 * 	1、@Component：基础的创建对象的注解
	 * 	2、@Controller：web层
	 * 	3、@Service：业务层
	 * 	4、@Repository：持久层
	 * 其中@Controller、@Service、@Repository是为了让注解用途清晰，功能与@Component并无区别
	 * 
	 * 注解注入属性步骤：
	 * 	1、创建xml配置文件，引入相应schema约束，开启注解扫描
	 * 	2、编写需要创建的类及其属性
	 * 	3、在需要注入的属性上边加入@Autowired或@Resource注解
	 * 
	 * 属性注入有两个注解：
	 * 	1、@Autowired：根据类名去找需要注入的对象
	 * 	2、@Resource：根据name值去找需要注入的对象
	 * 
	 * 
	 * */
	
}
