package com.weicheng.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;

/**User��ǿ��*/
public class AdviceUser {
	
	/**ǰ����ǿ*/
	public void beforeUse(){
		System.out.println("AdviceUser:beforeUse...");
	}
	
	/**������ǿ*/
	public void afterUse(){
		System.out.println("AdviceUser:afterUse...");
	}
	
	/**������ǿ*/
	public void aroundUse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("AdviceUser:aroundUse before...");
		proceedingJoinPoint.proceed();
		System.out.println("AdviceUser:aroundUse aftet...");
	}
	
}
