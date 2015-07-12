package com.exam.domain;
/**
 * 课程和老师的对应关系
 * @author Qingsong
 *
 */
public class CourseTeacher {

	private int id;
	private int courseId;
	private String teacherAccount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTeacherAccount() {
		return teacherAccount;
	}

	public void setTeacherAccount(String teacherAccount) {
		this.teacherAccount = teacherAccount;
	}

}
