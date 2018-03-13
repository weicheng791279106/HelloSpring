package com.weicheng.ioc.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**使用注解生成对象及注入属性演示*/
@Component("user") //等效于在xml中配置 <bean id="user" class="com.weicheng.ioc.annotation.User"></bean>
public class User {
	
	/**@Autowired注入属性演示：根据类生成对应对象注入*/
	@Autowired
	private Hand leftHand;
	
	/**@Resource注入属性演示：根据name所对应的bean生成对应对象注入*/
	@Resource(name="hand")
	private Hand rightHand;
	
	public void use(){
		System.out.println("User:use...");
	}
	
	public void eatWithLeftHand(){
		System.out.println("leftHand:");
		if(leftHand != null) leftHand.eat();
	}
	
	public void eatWithRightHand(){
		System.out.println("rightHand:");
		if(leftHand != null) leftHand.eat();
	}
	
}
