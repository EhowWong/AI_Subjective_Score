package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.domain.Student;
import com.exam.util.DBUtil;

public class LoginDao {

	/**
	 * student login
	 * @throws SQLException 
	 * 
	 */
	public Student sLogin(String account,String password,Connection conn) throws SQLException{
		String sql="select a1.account,a1.passwd,a1.name,a2.course_id from els_user_student as a1 left join course_student as a2 on a1.account=a2.account where a1.account=? and a1.passwd=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student=new Student();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			while(rs.next()){
				student.setAccount(rs.getString("account"));
				student.setPasswd(rs.getString("passwd"));
				student.setName(rs.getString("name"));
				student.setCourseId(rs.getString("course_id"));
			}
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return student;
		
	}
}
