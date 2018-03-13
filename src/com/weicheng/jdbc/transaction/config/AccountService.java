package com.weicheng.jdbc.transaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**ÕË»§Service*/
@Service("accountService")
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	public void transfer(int from,int to,int money) throws Exception{
		if(accountDao.queryMoney(from) < money) throw new Exception("ÕË»§Óà¶î²»×ã");
		accountDao.transfer(from, to, money);
	}
	
}
