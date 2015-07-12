<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
int pageSize=20;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
*{ margin:0; padding:0;font-size: 12px;}
a{ display:block; width:100%; height:30px; line-height:30px; text-align:center; color:#000; border-radius:5px;}
a:hover{ background:#FFF; color:#00F;}
a:active{ background:#FFF;}
</style>
<body bgcolor="#808080"><%--

	帐号：<s:property value="#session.onlineTeacher.courseId"/>
	--%><br>
	<br>
	<h4>
	<a href="t/findTestSubjectiveList?pageNo=1&courseId=<s:property value="#session.onlineTeacher.courseId"/>" target="right"  style="text-decoration:none">简 答 题</a><p/>
	<a href="t/findTestObjectiveList?pageNo=1&courseId=<s:property value="#session.onlineTeacher.courseId"/>" target="right"  style="text-decoration:none">选 择 题</a><p/>
	<a href="t/showAllPaper?courseId=<s:property value="#session.onlineTeacher.courseId"/>"" target="right"  style="text-decoration:none">试卷管理</a><p/>
	<a href="t/showAllPaper2?courseId=<s:property value="#session.onlineTeacher.courseId"/>"" target="right"  style="text-decoration:none">答题详情</a><p/>
	</h4>
</body>
</html>