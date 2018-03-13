package com.weicheng.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**ģ��dao��ʹ��c3p0���ӳ�ע����ʾ*/
@Repository("userDao")
public class UserDao {
	
	/**�Զ�ע��xml�ļ������úõ�JdbcTemplate*/
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**������û�*/
	public void addUser(String name){
		String sql = "insert into t_user (name) value(?)";
		jdbcTemplate.update(sql,name);
	}

}
