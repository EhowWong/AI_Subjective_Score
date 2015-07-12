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
	table{ margin:0 auto;}
	td,th{ border-bottom:1px solid #CCC;}
	a{ color:#03F; text-decoration:none;}
	a:hover{ color:#F00; text-decoration:underline;}
	</style>
    <base href="<%=basePath%>">
  </head>
  <body class="bgImage" bgcolor="#ADD9E6">
  <form id="userform" name="userform">
  <h2 align="center"><font color="#009900"><s:property value="#session.onlineTeacher.name"/></font>,以下是学生答题试卷列表</h2>
  <table align="center" border="0" cellpadding="0" cellspacing="0">
     <tr  height="30" bgcolor="#0066FF"><th width="223">序号</th><th width="223">试卷名称</th><th width="223">创建时间</th><th width="223">操作</th></tr>
	<s:iterator value="PaperList" var="s" status="sta">
		<tr height="25" bgcolor="#FFFFFF">
			<td align="center"><s:property value="#sta.index+1"/></td>
      		<td align="center" bgcolor="#FFCCCC"><s:property value="#s.paperId"/></td>
		  <td align="center"><s:date name="#s.generateTime" format="yyyy-MM-dd HH:mm:ss"/></td>
			<td align="center" bgcolor="#FFFFFF"><a href="<%=basePath%>t/showName?paperId=<s:property value='#s.paperId'/>&courseId=<s:property value='#session.onlineTeacher.courseId'/>"/>查看</a></td>
		</tr>
		</s:iterator>
	</table>
	</form>	
  </body>
</html>
