package com.weicheng.jdbc.transaction.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**�˻�Service*/
@Service("accountService")
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	public void transfer(int from,int to,int money) throws Exception{
		if(accountDao.queryMoney(from) < money) throw new Exception("�˻�����");
		accountDao.transfer(from, to, money);
	}
	
}
