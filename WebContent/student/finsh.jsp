<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    <title>交卷页面</title>
  </head>
  
  <body>
    <h2>你已经提交了试卷，现在你可以查看答题情况：<a href="<%=basePath%>s/showResult">点击我</a><br/></h2>
    <!-- <h2>你也可以继续回答其他题目：<a href="<%=basePath%>s/showCourse">点击我</a><br/></h2> -->
  </body>
</html>
