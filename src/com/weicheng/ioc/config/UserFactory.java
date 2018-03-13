package com.weicheng.ioc.config;

/**
 * ioc xml配置使用普通工厂类来创建对象演示
 * 
 * */
public class UserFactory {

	public User getUser(){
		return new User();
	}
	
}
