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
		
		//ģ�����ݿ��ѯ
		if(username==null||"".equals(username)){
			out.println("�������û�����");
		}else if(username.equals("sa")){
			out.println("�û����Ѵ���");
		}else{
			out.println("�û�������ʹ��");
		}
		
	}
}
