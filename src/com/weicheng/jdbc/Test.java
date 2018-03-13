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
 * �����������еı�ṹΪ��
 * CREATE TABLE `t_user` (
 * `id` bigint(20) NOT NULL AUTO_INCREMENT,
 * `name` varchar(255) NOT NULL,
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
 * 
 * 
 * */
public class Test {

	/**���������ʾ*/
	@org.junit.Test
	public void testAdd(){
		
		/*��������Դ*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*����jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*����jdbcTemplateʵ�����ݿ����*/
		String sql = "insert into t_user (name) value(?)";
		jdbcTemplate.update(sql,"Τ��");
		
	}
	
	/**�����޸���ʾ*/
	@org.junit.Test
	public void testUpdate(){
		
		/*��������Դ*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*����jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*����jdbcTemplateʵ�����ݿ����*/
		String sql = "update t_user set name = ? where id = ?";
		jdbcTemplate.update(sql,"ΤС��",1);
		
	}
	
	/**����ɾ����ʾ*/
	@org.junit.Test
	public void testDelete(){
		
		/*��������Դ*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*����jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*����jdbcTemplateʵ�����ݿ����*/
		String sql = "delete from t_user where name = ?";
		jdbcTemplate.update(sql,"ΤС��");
		
	}
	
	/**��ʹ��JdbcTemplate��װֱ��ʹ��jdbc��ѯ������ʾ*/
	@org.junit.Test
	public void testJdbcQuery(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			/*��������*/
			Class.forName("com.mysql.jdbc.Driver");
			/*��������*/
			conn = DriverManager.getConnection("jdbc:mysql:///test","root","123456");
			String sql = "select * from t_user where name = ?";
			/*Ԥ����sql*/
			psmt = conn.prepareStatement(sql);
			/*���ò���*/
			psmt.setString(1, "��������");
			/*ִ��*/
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
	
	/**��ѯ���ݿ�ĳһ��ֵ��ʾ*/
	@org.junit.Test
	public void testQueryCount(){
		
		/*��������Դ*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*����jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		/*����jdbcTemplateʵ�����ݿ����*/
		/*��ѯ���ݿ���������*/
		String sql = "select count(*) from t_user";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		/*��ѯ�ض�����id*/
		sql = "select id from t_user where name = ?";
		int id = jdbcTemplate.queryForObject(sql, Integer.class,"�����");
		/*��ѯ�ض���������*/
		sql = "select name from t_user where id = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class,2);
		System.out.println("���ݿ�����������" + count + "\n����ɵ�id�ǣ�" + id + "\nid=2���û�����Ϊ��" + name);
		
	}
	
	/**��ѯ���ݿⲢת��Object��ʾ*/
	@org.junit.Test
	public void testQueryObject(){
		
		/*��������Դ*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*����jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select * from t_user where id = ?";
		/*����rowMapper����ѯ���ת��ΪObject*/
		RowMapper<User> rowMapper = new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int num) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				return new User(id,name);
			}} ;
			
		/*����jdbcTemplateʵ�����ݿ����*/
		User user = jdbcTemplate.queryForObject(sql, rowMapper,2);
		System.out.println(user);
		
	}
	
	/**��ѯ���ݿ�������ݲ�ת��Object��ʾ*/
	@org.junit.Test
	public void testQueryList(){
		
		/*��������Դ*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		
		/*����jdbcTemplate*/
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select * from t_user ";
		/*����rowMapper����ѯ���ת��ΪObject*/
		RowMapper<User> rowMapper = new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int num) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				return new User(id,name);
			}} ;
			
		/*����jdbcTemplateʵ�����ݿ����*/
		List<User> userList = jdbcTemplate.query(sql, rowMapper);
		System.out.println(userList);
		
	}
	
	/**ʹ��c3p0���ӳ���ʾ*/
	@org.junit.Test
	public void testC3p0(){
		/*����xml�����ļ�*/
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/weicheng/jdbc/applicationContext.xml");
		UserDao dao = (UserDao) context.getBean("userDao");
		dao.addUser("����С��");
	}
	
}
