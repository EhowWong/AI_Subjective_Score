<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<title>试卷列表</title>
    <style>
    *{ margin:0; padding:0;font-size: 12px;}
	.table{ margin:0 auto;}
	.table td,.table th{ border-bottom:1px solid #CCC; line-height:25px;}
	a{ color:#03F; text-decoration:none;}
	a:hover{ color:#F00; text-decoration:underline;}
	</style>
    <base href="<%=basePath%>">
  </head>
  <body class="bgImage" bgcolor="#ADD9E6">
  <form id="userform" name="userform">
  <h2><s:property value="#session.onlineTeacher.name"/>,学生答题名单：</h2>
  <table class="table" align="center"  border="0" cellpadding="0" cellspacing="0">
     <tr bgcolor="#0066FF"><th width="223" height="30">序号</th><th width="223">姓名</th><th width="223">账号</th><th width="223">操作</th></tr>
	<s:iterator value="stus" var="stu" status="sta">
		<tr bgcolor="#FFFFFF">
			<td align="center"><s:property value="#sta.index+1"/></td>
      		<td align="center"><s:property value="#stu.name"/></td>
			<td align="center"><s:property value="#stu.account"/></td>
			<td align="center"><a href="<%=basePath%>t/showAnswer?paperId=<s:property value='paperId'/>&courseId=<s:property value="#session.onlineTeacher.courseId"/>&account=<s:property value="#stu.account"/>"/>查看</a></td>
		</tr>
		</s:iterator>
	</table>
	</form>	
  </body>
</html>
