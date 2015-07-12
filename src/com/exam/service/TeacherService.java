package com.exam.service;

import java.sql.Connection;
import java.util.List;

import com.exam.dao.PaperDao;
import com.exam.dao.TestDao;
import com.exam.domain.Objective;
import com.exam.domain.Paper;
import com.exam.domain.SobjAnswer;
import com.exam.domain.SsubAnswer;
import com.exam.domain.Student;
import com.exam.domain.Subjective;
import com.exam.util.DBUtil;
import com.exam.util.PageModel;

/**
 * 
 * @author 
 *
 */
public class TeacherService {

	private static TeacherService instance = new TeacherService();
	
	private PaperDao paperDao;
	
	private TestDao testDao;
	//private String[] selectFlag;
	
	private TeacherService() {
		 testDao= new TestDao();
		 paperDao=new PaperDao();
	}
	
	public static TeacherService getInstance() {
		return instance;
	}
	/**
	 * 根据试卷的id获得试卷的全部内容
	 * @param paperId
	 * @return
	 */
	/*public Paper getPaperById(int courseId) {
		Paper p = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			p = (Paper) paperDao.getPaperByCourse_id(courseId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return p;
	}*/
	/*
	 * 把式题添加到试卷
	 */
	public void addToPaper(Paper paper){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			paperDao.addToPaper(paper, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	/*
	 * 从试卷删除客观试题*/
	 
	public void deleteFromPaper(Paper paper){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			paperDao.deleteObFromPaper(paper, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	
	/*
	 * 从试卷删除主观试题
	 */
	public void deleteSubFromPaper(Paper paper){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			paperDao.deleteSubFromPaper(paper, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	/*
	 * 显示所有试卷
	 */
	public List<Paper> showAllPaper(String courseId){
		Connection conn = null;
		List<Paper> PaperList=null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			PaperList=paperDao.showAllPaper(courseId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return PaperList;
		
	}
	/*
	 * 查询每一套试卷的客观试题
	 */
	public List<Objective> findTestObjective(String paperId){
		Connection conn = null;
		List<Objective> TestObjectiveList=null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			TestObjectiveList=paperDao.findTestObjective(paperId, conn);
			//System.out.println(PaperList);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return TestObjectiveList;
		
	}
	/*
	 * 查询每一套试卷的主观试题
	 */
	public List<Subjective> findTestSubjective(String paperId){
		Connection conn = null;
		List<Subjective> TestSubjectiveList=null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			TestSubjectiveList=paperDao.findTestSubjective(paperId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return TestSubjectiveList;
		
	}
	
	/*
	 * 把式题添加到试卷
	 */
	public List<Student> showName(String courseId,String paperId){
		Connection conn = null;
		List<Student> list=null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			list=testDao.showName(courseId, paperId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return list;
	}
	/*
	 * 把式题添加到试卷
	 */
	public List<Student> showName2(String courseId,String paperId){
		Connection conn = null;
		List<Student> list=null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			list=testDao.showName2(courseId, paperId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return list;
	}
	/*
	 * 查标准分数
	 */
	public List<Paper> showScore(String courseId,String paperId){
		Connection conn = null;
		List<Paper> list=null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			list=testDao.showScore(courseId, paperId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return list;
	}
	
	/**
	 * 根据试卷的id获得试卷的全部内容
	 * @param paperId
	 * @return
	 */

	/**
	 * 添加选择题
	 * @param objective
	 */
	public void addTestChoice(Objective objective){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			testDao.addTestChoice(objective,conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 添加判断题
	 * @param objective
	 */
	public void addTestJudge(Objective objective){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//DBUtil.beginTransaction(conn);
			testDao.addTestJudge(objective, conn);
			//DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			//DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	/**
	 * 根据id删除客观试题
	 * @param id
	 */
	public void delTestObjective(String[] id){
		Connection conn = null;
		System.out.println(id);
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			testDao.delTestObjective(id, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}	
	}
	
	/**
	 * 根据id删除主观试题
	 * @param id
	 */
	public void delTestSubjective(String[] selectFlags){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			testDao.delTestSubjective(selectFlags, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}	
	}
	/**
	 * 修改选择题
	 * @param objective
	 */
	public void modifyTestChoice(Objective objective){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			testDao.modifyTestChoice(objective, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 修改判断题
	 * @param objective
	 */
	public void modifyTestJudge(Objective objective){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			testDao.modifyTestJudge(objective, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 添加主观题
	 * @param subjective
	 */
	public void addTestSub(Subjective subjective){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			testDao.addTestSub(subjective, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	/**
	 * 修改主观题
	 * @param subjective
	 */
	public void modifyTestSub(Subjective subjective){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			testDao.modifyTestSub(subjective, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
	}
	
	
	/**
	 * 采用分页显示客观试题
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel<Objective> findTestObjectiveList(int pageNo,int pageSize,String courseId){
		PageModel<Objective> p=null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			p=testDao.findTestObjectiveList(pageNo, pageSize,courseId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return p;
	}
	/**
	 * 分页显示主观 试题
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel<Subjective> findTestSubjectiveList(int pageNo,int pageSize,String courseId){
		PageModel<Subjective> p=null;
		Connection conn=null;
		try{
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			p=testDao.findTestSubjectiveList(pageNo, pageSize,courseId, conn);
			DBUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally{
			DBUtil.close(conn);
		}
		
		return p;
	}
	/*
	 * 根据id查找客观题
	 */
	public Objective findObjective(String id){
		Connection conn = null;
		Objective objective=null;
		System.out.println(id);
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			objective=testDao.findObjective(conn, id);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return objective;
	}
	/*
	 * 根据id查找主观题
	 */
	public Subjective findSubjective(String id){
		Connection conn = null;
		Subjective subjective=null;
		System.out.println(id);
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			subjective=testDao.findSubjective(conn, id);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return subjective;
	}
	/*
	 * 添加试卷
	 */
	public void addPaper(Paper paper){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			paperDao.addPaper(paper, conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
	/*
	 * 删除试卷
	 */
	public void deletePaper(String paperId){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			paperDao.deletePaper(paperId, conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
	
	public String differ(String paperId,String courseId){
		Connection conn = null;
		String floor=null;
		try {
			conn = DBUtil.getConnection();
			floor=paperDao.differ(paperId,courseId, conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return floor;
	}
	
	/*
	 * 根据id查找客观题 showSubAnswer
	 */
	public List<SobjAnswer> showObjAnswer(String account,String paperId){
		Connection conn = null;
		List<SobjAnswer> sobAlist=null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			sobAlist=testDao.showObjAnswer(account, paperId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return sobAlist;
	}
	
	/*
	 * 根据id查找客观题 showSubAnswer
	 */
	public List<SsubAnswer> showSubAnswer(String account,String paperId){
		Connection conn = null;
		List<SsubAnswer> subAlist=null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.beginTransaction(conn);
			subAlist=testDao.showSubAnswer(account, paperId, conn);
			DBUtil.commitTransaction(conn);
		}catch (Exception e) {
			e.printStackTrace();
			DBUtil.rollBackTransaction(conn);
		}finally {
			DBUtil.close(conn);
		}
		return subAlist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
