package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.exam.domain.ObjAnswer;
import com.exam.domain.Objective;
import com.exam.domain.Objective;
import com.exam.domain.Paper;
import com.exam.domain.Subjective;
import com.exam.util.DBUtil;


public class PaperDao {
	/**
	 * 根据试卷的id获得试卷的全部内容
	 * @param paperId
	 * @param conn
	 * @return
	 */
	public List<Paper> getPaperByCourse_id(int courseId,Connection conn) throws Exception{
		String sql = "select * from els_ks_paper where courseId = ? group by paperId";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Paper> list = new ArrayList<Paper>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Paper p = new Paper();
				p.setGenerateTime(rs.getDate("generateTime"));
				p.setObjectIds(rs.getString("objectIds"));
				p.setSubjectIds(rs.getString("subjectIds"));
				p.setId(rs.getInt("id"));
				p.setPaperId(rs.getString("paperId"));
				list.add(p);
			}
		}finally {
			DBUtil.close(pstmt, rs);
		}
		return list;
	}
	/**
	 * 根据paperId取出客观试题生成试卷
	 * @return
	 */
	public List<Objective> getQuestionsBypaperId(String paperId,Connection conn) throws Exception{
		String sql="select * from els_ks_objective where id in (select objectIds from els_ks_paper where paperId=?) ";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Objective> questionsList=new ArrayList<Objective>();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			rs=pstmt.executeQuery();
			while (rs.next()){
				Objective o=new Objective();
				o.setId(rs.getInt("id"));
				o.setDetail(rs.getString("detail"));
				o.setOptionA(rs.getString("optionA"));
				o.setOptionB(rs.getString("optionB"));
				o.setOptionC(rs.getString("optionC"));
				o.setOptionD(rs.getString("optionD"));
				questionsList.add(o);
			}
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return questionsList;
	}
	
	/**
	 * 根据paperId取出主观试题生成试卷
	 * @param paperId
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Subjective> getSubjectiveBypaperId(String paperId,int courseId,Connection conn) throws Exception{
		String sql="select * from els_ks_subjective where id in (select subjectIds from els_ks_paper where paperId=? and courseId=?) ";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Subjective> subList=new ArrayList<Subjective>();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			pstmt.setInt(2, courseId);
			rs=pstmt.executeQuery();
			while (rs.next()){
				Subjective s=new Subjective();
				s.setId(rs.getInt("id"));
				s.setDetail(rs.getString("detail"));
				s.setKeyWords(rs.getString("keyWords"));
				s.setBiaozhundaan(rs.getString("biaozhundaan"));
				subList.add(s);
			}
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return subList;
	}
	
	/**
	 * 根据paperId拿答案
	 * @param paperId
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<ObjAnswer> getObjectiveKeyBypaperId(String paperId,Connection conn) throws Exception{
		String sql="select * from els_ks_objective where id in (select objectIds from els_ks_paper where paperId=?) ";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ObjAnswer> obkList=new ArrayList<ObjAnswer>();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			rs=pstmt.executeQuery();
			while (rs.next()){
				ObjAnswer obA=new ObjAnswer();
				obA.setId(rs.getString("id"));
				obA.setKey(rs.getString("answer"));
				obA.setDetail(rs.getString("detail"));
				obA.setOptionA(rs.getString("optionA"));
				obA.setOptionB(rs.getString("optionB"));
				obA.setOptionC(rs.getString("optionC"));
				obA.setOptionD(rs.getString("optionD"));
				obkList.add(obA);
			}
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return obkList;
	}
	
	/*
	 * 试题添加到试卷
	 */
	public void addToPaper(Paper paper,Connection conn){
		
		String sql="insert into els_ks_paper(objectIds,subjectIds,courseId,generateTime,paperId) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		conn = DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paper.getObjectIds());
			pstmt.setString(2, paper.getSubjectIds());
			pstmt.setInt(3, paper.getCourseId());
			pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
			pstmt.setString(5, paper.getPaperId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
		}
	
	}
	
	/*
	 * 根据id删除已经添加到试卷的客观试题*/
	 
	public void deleteObFromPaper(Paper paper,Connection conn){
		
		String sql="delete from els_ks_paper where objectIds =? and paperId=? and courseId=?";
		PreparedStatement pstmt=null;
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paper.getObjectIds());
			pstmt.setString(2, paper.getPaperId());
			pstmt.setInt(3, paper.getCourseId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
		}
		
	}
	
	/*
	 * 根据id删除已经添加到试卷的主观试题
	 */
	public void deleteSubFromPaper(Paper paper,Connection conn){
		
		String sql="delete from els_ks_paper where subjectIds =? and paperId=? and courseId=?";
		PreparedStatement pstmt=null;
		conn=DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paper.getSubjectIds());
			pstmt.setString(2, paper.getPaperId());
			pstmt.setInt(3, paper.getCourseId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
		}
		
	}
	
	/*
	 * 显示所有的试卷
	 */
	public List<Paper> showAllPaper(String courseId,Connection conn){
		String sql="select * from els_ks_paper where courseId = ? group by paperId order by generateTime";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Paper> PaperList = new ArrayList<Paper>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, courseId);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()){
				Paper paper = new Paper();
				//paper.setId(rs.getInt("id"));
				paper.setPaperId(rs.getString("paperId"));
				paper.setCourseId(rs.getInt("courseId"));
				//paper.setObjectIds(rs.getString("objectIds"));
				paper.setGenerateTime(rs.getTimestamp(("generateTime")));
				//paper.setExamTime(rs.getString("examTime"));
				PaperList.add(paper);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt, rs);
		}
		
		//System.out.println("456"+PaperList);
		return PaperList;
	}
	
	/*
	 * 根据paperId查询每套试卷的客观试题
	 */
	public List<Objective> findTestObjective(String paperId,Connection conn){
		String sql="select * from els_ks_objective where id in(select objectIds from els_ks_paper where paperId = ? ) order by isSingleSelection desc";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Objective> ObjectiveList = new ArrayList<Objective>();
		//List<Subjective> SubjectiveList= new ArrayList<Subjective>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Objective objective = new Objective();
				objective.setId(rs.getInt("id"));
				objective.setDetail(rs.getString("detail"));
				objective.setOptionA(rs.getString("optionA"));
				objective.setOptionB(rs.getString("optionB"));
				objective.setOptionC(rs.getString("optionC"));
				objective.setOptionD(rs.getString("optionD"));
				objective.setAnswer(rs.getString("answer"));
				objective.setChapterId(rs.getInt("chapterId"));
				objective.setCourseId(rs.getInt("courseId"));
				objective.setIsSingleSelection(rs.getInt("isSingleSelection"));
				ObjectiveList.add(objective);
				//Subjective subjective = new Subjective();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt, rs);
		}
		
		//System.out.println("456"+PaperList);
		return ObjectiveList;
	}
	
	
	/*
	 * 根据paperId查询每套试卷的主观试题
	 */
	public List<Subjective> findTestSubjective(String paperId,Connection conn){
		String sql="select * from els_ks_subjective where id in(select subjectIds from els_ks_paper where paperId = ? )";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//List<Objective> ObjectiveList = new ArrayList<Objective>();
		List<Subjective> SubjectiveList= new ArrayList<Subjective>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				//Objective objective = new Objective();
				Subjective subjective = new Subjective();
				subjective.setId(rs.getInt("id"));
				subjective.setDetail(rs.getString("detail"));
				subjective.setKeyWords(rs.getString("keyWords"));
				subjective.setChapterId(rs.getInt("chapterId"));
				subjective.setCourseId(rs.getInt("courseId"));
				SubjectiveList.add(subjective);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return SubjectiveList;
	}
	/*
	 * 添加试卷
	 */
	public void addPaper(Paper paper,Connection conn){
		String sql="insert into els_ks_paper(objectIds,subjectIds,courseId,generateTime,paperId,subScore,objScore) values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		conn = DBUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paper.getObjectIds());
			pstmt.setString(2, paper.getSubjectIds());
			pstmt.setInt(3, paper.getCourseId());
			pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
			pstmt.setString(5, paper.getPaperId());
			pstmt.setString(6, paper.getSubScore());
			pstmt.setString(7, paper.getObjScore());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
		}
	
	}
	
	/*
	 * 删除试卷
	 */
	public void deletePaper(String paperId,Connection conn) throws Exception{
		
		String sql="delete from els_ks_paper where paperId=?";
		PreparedStatement pstmt=null;
		conn=DBUtil.getConnection();
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
		}
	}
	
	/*
	 * 判断添加的试卷是否重复
	 */
		public String differ(String paperId,String courseId,Connection conn){
			String sql="select * from els_ks_paper where paperId=? and courseId=?";
			PreparedStatement pstmt=null;
			ResultSet rs =null;
			conn=DBUtil.getConnection();
			String floor=null;
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, paperId);
				pstmt.setString(2, courseId);
				rs=pstmt.executeQuery();
				if(rs.next()){
					floor="yes";
				}else{
					floor="no";
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.close(pstmt);
			}
			return floor;
			
		}
	
}
