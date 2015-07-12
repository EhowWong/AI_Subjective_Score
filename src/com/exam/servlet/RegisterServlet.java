package com.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username").trim();
		
		//模拟数据库查询
		if(username==null||"".equals(username)){
			out.println("请输入用户名！");
		}else if(username.equals("sa")){
			out.println("用户名已存在");
		}else{
			out.println("用户名可以使用");
		}
		
	}
}
