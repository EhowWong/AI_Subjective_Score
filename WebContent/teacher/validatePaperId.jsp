<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.exam.domain.*" %>
<%@ page import="com.exam.service.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    Teacher t=(Teacher) session.getAttribute("onlineTeacher");
    String courseId=t.getCourseId();
	String words=request.getParameter("paperId");
	String bool=TeacherService.getInstance().differ(words, courseId);
 	String msg="试卷名称重复了，无法提交！";
 	if(bool.equalsIgnoreCase("yes")){
 		out.write(msg);	}
%>
