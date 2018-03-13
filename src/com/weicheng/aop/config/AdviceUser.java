package com.weicheng.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;

/**User增强类*/
public class AdviceUser {
	
	/**前置增强*/
	public void beforeUse(){
		System.out.println("AdviceUser:beforeUse...");
	}
	
	/**后置增强*/
	public void afterUse(){
		System.out.println("AdviceUser:afterUse...");
	}
	
	/**环绕增强*/
	public void aroundUse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("AdviceUser:aroundUse before...");
		proceedingJoinPoint.proceed();
		System.out.println("AdviceUser:aroundUse aftet...");
	}
	
}
