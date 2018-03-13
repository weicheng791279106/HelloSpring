package com.weicheng.ioc.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**ʹ��ע�����ɶ���ע��������ʾ*/
@Component("user") //��Ч����xml������ <bean id="user" class="com.weicheng.ioc.annotation.User"></bean>
public class User {
	
	/**@Autowiredע��������ʾ�����������ɶ�Ӧ����ע��*/
	@Autowired
	private Hand leftHand;
	
	/**@Resourceע��������ʾ������name����Ӧ��bean���ɶ�Ӧ����ע��*/
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
