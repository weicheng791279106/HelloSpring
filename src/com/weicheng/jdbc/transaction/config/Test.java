package com.weicheng.jdbc.transaction.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**ת�˲���
	 * @throws Exception */
	@org.junit.Test
	public void testTransfer() throws Exception{
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/jdbc/transaction/config/applicationContext.xml");
		AccountService accountService = (AccountService) context.getBean("accountService");
		accountService.transfer(1, 2, 1000);
	}
	
}
