package com.exam.domain;

import java.util.Date;

public class Paper {

	private int id;
	//主观题id
	private String objectIds;
	//客观题id
	private String subjectIds;
	private int courseId;
	private Date generateTime;
	private String paperId;
	private String examTime;
	private String objScore;
	private String subScore;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObjectIds() {
		return objectIds;
	}
	public void setObjectIds(String objectIds) {
		this.objectIds = objectIds;
	}
	public String getSubjectIds() {
		return subjectIds;
	}
	public void setSubjectIds(String subjectIds) {
		this.subjectIds = subjectIds;
	}
	public Date getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getPaperId() {
		return paperId;
	}
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public String getObjScore() {
		return objScore;
	}
	public void setObjScore(String objScore) {
		this.objScore = objScore;
	}
	public String getSubScore() {
		return subScore;
	}
	public void setSubScore(String subScore) {
		this.subScore = subScore;
	}

}
