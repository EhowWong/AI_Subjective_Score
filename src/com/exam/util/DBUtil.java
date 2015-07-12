package com.exam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	private final static DBUtil dbUtil = new DBUtil();

	private static String driverName;

	private static String username;

	private static String password;
	
	private static String url;

	private DBUtil() {
		//获取数据库配置文件中的信息
		Properties p = new Properties();
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db-config.properties"));
			driverName = p.getProperty("driverName");
			username = p.getProperty("username");
			password = p.getProperty("password");
			url = p.getProperty("url");
			//加载驱动
			Class.forName(driverName);
		} catch (Exception e) {
			System.out.println("***加载配置文件或者加载驱动出现错误***");
		}
	}
	/**
	 * 创建数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("***创建数据库连接失败***");
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("***关闭Connection失败***");
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("***关闭PreparedStatement失败***");
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("***关闭ResultSet失败***");
			}
		}
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("***关闭Connection失败***");
			}
		}
	}
	
	public static void close(PreparedStatement pstmt,ResultSet rs) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("***关闭PreparedStatement失败***");
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("***关闭ResultSet失败***");
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("***关闭PreparedStatement失败***");
			}
		}
	}
	/**
	 * 开启事务
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
		try {
			if (conn != null) {
				if (conn.getAutoCommit()) {
					conn.setAutoCommit(false); //手动提交
				}
			}
		} catch (SQLException e) {
			System.out.println("***开启事务失败***");
		}
	}
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void commitTransaction(Connection conn) {
		try {
			if (conn != null) {
				if (!conn.getAutoCommit()) {
					conn.commit();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("***事务提交失败***");
		}
	}
	/**
	 * 事务回滚
	 * @param conn
	 */
	public static void rollBackTransaction(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			System.out.println("***事务回滚失败***");
		}
	}
}
