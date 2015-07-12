package com.exam.action.student;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.SystemUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.exam.domain.Student;
import com.exam.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 负责处理学生登录
 * @author Qingsong
 *
 */
public class LoginAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	HttpServletRequest request=ServletActionContext.getRequest();
	String account=request.getParameter("account");
	String courseid=request.getParameter("courseid");
	String name=request.getParameter("name");
	@Override
	public String execute() throws Exception {
		Student student = new Student();
		student.setAccount(account);
		student.setCourseId(courseid);
		student.setName(name);
		this.session.put("onlineStudent", student);
		return SUCCESS;
	}
/*		student.setId(101);
		student.setAccount("13104008");
		student.setName("好人");
		student.setCourseId("2002500009");
		student.setPasswd("e10adc3949ba59abbe56e057f20f883e");*/

		/*
		student=StudentService.getInstance().Slogin(account, password);
		if(student!=null && password.equals(student.getPasswd()) && account.equals(student.getAccount())){
			this.session.put("onlineStudent", student);
			return SUCCESS;
		}else if(!account.equals(student.getAccount())){
			message="用户不存在，请重新登录！";
			return ERROR;
		}else{
			message="密码错误，请重新登录！";
			return ERROR;
		}
	}
*/
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
