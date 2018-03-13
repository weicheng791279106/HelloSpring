package com.weicheng.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**模拟dao层使用c3p0连接池注入演示*/
@Repository("userDao")
public class UserDao {
	
	/**自动注入xml文件中配置好的JdbcTemplate*/
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**添加新用户*/
	public void addUser(String name){
		String sql = "insert into t_user (name) value(?)";
		jdbcTemplate.update(sql,name);
	}

}
