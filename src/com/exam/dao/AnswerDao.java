package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.domain.InvPaperT;
import com.exam.domain.ObjAnswer;
import com.exam.domain.SobjAnswer;
import com.exam.domain.SsubAnswer;
import com.exam.domain.InvPaper;
import com.exam.util.DBUtil;

public class AnswerDao {

	/**
	 * 保存学生的objAnswer
	 * @param sobjAnswer
	 * @param conn
	 * @throws Exception
	 */
	public void addObjAnswer(SobjAnswer sobjAnswer,Connection conn) throws Exception{
		String sql = "insert into els_ks_obj_answer(objectiveId,objective_detail,objective_optionA,objective_optionB,objective_optionC,objective_optionD,objectiveAnswer,rightAnswer,score,account,name,paperId,courseId,startTime,endTime,ip,hostName,time,type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);                        
			pstmt.setString(1, sobjAnswer.getObjectId());
			pstmt.setString(2, sobjAnswer.getDetail());
			pstmt.setString(3, sobjAnswer.getOptionA());
			pstmt.setString(4, sobjAnswer.getOptionB());
			pstmt.setString(5, sobjAnswer.getOptionC());
			pstmt.setString(6, sobjAnswer.getOptionD());
			pstmt.setString(7, sobjAnswer.getObjectAnswer());
			pstmt.setString(8, sobjAnswer.getRightAnswer());
			pstmt.setInt(9, sobjAnswer.getScore());
			pstmt.setString(10, sobjAnswer.getAccount());
			pstmt.setString(11, sobjAnswer.getName());
			pstmt.setString(12, sobjAnswer.getPaperId());
			pstmt.setInt(13, sobjAnswer.getCourseId());
			pstmt.setTimestamp(14, sobjAnswer.getStartTime());
			pstmt.setTimestamp(15, sobjAnswer.getEndTime());
			pstmt.setString(16, sobjAnswer.getIp());
			pstmt.setString(17, sobjAnswer.getHostName());
			pstmt.setString(18, sobjAnswer.getTime());
			pstmt.setString(19, sobjAnswer.getType());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
		}
	}
	
	/**
	 * 保存学生的subAnswer
	 * @param ssubAnswer
	 * @param conn
	 * @throws Exception
	 */
	public void addSubAnswer(SsubAnswer ssubAnswer,Connection conn)throws Exception{
		String sql="insert into els_ks_sub_answer(subjectiveId,subDetial,subjectiveAnswer,biaozhundaan,keyWords,score,account,name,paperId,courseId,startTime,endTime,ip,hostName,time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ssubAnswer.getSubjectId());
			pstmt.setString(2, ssubAnswer.getSubDetail());
			pstmt.setString(3, ssubAnswer.getSubjectAnswer());
			pstmt.setString(4, ssubAnswer.getBiaozhundaan());
			pstmt.setString(5, ssubAnswer.getKeyWords());
			pstmt.setString(6, ssubAnswer.getScore());
			pstmt.setString(7, ssubAnswer.getAccount());
			pstmt.setString(8, ssubAnswer.getName());
			pstmt.setString(9, ssubAnswer.getPaperId());
			pstmt.setInt(10, ssubAnswer.getCourseId());
			pstmt.setTimestamp(11, ssubAnswer.getStartTime());
			pstmt.setTimestamp(12, ssubAnswer.getEndTime());
			pstmt.setString(13, ssubAnswer.getIp());
			pstmt.setString(14, ssubAnswer.getHostName());
			pstmt.setString(15, ssubAnswer.getTime());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
		}
	}
	
	/**
	 * 加载学生的obj答案
	 * @param paperId
	 * @param account
	 * @param conn
	 * @return
	 */
	public List<InvPaper> loadAnswer(String paperId,String account, Connection conn){
		String sql="select paperId,courseId from els_ks_obj_answer where paperId=? and account=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<InvPaper> sobalist=new ArrayList<InvPaper>();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			pstmt.setString(2, account);
			rs=pstmt.executeQuery();
			while(rs.next()){
				InvPaper ip=new InvPaper();
				ip.setPaperId(rs.getString("paperId"));
				ip.setCourseId(rs.getString("courseId"));
				sobalist.add(ip);
				}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return sobalist;
	}
	
	/**
	 * 加载学生的sub答案
	 * @param paperId
	 * @param account
	 * @param conn
	 * @return
	 */
	public List<InvPaperT> loadSubAnswer(String paperId,String account,Connection conn){
		String sql="select courseId,paperId from els_ks_sub_answer where paperId=? and account=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<InvPaperT> subT=new ArrayList<InvPaperT>();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			pstmt.setString(2, account);
			rs=pstmt.executeQuery();
			while(rs.next()){
				InvPaperT it=new InvPaperT();
				it.setCourseId(rs.getString("courseId"));
				it.setPaperId(rs.getString("paperId"));
				subT.add(it);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return subT;
	}

}
