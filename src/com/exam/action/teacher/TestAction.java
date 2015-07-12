package com.exam.action.teacher;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.exam.domain.Objective;
import com.exam.domain.Paper;
import com.exam.domain.SobjAnswer;
import com.exam.domain.SsubAnswer;
import com.exam.domain.Student;
import com.exam.domain.Subjective;
import com.exam.service.TeacherService;
import com.exam.util.PageModel;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements SessionAware {

	private Subjective subjective;
	private Objective objective;
	private List<String> testSubList;
	private List<String> testObList;
	private String courseId;
	private int pageNo=1;
	private int pageSize=15;
	private String id;
	private String ids;
	private Paper paper;
	private String paperId;
	private String biaozhundaan;
	private List<Student> stus;
	private List<Paper> score;
	private List<SobjAnswer> sobjA;
	private List<SsubAnswer> ssubA;
	private String account;
	private double totalScore;
	private double stotalScore;
	
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public List<Paper> getScore() {
		return score;
	}

	public void setScore(List<Paper> score) {
		this.score = score;
	}

	public double getStotalScore() {
		return stotalScore;
	}

	public void setStotalScore(double stotalScore) {
		this.stotalScore = stotalScore;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public List<SsubAnswer> getSsubA() {
		return ssubA;
	}

	public void setSsubA(List<SsubAnswer> ssubA) {
		this.ssubA = ssubA;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<SobjAnswer> getSobjA() {
		return sobjA;
	}

	public void setSobjA(List<SobjAnswer> sobjA) {
		this.sobjA = sobjA;
	}

	public List<Student> getStus() {
		return stus;
	}

	public void setStus(List<Student> stus) {
		this.stus = stus;
	}

	public String getBiaozhundaan() {
		return biaozhundaan;
	}

	public void setBiaozhundaan(String biaozhundaan) {
		this.biaozhundaan = biaozhundaan;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private PageModel pm = new PageModel(); 
	
	/*
	 * 添加主管题
	 */
	public String addTestSub(){
		TeacherService.getInstance().addTestSub(subjective);
		return "success";
	}
	/*
	 * 添加选择题
	 */
	public String addTestChoice(){
		TeacherService.getInstance().addTestChoice(objective);
		return "success";
	}
	/*
	 * 添加判断题
	 */
	public String addTestJudge(){
		TeacherService.getInstance().addTestJudge(objective);
		return "success";
	}
	/*
	 * 根据id删客观除题
	 */
	public String delTestObjective(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] objIds=request.getParameterValues("selectFlag");
		TeacherService.getInstance().delTestObjective(objIds);
		return SUCCESS;
	}
	public String delTestSubjective(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] subIds=request.getParameterValues("selectFlag");
		TeacherService.getInstance().delTestSubjective(subIds);
		return SUCCESS;
	}
	
	/*
	 * 修改主观题
	 */
	public String modifyTestSub(){
		TeacherService.getInstance().modifyTestSub(subjective);
		//System.out.println(subjective.getId());
		return SUCCESS;
	}
	/*
	 * 修改选择题
	 */
	public String modifyTestChoice(){
		TeacherService.getInstance().modifyTestChoice(objective);
		return "success";
	}
	/*
	 * 修改判断题
	 */
	public String modifyTestJudge(){
		TeacherService.getInstance().modifyTestJudge(objective);
		return "success";
	}
	/*
	 * 查询并显示所有的客观题
	 */
	public String findTestObjectiveList(){
		String courseId=this.courseId+"";
		pm=TeacherService.getInstance().findTestObjectiveList(pageNo, pageSize, courseId);
		//testSubList=pm.getList();
		return "success";
	}
	/*
	 * 查询并显示所有的主观题
	 */
	public String findTestSubjectiveList(){
		String courseId=this.courseId+"";
		pm=TeacherService.getInstance().findTestSubjectiveList(pageNo, pageSize, courseId);
		return "success";
	}
	/*
	 * 根据id查询客观题
	 */
	public String  findObjective(){
		//System.out.println(id);
		objective =TeacherService.getInstance().findObjective(id);
		return "success";
	}
	/*
	 * 根据id查询客观题
	 */
	public String  showObjective(){
		//System.out.println(id);
		objective =TeacherService.getInstance().findObjective(id);
		return "success";
	}
	
	/*
	 * 根据id查询客观题
	 */
	public String  findObjectiveJudge(){
		//System.out.println(id);
		objective =TeacherService.getInstance().findObjective(id);
		return "success";
	}
	
	/*
	 * 根据id查询客观题
	 */
	public String  showObjectiveJudge(){
		//System.out.println(id);
		objective =TeacherService.getInstance().findObjective(id);
		return "success";
	}
	/*
	 * 根据Id查询主观题
	 */
	public String findSubjective(){
		subjective=TeacherService.getInstance().findSubjective(id);
		return "success";
	}
	
	/*
	 * 根据Id查询主观题
	 */
	public String showSubjective(){
		subjective=TeacherService.getInstance().findSubjective(id);
		return "success";
	}
	
	/*
	 * 根据Id查询主观题
	 */
	public String showName(){
		String courseId=this.courseId+"";
		stus=TeacherService.getInstance().showName(courseId, paperId);
		if(null==stus||stus.size()==0){
			stus=TeacherService.getInstance().showName2(courseId, paperId);
		}
		return "success";
	}
	
	/*
	 * 根据Id查询主观题
	 */
	public String showObjAnswer(){
		int sobjScore=0;
		double ssubScore=0.00;
		int rN=0;
		int obj=0;
		int sub=0;
		String courseId=this.courseId+"";
		sobjA=TeacherService.getInstance().showObjAnswer(account, paperId);
		ssubA=TeacherService.getInstance().showSubAnswer(account, paperId);
		score=TeacherService.getInstance().showScore(courseId, paperId);
		for(int k=0;k<score.size();k++){
			obj=Integer.parseInt(score.get(0).getObjScore());
			sub=Integer.parseInt(score.get(0).getSubScore());
		}
		for(int i=0;i<sobjA.size();i++){
			if("t".equalsIgnoreCase(sobjA.get(i).getType())){
				rN++;
			}
		}
		sobjScore=rN*obj;
		
		for(int j=0;j<ssubA.size();j++){
			ssubScore+=Double.parseDouble(ssubA.get(j).getScore());
		}
		stotalScore=sobjScore+ssubScore;
		
		totalScore=sobjA.size()*obj+ssubA.size()*sub;
		return "success";
	}
	
	public PageModel getPm() {
		return pm;
	}

	public void setPm(PageModel pm) {
		this.pm = pm;
	}

	public int getPageNo() {
		
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Subjective getSubjective() {
		return subjective;
	}

	public void setSubjective(Subjective subjective) {
		this.subjective = subjective;
	}

	public Objective getObjective() {
		return objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}



	public List<String> getTestSubList() {
		return testSubList;
	}

	public void setTestSubList(List<String> testSubList) {
		this.testSubList = testSubList;
	}

	public List<String> getTestObList() {
		return testObList;
	}

	public void setTestObList(List<String> testObList) {
		this.testObList = testObList;
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
