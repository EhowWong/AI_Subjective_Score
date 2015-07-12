package com.exam.action.teacher;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.exam.dao.PaperDao;
import com.exam.domain.Objective;
import com.exam.domain.Paper;
import com.exam.domain.Subjective;
import com.exam.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;

public class PaperAction extends ActionSupport implements SessionAware{

	private String id;
	private String objectIds;
	private String subjectIds;
	private int courseId;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getSubjectIds() {
		return subjectIds;
	}
	public void setSubjectIds(String subjectIds) {
		this.subjectIds = subjectIds;
	}

	private String ids;
	
	public String getObjectIds() {
		return objectIds;
	}
	public void setObjectIds(String objectIds) {
		this.objectIds = objectIds;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}

	private PaperDao paperDao= new PaperDao();
	
	private Paper paper;
	
	private String paperId;
	
	private String paperid;
	
	public String getPaperid() {
		return paperid;
	}
	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}
	public String getPaperId() {
		return paperId;
	}
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	
	private String[] selectFlags;
	private List<Paper> PaperList;
	
	private List<Objective> ObjectiveList;
	
	private List<Subjective> SubjectiveList;
	
	public List<Objective> getObjectiveList() {
		return ObjectiveList;
	}
	public void setObjectiveList(List<Objective> objectiveList) {
		ObjectiveList = objectiveList;
	}
	public List<Subjective> getSubjectiveList() {
		return SubjectiveList;
	}
	public void setSubjectiveList(List<Subjective> subjectiveList) {
		SubjectiveList = subjectiveList;
	}
	public List<Paper> getPaperList() {
		return PaperList;
	}
	public void setPaperList(List<Paper> paperList) {
		PaperList = paperList;
	}
	public String[] getSelectFlags() {
		return selectFlags;
	}
	public void setSelectFlags(String[] selectFlags) {
		this.selectFlags = selectFlags;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	/*
	 * ��ʽ����ӵ��Ծ�
	 */
	public String addToPaper(){
		paper.setPaperId(paperId);
		try{
			//�͹���
			if(!"".equals(objectIds) && objectIds!=null){
				String[] os = objectIds.split(",");
				for(String s : os)
				{
					paper.setObjectIds(s);
					TeacherService.getInstance().addToPaper(paper);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//������
		try{
			if(!"".equals(subjectIds) && subjectIds!=null){
				String[] os = subjectIds.split(",");
				for(String s : os)
				{
					paper.setSubjectIds(s);
					TeacherService.getInstance().addToPaper(paper);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
	/* �ѿ͹�������Ծ���ɾ��*/
	public String deleteObFromPaper(){
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String[] objIds=request.getParameterValues("selectFlag");
		//�͹���
		try{
		if(!"".equals(objectIds)){
			String[] os = objectIds.split(",");
			for(String s : os)
			{
				paper.setObjectIds(s);
				TeacherService.getInstance().deleteFromPaper(paper);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
	/*
	 * ������������Ծ���ɾ��*/
	
	public String deleteSubFromPaper(){
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String[] subIds=request.getParameterValues("selectFlag");
		//������
		try{
		if(!"".equals(subjectIds)){
			String[] os = subjectIds.split(",");
			for(String s : os)
			{
				paper.setSubjectIds(s);
				TeacherService.getInstance().deleteSubFromPaper(paper);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
	/*
	 * ��ʾ�����Ծ�
	 */
	public String showAllPaper(){
		String courseId=this.courseId+"";
		PaperList=TeacherService.getInstance().showAllPaper(courseId);
		return "success";
	}
	/*
	 * ��ʾ�����Ծ�
	 */
	public String showAllPaper2(){
		String courseId=this.courseId+"";
		PaperList=TeacherService.getInstance().showAllPaper(courseId);
		return "success";
	}
	/*
	 * �����Ծ�Ų�ѯ����
	 */
	public String FindTest() throws UnsupportedEncodingException{
		ObjectiveList=TeacherService.getInstance().findTestObjective(paperId);
		SubjectiveList=TeacherService.getInstance().findTestSubjective(paperId);
		return "success";
	}
	/*
	 * ����Ծ��б�
	 */
	/*public String getPaperByCourse_id(){
		TeacherService.getInstance().getPaperById(courseId);
		return "success";
	}*/
	
	public String addPaper(){
		TeacherService.getInstance().addPaper(paper);
		return "success";
	}
	
	public String success(){
		return "success";
	}
	public String deletePaper(){
		TeacherService.getInstance().deletePaper(paperId);
		return "success";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PaperDao getPaperDao() {
		return paperDao;
	}
	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = session;		
	}

}
