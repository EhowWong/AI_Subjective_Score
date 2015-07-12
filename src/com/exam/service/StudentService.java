package com.exam.service;

import java.sql.Connection;
import java.util.List;

import com.exam.dao.AnswerDao;
import com.exam.dao.CourseDao;
import com.exam.dao.LoginDao;
import com.exam.dao.PaperDao;
import com.exam.domain.CourseStudent;
import com.exam.domain.InvPaper;
import com.exam.domain.InvPaperT;
import com.exam.domain.ObjAnswer;
import com.exam.domain.Objective;
import com.exam.domain.Paper;
import com.exam.domain.SobjAnswer;
import com.exam.domain.SsubAnswer;
import com.exam.domain.Student;
import com.exam.domain.Subjective;
import com.exam.util.DBUtil;

/**
 * 
 * @author
 *
 */
public class StudentService {

	private static StudentService instance = new StudentService();
	
	private CourseDao courseDao;
	private PaperDao paperDao;
	private AnswerDao answerDao;
	private LoginDao loginDao;
	
	private StudentService() {
		courseDao = new CourseDao();
		paperDao =new PaperDao();
		answerDao=new AnswerDao();
		loginDao=new LoginDao();
	}
	
	public static StudentService getInstance() {
		return instance;
	}

	
	public List<CourseStudent> showCourse(String account) {
		Connection conn = null;
		List<CourseStudent> list = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			list = courseDao.showCourse(account, conn);
			DBUtil.commitTransaction(conn);
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}

	public List<Paper> showPaper(int courseId) {
		Connection conn = null;
		List<Paper> list = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			list = paperDao.getPaperByCourse_id(courseId, conn);
			DBUtil.commitTransaction(conn);
		} catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}
	
	public List<Objective> showQuestion(String paperId){
		Connection conn=null;
		List<Objective> questionsList=null;
		try{
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			questionsList=paperDao.getQuestionsBypaperId(paperId, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally{
			DBUtil.close(conn);
		}
		return questionsList;
	}
	
	public List<Subjective> showSubQuestion(String paperId,int courseId){
		Connection conn=null;
		List<Subjective> subquestionsList=null;
		try{
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			subquestionsList=paperDao.getSubjectiveBypaperId(paperId,courseId, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally{
			DBUtil.close(conn);
		}
		return subquestionsList;
	}
	
	public List<ObjAnswer> showObjKey(String paperId){
		Connection conn=null;
		List<ObjAnswer> objKeyList=null;
		try{
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			objKeyList=paperDao.getObjectiveKeyBypaperId(paperId, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally{
			DBUtil.close(conn);
		}
		return objKeyList;
	}
	
	public void addSobjAnswer(SobjAnswer sobjAnswer){
		Connection conn=null;
		try{
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			answerDao.addObjAnswer(sobjAnswer, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void addSsubAnswer(SsubAnswer ssubAnswer){
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			answerDao.addSubAnswer(ssubAnswer, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			DBUtil.rollBackTransaction(conn);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public List<InvPaper> loadAnswer(String paperId,String account){
		Connection conn=null;
		List<InvPaper> ans=null;
		try{
			conn=DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			ans=(List<InvPaper>) answerDao.loadAnswer(paperId, account, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally{
			DBUtil.close(conn);
		}
		return ans;
	}
	
	
	public List<InvPaperT> loadSubA(String paperId,String account){
		Connection conn=null;
		List<InvPaperT> it=null;
		try{
			conn=DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			it=answerDao.loadSubAnswer(paperId, account, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return it;
	}
	
	public Student Slogin(String account,String password){
		Connection conn=null;
		Student student=new Student();
		try{
			conn=DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			student=loginDao.sLogin(account, password, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return student;
	}
}
