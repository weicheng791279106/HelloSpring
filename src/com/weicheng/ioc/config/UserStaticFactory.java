package com.weicheng.ioc.config;

/**
 * ioc xml配置使用静态工厂类来创建对象演示
 * */
public class UserStaticFactory {
	
	/**静态工厂方法*/
	public static User getUser(){
		return new User();
	}

}
