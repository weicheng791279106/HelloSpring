package com.weicheng.ioc.config;

/**
 * ioc xml����ʹ�þ�̬������������������ʾ
 * */
public class UserStaticFactory {
	
	/**��̬��������*/
	public static User getUser(){
		return new User();
	}

}
