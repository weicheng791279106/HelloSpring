package com.weicheng.jdbc.transaction.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**�˻�Dao*/
@Repository("accountDao")
public class AccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**ת��*/
	@Transactional
	public void transfer(int from,int to,int money){
		jdbcTemplate.update("update t_account set money = money - ? where id = ?",money,from);
		int a = 1/0; //ģ�����
		jdbcTemplate.update("update t_account set money = money + ? where id = ?",money,to);
	}
	
	/**��ѯ���*/
	public int queryMoney(int id){
		return jdbcTemplate.queryForObject("select money from t_account where id = ?", Integer.class,id);
	}

}
