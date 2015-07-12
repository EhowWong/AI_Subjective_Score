package com.exam.action.student;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.exam.domain.ObjAnswer;
import com.exam.domain.Objective;
import com.exam.domain.Paper;
import com.exam.domain.SobjAnswer;
import com.exam.domain.SsubAnswer;
import com.exam.domain.Student;
import com.exam.domain.SubAnswer;
import com.exam.domain.Subjective;
import com.exam.domain.subScore;
import com.exam.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport implements SessionAware {

	private Student student;
	private List<Paper> papers;
	private List<Objective> Objectives;
	private List<Subjective> Subjectives;
	private Map<String, Object> session;
	private String paperId;
	private String[] objId;
	private String[] subId;
	private SubAnswer subAnswer;
	private ObjAnswer objAnswer;
	private List<ObjAnswer> objKey;
	private List<Subjective> subC;
	private int rightNumber;
	private SobjAnswer sobjAnswer;
	private SsubAnswer ssubAnswer;
	private Timestamp startTime;
	private Timestamp endTime=null;
	private int time_s;
	private int time_f;
	private List<subScore> sub_Score;
	private ArrayList<subScore> sc=new ArrayList<subScore>();
	HttpServletRequest request = ServletActionContext.getRequest();

	public ArrayList<subScore> getSc() {
		return sc;
	}

	public void setSc(ArrayList<subScore> sc) {
		this.sc = sc;
	}

	public List<subScore> getSub_Score() {
		return sub_Score;
	}

	public void setSub_Score(List<subScore> sub_Score) {
		this.sub_Score = sub_Score;
	}

	public long getTime_s() {
		return time_s;
	}

	public void setTime_s(int time_s) {
		this.time_s = time_s;
	}

	public long getTime_f() {
		return time_f;
	}

	public void setTime_f(int time_f) {
		this.time_f = time_f;
	}

	public List<Subjective> getSubC() {
		return subC;
	}

	public void setSubC(List<Subjective> subC) {
		this.subC = subC;
	}

	public int getRightNumber() {
		return rightNumber;
	}

	public void setRightNumber(int rightNumber) {
		this.rightNumber = rightNumber;
	}

	public List<ObjAnswer> getObjKey() {
		return objKey;
	}

	public void setObjKey(List<ObjAnswer> objKey) {
		this.objKey = objKey;
	}

	public String[] getSubId() {
		return subId;
	}

	public void setSubId(String[] subId) {
		this.subId = subId;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}

	public List<Objective> getObjectives() {
		return Objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		Objectives = objectives;
	}

	public List<Subjective> getSubjectives() {
		return Subjectives;
	}

	public void setSubjectives(List<Subjective> subjectives) {
		Subjectives = subjectives;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String[] getObjId() {
		return objId;
	}

	public void setObjId(String[] objId) {
		this.objId = objId;
	}

	public SubAnswer getSubAnswer() {
		return subAnswer;
	}

	public void setSubAnswer(SubAnswer subAnswer) {
		this.subAnswer = subAnswer;
	}

	public ObjAnswer getObjAnswer() {
		return objAnswer;
	}

	public void setObjAnswer(ObjAnswer objAnswer) {
		this.objAnswer = objAnswer;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

/*
	public String showCourse() {
		Student student = (Student) session.get("onlineStudent");
		String account = student.getAccount();
		courses = StudentService.getInstance().showCourse(account);
		return SUCCESS;
	}
*/
	public String showPaper() {
		Student s=(Student) session.get("onlineStudent");
		int courseId=Integer.parseInt(s.getCourseId());
		papers=StudentService.getInstance().showPaper(courseId);
		
		/*
		Iterator<Paper> ps=papers.iterator();
		while(ps.hasNext()){
			Paper pa=ps.next();
			String paperid=pa.getPaperId();
			InvPaper invp=(InvPaper) StudentService.getInstance().loadAnswer(paperid, courseid, account);
			answersL.add(invp);
		}
	
		List<SobjAnswer> ls=StudentService.getInstance().loadAnswer(paperId, courseid);
		Iterator<SobjAnswer> it=ls.iterator();
		while(it.hasNext()){
			SobjAnswer sj= it.next();
			if(paperId.equals(sj.getPaperId()) && courseid.equals(sj.getCourseId())){
				b=false;
				break;
			}
		}*/
		
		return SUCCESS;
	}

	public String showQuestions() throws UnsupportedEncodingException {
		Student s=(Student) session.get("onlineStudent");
		int courseId=Integer.parseInt(s.getCourseId());
		Objectives=StudentService.getInstance().showQuestion(paperId);
		Subjectives=StudentService.getInstance().showSubQuestion(paperId,courseId);
		startTime = new Timestamp(new Date().getTime());
		session.put("sTime", startTime);
		return SUCCESS;
	}
	
	public String showResults() throws Exception {
		
		Student student=(Student) session.get("onlineStudent");
		String account=student.getAccount();
		String name=student.getName();
//		String courseId=student.getCourseId();
		int courseId=Integer.parseInt(student.getCourseId());
		
		Timestamp sTime=(Timestamp) session.get("sTime");
		//Timestamp st=startTime;
		endTime = new Timestamp(new Date().getTime());
		long time=(endTime.getTime()-sTime.getTime())/1000;
		time_f=(int) (time/60);
		time_s=(int) (time-time_f*60);
		String ys=time_f+"分"+time_s+"秒";
		//InetAddress addr;
		//addr = InetAddress.getLocalHost();
		String ip = request.getHeader("x-forwarded-for"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getRemoteAddr(); 
	    }  
	    //String ip=addr.getHostAddress().toString();//��ñ���IP
		//String hostName=addr.getHostName().toString();//��ñ������
		String hostName="未知"; 
		
		if(objId!=null){
			List list=new ArrayList();
			for(int i=0;i<objId.length;i++){
				int j=i+1;
				String objAnswerCon = request.getParameter("rObjId_"+j);
				list.add(objAnswerCon);
			}
			objAnswer.setContent(list);
		}
	if(objId!=null){
		objKey=StudentService.getInstance().showObjKey(paperId);
		String[] objKeyId=objAnswer.getId().split(",");
		String[] objKeyCon=objAnswer.getContent().toString().substring(1,objAnswer.getContent().toString().length()-1).split(",");
		String flag="";
		for(int k=0;k<objId.length;k++){
			if(objKeyId[k].trim().equals(objKey.get(k).getId().toString()) && objKeyCon[k].trim().equalsIgnoreCase(objKey.get(k).getKey())){
				rightNumber++;flag="t";
			}else{flag="f";}
			sobjAnswer=new SobjAnswer();
			sobjAnswer.setObjectId(objKeyId[k].trim());
			sobjAnswer.setDetail(objKey.get(k).getDetail().trim());
			sobjAnswer.setOptionA(objKey.get(k).getOptionA().trim());
			sobjAnswer.setOptionB(objKey.get(k).getOptionB().trim());
			sobjAnswer.setOptionC(objKey.get(k).getOptionC().trim());
			sobjAnswer.setOptionD(objKey.get(k).getOptionD().trim());
			sobjAnswer.setObjectAnswer(objKeyCon[k].trim());
			sobjAnswer.setRightAnswer(objKey.get(k).getKey().trim());
			sobjAnswer.setAccount(account);
			sobjAnswer.setCourseId(courseId);
			sobjAnswer.setName(name);
			sobjAnswer.setPaperId(paperId);
			sobjAnswer.setScore(rightNumber);
			sobjAnswer.setStartTime(sTime);
			sobjAnswer.setEndTime(endTime);
			sobjAnswer.setIp(ip);
			sobjAnswer.setHostName(hostName);
			sobjAnswer.setTime(ys);
			sobjAnswer.setType(flag);
			StudentService.getInstance().addSobjAnswer(sobjAnswer);
		}
	}
	
	Subjectives=StudentService.getInstance().showSubQuestion(paperId,courseId);
	if(subId!=null){
		double sum=0,p=0.7;
		subC=StudentService.getInstance().showSubQuestion(paperId,courseId);
		String[] subKeyId=subAnswer.getId().split(",");
		String[] subKeyCon=subAnswer.getContent().toString().split(",");
		String subScor = null;
		for(int k=0;k<subId.length;k++){
			/*
			 * �������������
			 * int n �ؼ�ʵĸ���
			 * double P �ؼ������Ŀ����ռ�ı���
			 * s0 ����ķ�ֵ
			 * subScore ѧ���ʵ�ʵ÷�
			 * sum �������ȵĺ�
			 * double resu ���ε�������
			 * ÿ����Ŀ���ѧ��һ���ֲ�д��Ϊ0�֣�ֻҪ��д����(1-p)*0.6��
			 */
			String[] z=subC.get(k).getKeyWords().split(",");
			if(!"".equals(subKeyCon[k].trim())){
				for(int v=0;v<z.length;v++){
					double resu = Near.getInstance().near_t(z[v],subKeyCon[k].trim());
					if(resu<0.1){resu=0;}else{sum=sum+resu;}
				}
				double subS=((sum/subC.get(k).getKeyWords().split(",").length)*p+(1-p)*0.5)*10;
				subScor =String.format("%.2f", subS);
			}else{
				subScor="0.00";
			}
			subScore suc=new subScore();
			suc.setId(subKeyId[k].trim());suc.setScore(subScor);
			sc.add(suc);
			/*
			 * ����Ŀ��ѧ��𰸴��
			 */
			ssubAnswer = new SsubAnswer();
			ssubAnswer.setAccount(account);
			ssubAnswer.setCourseId(courseId);
			ssubAnswer.setName(name);
			ssubAnswer.setPaperId(paperId);
			ssubAnswer.setSubjectAnswer(subKeyCon[k].trim());
			ssubAnswer.setSubjectId(subKeyId[k].trim());
			ssubAnswer.setSubDetail(subC.get(k).getDetail().trim());
			ssubAnswer.setBiaozhundaan(subC.get(k).getBiaozhundaan().trim());
			ssubAnswer.setKeyWords(subC.get(k).getKeyWords().trim());
			ssubAnswer.setScore(subScor);
			ssubAnswer.setStartTime(sTime);
			ssubAnswer.setEndTime(endTime);
			ssubAnswer.setIp(ip);
			ssubAnswer.setHostName(hostName);
			ssubAnswer.setTime(ys);
			StudentService.getInstance().addSsubAnswer(ssubAnswer);
		}
	}
		return SUCCESS;
	}


}
