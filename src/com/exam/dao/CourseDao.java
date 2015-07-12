package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.domain.CourseStudent;
import com.exam.util.DBUtil;

public class CourseDao {
	/**
	 * 
	 * @param account
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<CourseStudent> showCourse(String account,Connection conn) throws Exception{
		String sql = "select * from course_list where id in (select course_id from course_student where account=?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = new ArrayList<CourseStudent>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseStudent c1 = new CourseStudent();
				c1.setCourseName(rs.getString("name"));
				c1.setId(rs.getInt("id"));
				list.add(c1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, rs);
		}
		return list;
	}

}
