package com.weicheng.jdbc.transaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**账户Dao*/
@Repository("accountDao")
public class AccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**转账*/
	public void transfer(int from,int to,int money){
		jdbcTemplate.update("update t_account set money = money - ? where id = ?",money,from);
		int a = 1/0; //模拟出错
		jdbcTemplate.update("update t_account set money = money + ? where id = ?",money,to);
	}
	
	/**查询余额*/
	public int queryMoney(int id){
		return jdbcTemplate.queryForObject("select money from t_account where id = ?", Integer.class,id);
	}

}
