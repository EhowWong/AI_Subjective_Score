package com.exam.action.teacher;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.exam.domain.Teacher;
import com.opensymphony.xwork2.ActionSupport;
/*
public class LoginAction{
	private HttpSession session;
	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String execute() throws Exception {
		Teacher teacher = new Teacher();
		ServletContext Context = session.getServletContext();  
		ServletContext Context1= Context.getContext("/vs"); // 项目A的虚拟路径
		HttpSession session2 =(HttpSession)Context1.getAttribute("session");
		String name=(String) session2.getAttribute("name");
		String account=(String) session2.getAttribute("account");
		System.out.println("base传过来的user为:"+session2.getAttribute("name"));
		System.out.println("base传过来的user为:"+session2.getAttribute("account"));
		System.out.println("base传过来的user为:"+session2.getAttribute("user_type"));
		teacher.setAccount(account);
		teacher.setName(name);
		session.setAttribute("onlineTeacher", teacher);

		return "SUCCESS";
	}

}
*/


public class LoginAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	HttpServletRequest request = ServletActionContext.getRequest();
	String account=request.getParameter("account");
	String courseid=request.getParameter("courseid");
	String name=request.getParameter("name");
	@Override
	public String execute() throws Exception {
		Teacher teacher = new Teacher();
		teacher.setAccount(account);
		teacher.setCourseId(courseid);
		teacher.setName(name);
		this.session.put("onlineTeacher", teacher);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}


