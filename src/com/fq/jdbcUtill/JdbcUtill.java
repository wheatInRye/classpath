package com.fq.jdbcUtill;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class JdbcUtill {
	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driverClass = null;
	
	/*
	 * 注册驱动
	 */
	static {
		//读取db.properties信息
		Properties props = new Properties();
		try {
			InputStream in = JdbcUtill.class.getResourceAsStream("/db.properties");
			props.load(in);
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			driverClass = props.getProperty("driverClass");
			
			//加载驱动
			Class.forName(driverClass);
					
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/*
	 * 连接数据库
	 */
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/*
	 * 关闭资源
	 */
	public static void close(Statement stmt,Connection conn) {
		try {
			if(stmt !=null)
				stmt.close();				
			
			if(conn !=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs !=null)
				rs.close();
			if(stmt !=null)
				stmt.close();							
			if(conn !=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
}
