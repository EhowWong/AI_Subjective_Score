package com.exam.domain;
/**
 * �γ̺�ѧ���Ķ�Ӧ��ϵ
 * @author Qingsong
 *
 */
public class CourseStudent {    

	private int id;
	private int courseId;
	private String studentAccount;
	private String courseName;


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

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

	public String getStudentAccount() {
		return studentAccount;
	}

	public void setStudentAccount(String studentAccount) {
		this.studentAccount = studentAccount;
	}
}
