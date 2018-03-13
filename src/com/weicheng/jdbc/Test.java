package com.weicheng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 * 本测试用例中的表结构为：
 * CREATE TABLE `t_user` (
 * `id` bigint(20) NOT NULL AUTO_INCREMENT,
 * `name` varchar(255) NOT NULL,
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
 * 
 * 
 * */
public class Test {

	/**数据添加演示*/
	@org.junit.Test
	public void testAdd(){
		
		/*设置数据源*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*创建jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*调用jdbcTemplate实现数据库操作*/
		String sql = "insert into t_user (name) value(?)";
		jdbcTemplate.update(sql,"韦大宝");
		
	}
	
	/**数据修改演示*/
	@org.junit.Test
	public void testUpdate(){
		
		/*设置数据源*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*创建jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*调用jdbcTemplate实现数据库操作*/
		String sql = "update t_user set name = ? where id = ?";
		jdbcTemplate.update(sql,"韦小宝",1);
		
	}
	
	/**数据删除演示*/
	@org.junit.Test
	public void testDelete(){
		
		/*设置数据源*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*创建jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*调用jdbcTemplate实现数据库操作*/
		String sql = "delete from t_user where name = ?";
		jdbcTemplate.update(sql,"韦小宝");
		
	}
	
	/**不使用JdbcTemplate封装直接使用jdbc查询数据演示*/
	@org.junit.Test
	public void testJdbcQuery(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			/*加载驱动*/
			Class.forName("com.mysql.jdbc.Driver");
			/*创建连接*/
			conn = DriverManager.getConnection("jdbc:mysql:///test","root","123456");
			String sql = "select * from t_user where name = ?";
			/*预编译sql*/
			psmt = conn.prepareStatement(sql);
			/*设置参数*/
			psmt.setString(1, "二货老婆");
			/*执行*/
			rs = psmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				User user = new User(id,name);
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**查询数据库某一个值演示*/
	@org.junit.Test
	public void testQueryCount(){
		
		/*设置数据源*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*创建jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*调用jdbcTemplate实现数据库操作*/
		/*查询数据库数据数量*/
		String sql = "select count(*) from t_user";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		/*查询特定数据id*/
		sql = "select id from t_user where name = ?";
		int id = jdbcTemplate.queryForObject(sql, Integer.class,"李凤仙");
		/*查询特定数据内容*/
		sql = "select name from t_user where id = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class,2);
		System.out.println("数据库数据数量：" + count + "\n李凤仙的id是：" + id + "\nid=2的用户名称为：" + name);
		
	}
	
	/**查询数据库并转成Object演示*/
	@org.junit.Test
	public void testQueryObject(){
		
		/*设置数据源*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*创建jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select * from t_user where id = ?";
		/*创建rowMapper将查询结果转化为Object*/
		RowMapper<User> rowMapper = new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int num) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				return new User(id,name);
			}} ;
			
		/*调用jdbcTemplate实现数据库操作*/
		User user = jdbcTemplate.queryForObject(sql, rowMapper,2);
		System.out.println(user);
		
	}
	
	/**查询数据库多条数据并转成Object演示*/
	@org.junit.Test
	public void testQueryList(){
		
		/*设置数据源*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*创建jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select * from t_user ";
		/*创建rowMapper将查询结果转化为Object*/
		RowMapper<User> rowMapper = new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int num) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				return new User(id,name);
			}} ;
			
		/*调用jdbcTemplate实现数据库操作*/
		List<User> userList = jdbcTemplate.query(sql, rowMapper);
		System.out.println(userList);
		
	}
	
	/**使用c3p0连接池演示*/
	@org.junit.Test
	public void testC3p0(){
		/*加载xml配置文件*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/jdbc/applicationContext.xml");
		UserDao dao = (UserDao) context.getBean("userDao");
		dao.addUser("唐钰小宝");
	}
	
}
