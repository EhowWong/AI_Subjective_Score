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
		//��ȡ���ݿ������ļ��е���Ϣ
		Properties p = new Properties();
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db-config.properties"));
			driverName = p.getProperty("driverName");
			username = p.getProperty("username");
			password = p.getProperty("password");
			url = p.getProperty("url");
			//��������
			Class.forName(driverName);
		} catch (Exception e) {
			System.out.println("***���������ļ����߼����������ִ���***");
		}
	}
	/**
	 * �������ݿ�����
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("***�������ݿ�����ʧ��***");
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("***�ر�Connectionʧ��***");
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("***�ر�PreparedStatementʧ��***");
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("***�ر�ResultSetʧ��***");
			}
		}
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("***�ر�Connectionʧ��***");
			}
		}
	}
	
	public static void close(PreparedStatement pstmt,ResultSet rs) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("***�ر�PreparedStatementʧ��***");
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("***�ر�ResultSetʧ��***");
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("***�ر�PreparedStatementʧ��***");
			}
		}
	}
	/**
	 * ��������
	 * @param conn
	 */
	public static void beginTransaction(Connection conn) {
		try {
			if (conn != null) {
				if (conn.getAutoCommit()) {
					conn.setAutoCommit(false); //�ֶ��ύ
				}
			}
		} catch (SQLException e) {
			System.out.println("***��������ʧ��***");
		}
	}
	/**
	 * �ύ����
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
			System.out.println("***�����ύʧ��***");
		}
	}
	/**
	 * ����ع�
	 * @param conn
	 */
	public static void rollBackTransaction(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			System.out.println("***����ع�ʧ��***");
		}
	}
}
