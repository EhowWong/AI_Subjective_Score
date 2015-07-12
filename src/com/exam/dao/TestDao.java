package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.exam.domain.Objective;
import com.exam.domain.Paper;
import com.exam.domain.SobjAnswer;
import com.exam.domain.SsubAnswer;
import com.exam.domain.Student;
import com.exam.domain.Subjective;
import com.exam.util.DBUtil;
import com.exam.util.PageModel;

public class TestDao {
	/**
	 * @param 添加选择题
	 * @param conn
	 * @throws Exception
	 */
	public void addTestChoice(Objective objective,Connection conn) throws Exception{
		String sql="insert into els_ks_objective(detail,optionA,optionB,optionC,optionD,answer,isSingleSelection,chapterId,courseId) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, objective.getDetail());
			pstmt.setString(2, objective.getOptionA());
			pstmt.setString(3, objective.getOptionB());
			pstmt.setString(4, objective.getOptionC());
			pstmt.setString(5, objective.getOptionD());
			pstmt.setString(6, objective.getAnswer());
			pstmt.setInt(7, objective.getIsSingleSelection());
			pstmt.setInt(8, objective.getChapterId());
			pstmt.setInt(9, objective.getCourseId());
			pstmt.executeUpdate();
		}finally{
			DBUtil.close(pstmt);
		}
	}
	/**
	 * 添加判断题
	 * @param objective
	 * @param conn
	 * @throws Exception
	 */
	public void addTestJudge(Objective objective,Connection conn) throws Exception{
		String sql="insert into els_ks_objective(detail,answer,isSingleSelection,chapterId,courseId)"+
		"values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try{
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, objective.getDetail());
		pstmt.setString(2, objective.getAnswer());
		pstmt.setInt(3, objective.getIsSingleSelection());
		pstmt.setInt(4, objective.getChapterId());
		pstmt.setInt(5, objective.getCourseId());
		pstmt.executeUpdate();
		}finally{
			DBUtil.close(pstmt);
		}
	}
	/**
	 * 根据id删除客观试题
	 * @param id
	 * @param conn
	 * @throws Exception
	 */
public void delTestObjective(String[] id,Connection conn) throws Exception{
		
		StringBuilder sbstr=new StringBuilder();
		for(int i=0;i<id.length;i++){
			sbstr.append("?");
			if(i<(id.length-1)){
				sbstr.append(",");
			}
		}
		String sql="delete from els_ks_objective where id in ("+sbstr.toString()+")";
		PreparedStatement pstmt=null;
		conn=DBUtil.getConnection();
		try{
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<id.length;i++){
				pstmt.setString(i+1, id[i]);
			}
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
		}
	}
	/**
	 * 根据id删除主观试题
	 * @param id
	 * @param conn
	 * @throws Exception
	 */
public void delTestSubjective(String[] selectFlags,Connection conn) throws Exception{
	
	//String sql="delete from els_ks_subjective where id=?";
	StringBuilder sbstr=new StringBuilder();
	for(int i=0;i<selectFlags.length;i++){
		sbstr.append("?");
		if(i<(selectFlags.length-1)){
			sbstr.append(",");
		}
	}
	String sql="delete from els_ks_subjective where id in ("+sbstr.toString()+")";
	
	PreparedStatement pstmt=null;
	conn=DBUtil.getConnection();
	try{
		pstmt = conn.prepareStatement(sql);
		for(int i=0;i<selectFlags.length;i++){
			pstmt.setString(i+1, selectFlags[i]);
		}
		pstmt.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBUtil.close(pstmt);
	}
}
	/**
	 * 修改选择题
	 * @param objective
	 * @param conn
	 * @throws Exception
	 */
	public void modifyTestChoice(Objective objective,Connection conn) throws Exception{
		String sql="update els_ks_objective set detail = ?, optionA = ?, optionB = ?, optionC = ?, optionD = ?, answer = ?, isSingleSelection = ?, chapterId = ?, courseId = ? where id=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, objective.getDetail());
			pstmt.setString(2, objective.getOptionA());
			pstmt.setString(3, objective.getOptionB());
			pstmt.setString(4, objective.getOptionC());
			pstmt.setString(5, objective.getOptionD());
			pstmt.setString(6, objective.getAnswer());
			pstmt.setInt(7, objective.getIsSingleSelection());
			pstmt.setInt(8, objective.getChapterId());
			pstmt.setInt(9, objective.getCourseId());
			pstmt.setInt(10, objective.getId());
			pstmt.executeUpdate();
		}finally{
			DBUtil.close(pstmt);
		}
	}
	/**
	 * 修改判断题
	 * @param objective
	 * @param conn
	 * @throws Exception
	 */
	public void modifyTestJudge(Objective objective,Connection conn) throws Exception{
		String sql="update els_ks_objective set detail = ?,answer = ?,chapterId = ?,courseId = ?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, objective.getDetail());
			pstmt.setString(2, objective.getAnswer());
			pstmt.setInt(3, objective.getChapterId());
			pstmt.setInt(4, objective.getCourseId());
			pstmt.setInt(5, objective.getId());
			pstmt.executeUpdate();
		}finally{
			DBUtil.close(pstmt);
		}
	}
	/**
	 * 查询客观题
	 * @param pageNo
	 * @param pageSize
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public PageModel<Objective> findTestObjectiveList(int pageNo,int pageSize,String courseId,Connection conn) throws Exception{

		StringBuffer sbsql=new StringBuffer();
		sbsql.append("select * from els_ks_objective where courseId=? limit ?,?");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PageModel<Objective> pageModel=null;
		try{
			
			pstmt=conn.prepareStatement(sbsql.toString());
			pstmt.setString(1, courseId);
			pstmt.setInt(2, (pageNo - 1) * pageSize);
			pstmt.setInt(3,  pageSize);
			rs=pstmt.executeQuery();
			List<Objective> choiceList = new ArrayList<Objective>();
			while(rs.next()){
				Objective objective = new Objective();
				objective.setId(rs.getInt("id"));
				objective.setDetail(rs.getString("detail"));
				objective.setOptionA(rs.getString("optionA"));
				objective.setOptionB(rs.getString("optionB"));
				objective.setOptionC(rs.getString("optionC"));
				objective.setOptionD(rs.getString("optionD"));
				objective.setAnswer(rs.getString("answer"));
				objective.setIsSingleSelection(rs.getInt("isSingleSelection"));
				objective.setChapterId(rs.getInt("chapterId"));
				objective.setCourseId(rs.getInt("courseId"));
				choiceList.add(objective);
			}
			 pageModel= new PageModel<Objective>();
			 pageModel.setList(choiceList);
			 pageModel.setPageNo(pageNo);
			 pageModel.setPageSize(pageSize);
			 pageModel.setTotalRecords(getTotalObjectiveRecords(conn,courseId));
			
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return pageModel;
	}
	
	/**
	 * 查询主观题
	 * @param pageNo
	 * @param pageSize
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public PageModel<Subjective> findTestSubjectiveList(int pageNo,int pageSize,String courseId,Connection conn) throws Exception{
		
		StringBuffer sbsql=new StringBuffer();
		sbsql.append("select * from els_ks_subjective where courseId=? limit ?,?");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PageModel<Subjective> pageModel=null;
		try{
			
			pstmt=conn.prepareStatement(sbsql.toString());
			pstmt.setString(1, courseId);
			pstmt.setInt(2, (pageNo - 1) * pageSize);
			pstmt.setInt(3,  pageSize);
			rs=pstmt.executeQuery();
			
			List<Subjective> SubList = new ArrayList<Subjective>();
			while(rs.next()){
				Subjective subjective = new Subjective();
				subjective.setId(rs.getInt("id"));
				subjective.setDetail(rs.getString("detail"));
				subjective.setKeyWords(rs.getString("KeyWords"));
				subjective.setChapterId(rs.getInt("chapterId"));
				subjective.setCourseId(rs.getInt("courseId"));
				SubList.add(subjective);
				
			}
			 pageModel= new PageModel<Subjective>();
			 pageModel.setList(SubList);
			 pageModel.setPageNo(pageNo);
			 pageModel.setPageSize(pageSize);
			 pageModel.setTotalRecords(getTotalSubjectiveRecords(conn,courseId));
			 
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return pageModel;
	}
	/**
	 * 取得客观题的总记录数
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private int getTotalObjectiveRecords(Connection conn,String courseId) throws Exception {
			String sql="select count(*) from els_ks_objective where courseId=?";
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int count=0;
			try{
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, courseId);
				rs=pstmt.executeQuery();
				rs.next();
				count=rs.getInt(1);
			}finally{
				DBUtil.close(pstmt, rs);
			}
				return count;
		}
	
	
	/**
	 * 取得主观题的总记录数
	 * @param conn
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("null")
	private int getTotalSubjectiveRecords(Connection conn,String courseId) throws Exception{
		
		String sql="select count(*) from els_ks_subjective where courseId=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, courseId);
			rs = pstmt.executeQuery();
			rs.next();
			
			count=rs.getInt(1);
		}finally{
			DBUtil.close(pstmt, rs);
		}
			return count;
	}
	
	/**
	 * 添加主观题
	 * @param subjective
	 * @param conn
	 * @throws Exception
	 */
	public void addTestSub(Subjective subjective,Connection conn) throws Exception{
		String sql="insert into els_ks_subjective (detail,KeyWords,chapterId,courseId,biaozhundaan,generateTime) values (?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, subjective.getDetail());
			pstmt.setString(2, subjective.getKeyWords());
			pstmt.setInt(3, subjective.getChapterId());
			pstmt.setInt(4, subjective.getCourseId());
			pstmt.setString(5, subjective.getBiaozhundaan());
			pstmt.setTimestamp(6, new java.sql.Timestamp(new Date().getTime()));
			pstmt.executeUpdate();
		}finally{
			DBUtil.close(pstmt);
		}
		
	}
	

	/**
	 * 修改主观题
	 * @param subjective
	 * @param conn
	 */
	public void modifyTestSub(Subjective subjective,Connection conn) throws Exception{
		String sql="update els_ks_subjective set detail = ?,KeyWords = ?,chapterId = ?,courseId = ? where id=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, subjective.getDetail());
			pstmt.setString(2, subjective.getKeyWords());
			pstmt.setInt(3, subjective.getChapterId());
			pstmt.setInt(4, subjective.getCourseId());
			pstmt.setInt(5, subjective.getId());
			pstmt.executeUpdate();
			System.out.println(subjective.getDetail());
		}finally{
			DBUtil.close(pstmt);
		}
	}
	/*
	 * 根据id查找客观题
	 */
	public Objective findObjective(Connection conn,String id) throws Exception{
		String sql="select * from els_ks_objective where id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Objective objective =null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				objective= new Objective();
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
				
			}
			
		} finally{
			DBUtil.close(pstmt, rs);
		}
		
		return objective;
	}
	/*
	 * 根据id查询主观题
	 */
	public Subjective findSubjective(Connection conn,String id) throws Exception{
		String sql="select * from els_ks_subjective where id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Subjective subjective =null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				subjective= new Subjective();
				subjective.setId(rs.getInt("id"));
				subjective.setDetail(rs.getString("detail"));
				subjective.setBiaozhundaan(rs.getString("biaozhundaan"));
				subjective.setKeyWords(rs.getString("keyWords"));
				subjective.setChapterId(rs.getInt("chapterId"));
				subjective.setCourseId(rs.getInt("courseId"));	
			}
			
		} finally{
			DBUtil.close(pstmt, rs);
		}
		
		return subjective;
	}
	
	/**
	 * 
	 * @param courseId
	 * @param paperId
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public List<Student> showName(String courseId,String paperId,Connection conn) throws SQLException{
		String sql="select * from els_ks_sub_answer where courseId=? and paperId=? group by name;";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student =null;
		List<Student> list=new ArrayList<Student>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, courseId);
			pstmt.setString(2, paperId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				student= new Student();
				student.setAccount(rs.getString("account"));
				student.setName(rs.getString("name"));
				student.setCourseId(rs.getString("courseId"));
				list.add(student);
			}
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return list;
	}
	/**
	 * 
	 * @param courseId
	 * @param paperId
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public List<Student> showName2(String courseId,String paperId,Connection conn) throws SQLException{
		String sql="select * from els_ks_obj_answer where courseId=? and paperId=? group by name;";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student =null;
		List<Student> list=new ArrayList<Student>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, courseId);
			pstmt.setString(2, paperId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				student= new Student();
				student.setAccount(rs.getString("account"));
				student.setName(rs.getString("name"));
				student.setCourseId(rs.getString("courseId"));
				list.add(student);
			}
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return list;
	}
	//查标准分数
	public List<Paper> showScore(String courseId,String paperId,Connection conn) throws SQLException{
		String sql="select * from els_ks_paper where courseId=? and paperId=?;";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Paper paper =null;
		List<Paper> list=new ArrayList<Paper>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, courseId);
			pstmt.setString(2, paperId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				paper= new Paper();
				paper.setObjScore(rs.getString("objScore"));
				paper.setSubScore(rs.getString("subScore"));
				list.add(paper);
			}
		}finally{
			DBUtil.close(pstmt, rs);
		}
		return list;
	}
	
	
	/**
	 * 
	 * @param courseId
	 * @param paperId
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public List<SobjAnswer> showObjAnswer(String account,String paperId,Connection conn) throws SQLException{
		String sql="select * from els_ks_obj_answer where paperId=? and account=?;";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SobjAnswer sobj =null;
		List<SobjAnswer> list=new ArrayList<SobjAnswer>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, paperId);
			pstmt.setString(2, account);
			rs=pstmt.executeQuery();
			while(rs.next()){
				sobj= new SobjAnswer();
				sobj.setDetail(rs.getString("objective_detail"));
				sobj.setOptionA(rs.getString("objective_optionA"));
				sobj.setOptionB(rs.getString("objective_optionB"));
				sobj.setOptionC(rs.getString("objective_optionC"));
				sobj.setOptionD(rs.getString("objective_optionD"));
				sobj.setObjectAnswer(rs.getString("objectiveAnswer"));
				sobj.setRightAnswer(rs.getString("rightAnswer"));
				sobj.setStartTime(rs.getTimestamp("startTime"));
				sobj.setEndTime(rs.getTimestamp("endTime"));
				sobj.setIp(rs.getString("ip"));
				sobj.setHostName(rs.getString("hostName"));
				sobj.setTime(rs.getString("time"));
				sobj.setType(rs.getString("type"));
				list.add(sobj);
			}
		}finally{
			DBUtil.close(pstmt,rs);
		}
		return list;
	}


/**
 * 
 * @param courseId
 * @param paperId
 * @param conn
 * @return
 * @throws SQLException 
 */
	public List<SsubAnswer> showSubAnswer(String account,String paperId,Connection conn) throws SQLException{
	String sql="select * from els_ks_sub_answer where paperId=? and account=?;";
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	SsubAnswer ssub =null;
	List<SsubAnswer> sublist=new ArrayList<SsubAnswer>();
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, paperId);
		pstmt.setString(2, account);
		rs=pstmt.executeQuery();
		while(rs.next()){
			ssub= new SsubAnswer();
			ssub.setSubDetail(rs.getString("subDetial"));
			ssub.setSubjectAnswer(rs.getString("subjectiveAnswer"));
			ssub.setBiaozhundaan(rs.getString("biaozhundaan"));
			ssub.setKeyWords(rs.getString("keyWords"));
			ssub.setScore(rs.getString("score"));
			ssub.setStartTime(rs.getTimestamp("startTime"));
			ssub.setEndTime(rs.getTimestamp("endTime"));
			ssub.setIp(rs.getString("ip"));
			ssub.setHostName(rs.getString("hostName"));
			ssub.setTime(rs.getString("time"));
			sublist.add(ssub);
		}
	}finally{
		DBUtil.close(pstmt, rs);
	}
	return sublist;
}

}
