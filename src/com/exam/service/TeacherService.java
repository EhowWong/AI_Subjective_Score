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
	 * �����Ծ��id����Ծ��ȫ������
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
	 * ��ʽ����ӵ��Ծ�
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
	 * ���Ծ�ɾ���͹�����*/
	 
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
	 * ���Ծ�ɾ����������
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
	 * ��ʾ�����Ծ�
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
	 * ��ѯÿһ���Ծ�Ŀ͹�����
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
	 * ��ѯÿһ���Ծ����������
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
	 * ��ʽ����ӵ��Ծ�
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
	 * ��ʽ����ӵ��Ծ�
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
	 * ���׼����
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
	 * �����Ծ��id����Ծ��ȫ������
	 * @param paperId
	 * @return
	 */

	/**
	 * ���ѡ����
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
	 * ����ж���
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
	 * ����idɾ���͹�����
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
	 * ����idɾ����������
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
	 * �޸�ѡ����
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
	 * �޸��ж���
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
	 * ���������
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
	 * �޸�������
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
	 * ���÷�ҳ��ʾ�͹�����
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
	 * ��ҳ��ʾ���� ����
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
	 * ����id���ҿ͹���
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
	 * ����id����������
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
	 * ����Ծ�
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
	 * ɾ���Ծ�
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
	 * ����id���ҿ͹��� showSubAnswer
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
	 * ����id���ҿ͹��� showSubAnswer
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
