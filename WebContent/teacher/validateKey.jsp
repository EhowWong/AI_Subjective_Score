<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.exam.Ik.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String words=request.getParameter("words");
	String keywords=keyword.getKeyWord().getKeyword(words,15);
	out.write(keywords);	
%>
