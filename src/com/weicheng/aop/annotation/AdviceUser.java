package com.weicheng.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**User��ǿ��*/
@Aspect
public class AdviceUser {
	
	/**ǰ����ǿ*/
	@Before("execution(* com.weicheng.aop.annotation.User.use(..))")
	public void beforeUse(){
		System.out.println("AdviceUser:beforeUse...");
	}
	
	/**������ǿ*/
	@AfterReturning("execution(* com.weicheng.aop.annotation.User.use(..))")
	public void afterUse(){
		System.out.println("AdviceUser:afterUse...");
	}
	
	/**������ǿ*/
	@Around("execution(* com.weicheng.aop.annotation.User.use(..))")
	public void aroundUse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("AdviceUser:aroundUse before...");
		proceedingJoinPoint.proceed();
		System.out.println("AdviceUser:aroundUse aftet...");
	}
	
}
