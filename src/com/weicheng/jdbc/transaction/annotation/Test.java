package com.weicheng.jdbc.transaction.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * �����������еı�ṹΪ��
 * CREATE TABLE `t_account` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `name` varchar(20) DEFAULT NULL,
 * `money` int(11) NOT NULL,
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 * 
 * */
public class Test {

	/**ת�˲���
	 * @throws Exception */
	@org.junit.Test
	public void testTransfer() throws Exception{
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/jdbc/transaction/annotation/applicationContext.xml");
		AccountService accountService = (AccountService) context.getBean("accountService");
		accountService.transfer(1, 2, 1000);
	}
	
}
