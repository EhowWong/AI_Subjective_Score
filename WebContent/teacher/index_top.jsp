<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/client_validate.js"></script>
<style>
*{ margin:0; padding:0;}
b{ color:#090;}
body{ font-size:14px; background:#FFF; font:微软雅黑;}
a{ text-decoration:none; color:#000; font-weight:bold;}
a:hover{ text-decoration:none; color:#090;}
.left{ float:left; padding-top:10px; padding-left:10px; color:#FFA500;}
.right{ float:right;}
</style>
</head>
<%--<body style="background:url('image/1.jpg') no-repeat;">--%>
<body>
	<div class="left" align="left">
    <h2>沈阳农业大学在线考试系统</h2>
    <h4>ShenyangAgricultureUniversityOnlineTestSystem</h4>
    </div>
	<div class="right" align="right">
	<strong>姓名：</strong><b><s:property value="#session.onlineTeacher.name"/></b>
	<strong>帐号：</strong><b><s:property value="#session.onlineTeacher.courseId"/></b>
	【<a href="t-login.jsp" target="_parent">安全退出</a>】<br>
	
	</div>
	 
</body>
</html>