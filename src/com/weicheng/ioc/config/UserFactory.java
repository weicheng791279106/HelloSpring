package com.weicheng.ioc.config;

/**
 * ioc xml����ʹ����ͨ������������������ʾ
 * 
 * */
public class UserFactory {

	public User getUser(){
		return new User();
	}
	
}
