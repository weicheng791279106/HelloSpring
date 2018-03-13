package com.weicheng.aop;

public class Hello {

	/**
	 * AOP：面向切面编程，拓展功能而不通过修改源代码来实现
	 * 
	 * AOP原理：
	 * 	1、有接口的类：创建接口的实现类的动态代理（jdk动态代理）
	 * 	2、无接口的类：创建其子类的动态代理（CGLib动态代理）
	 * 
	 * AOP相关术语：
	 * 	1、Advice（增强/通知）：需要通过AOP拓展的功能
	 * 	2、JoinPoint（连接点）：类中可以被增强的方法，这些方法称为连接点
	 * 	3、Pointcut（切入点）：在类里边可以由很多方法被增强，其中实际被增强的方法称为切入点
	 *	4、Aspect（切面）：把增强应用到具体的方法（切入点）上面，这个过程称为切面
	 *
	 * 常用的增强类型：
	 * 	1、before：前置通知, 在方法执行之前执行
	 * 	2、after：后置通知, 在方法执行之后执行 。
	 * 	3、afterRunning：返回通知, 在方法返回结果之后执行
	 *  4、afterThrowing：异常通知, 在方法抛出异常之后
	 *  5、around：环绕通知, 围绕着方法执行
	 * 
	 * AspectJ简介：
	 * 	1、AspectJ是一个面向切面的框架，不是spring的一部分，但是可以和spring一起使用来实现AOP功能
	 * 	2、spring2.0以后新增了对AspectJ的支持，新版本的spring框架建议使用AspectJ方式来开发AOP
	 * 
	 * 使用AspectJ实现AOP有两种方式：
	 * 	1、基于aspectJ的xml配置
	 * 	2、基于aspectJ的注解方式
	 * 
	 * AOP操作准备
	 * 	1、导入aop相关jar包
	 * 	2、创建aop配置文件并导入相关schema约束
	 * 	3、开始配置AOP实现相关操作（xml配置或使用注解）
	 * 
	 * 常用的切入点表达式：
	 * execution(<访问修饰符>?<返回类型><方法名>(<参数>)<异常>)
	 * 常用写法示例：
	 * 	1、execution(* com.weicheng.aop.config.User.use(..)) 对特定类的特定方法进行增强
	 * 	2、execution(* com.weicheng.aop.config.User.*(..))	  对特定类的所有方法进行增强
	 *  3、execution(* use*(..)) 匹配所有use开头的方法
	 * 	4、execution(* *.*(..))	对所有类的所有方法进行增强
	 * 
	 * */
	
}
