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
    <base href="<%=basePath%>">
    <style>
    *{ margin:0; padding:0;font-size: 12px;}
	table td{ border-bottom:1px solid #CCC; background:#FFF;}
	</style>
  </head>
  <body class="bgImage" bgcolor="#ADD9E6">
  <form id="userform" name="userform">
  <h2>学生答题详单：</h2>
<b>答题信息：</b>
	<b>本试卷的总分为：</b><FONT color="red"><B><s:property value="totalScore"/></B></FONT>&nbsp;&nbsp;&nbsp;
	<b>该学生的总分为：</b><FONT color="red"><B><s:property value="stotalScore"/></B></FONT>
	<p>
	  </p>
	<table  border="0" cellpadding="0" cellspacing="0">	
	<s:if test="null!=ssubA[0]">
  		<s:iterator value="ssubA[0]" var="so">
				<tr>
				  <td width="300" align="left">开始答题时间:<font color="green"><s:date name="#so.startTime" format="yyyy-MM-dd HH:mm:ss"/></font></td>
				  <td width="300" align="left">结束答题时间:<font color="green"><s:date name="#so.endTime" format="yyyy-MM-dd HH:mm:ss"/></font></td>
				  <td width="250" align="center">用时:<font color="green"><s:property value="#so.time"/></font></td>
				  <td width="250" align="left">IP地址:<font color="green"><s:property value="#so.ip"/></font></td>
				  <td width="200" align="left">主机名称:<font color="green"><s:property value="#so.hostName"/></font></td>
				</tr>
				</s:iterator>
	</s:if><s:else>
		<s:iterator value="sobjA[0]" var="so">
				<tr>
				  <td width="300" align="left">开始答题时间:<font color="green"><s:date name="#so.startTime" format="yyyy-MM-dd HH:mm:ss"/></font></td>
				  <td width="300" align="left">结束答题时间:<font color="green"><s:date name="#so.endTime" format="yyyy-MM-dd HH:mm:ss"/></font></td>
				  <td width="250" align="center">用时:<font color="green"><s:property value="#so.time"/></font></td>
				  <td width="250" align="left">IP地址:<font color="green"><s:property value="#so.ip"/></font></td>
				  <td width="200" align="left">主机名称:<font color="green"><s:property value="#so.hostName"/></font></td>
				</tr>
				</s:iterator>
	</s:else>
	</table><br/>
<b>选择题部分：</b><p>
  <table  border="0" cellpadding="0" cellspacing="0">
     <tr bgcolor="#0066FF">
     	<td width="10">序号</td><td width="60">题目</td><td width="15">学生答案</td><td width="15">老师答案</td>
     </tr>
			<s:iterator value="sobjA" var="so" status="sta">
				<tr>
					<td align="center"><s:property value="#sta.index+1"/></td>
					<td align="left" style="background:#FCF;">
						<s:property value="#so.detail"/><br/>
						A.<s:property value="#so.optionA"/><br/>
						B.<s:property value="#so.optionB"/><br/>
						C.<s:property value="#so.optionC"/><br/>
						D.<s:property value="#so.optionD"/><br/>
					</td>
				  <td align="center"><s:property value="#so.objectAnswer"/></td>
					<td style="background:#FCF;" align="center"><s:property value="#so.rightAnswer"/></td>
				</tr>
				</s:iterator>
	</table><br/>
	<br/>
<b>简答题部分：</b><p>
	 <table  border="0" cellpadding="0" cellspacing="0">
     <tr bgcolor="#0066FF">
     	<td width="10">序号</td><td width="60">题目</td><td width="60">学生答案</td><td width="60">老师答案</td><td width="50">关键词</td><td width="20">得分</td>
     </tr>
			<s:iterator value="ssubA" var="ss" status="sta">
				<tr>
					<td align="center"><s:property value="#sta.index+1"/></td>
					<td style="background:#FF9;" align="center"><s:property value="#ss.subDetail"/></td>
					<td align="center"><s:property value="#ss.subjectAnswer"/></td>
					<td style="background:#FF9;" align="center"><s:property value="#ss.biaozhundaan"/></td>
					<td align="center"><s:property value="#ss.keyWords"/></td>
					<td style="background:#FF9;" align="center"><s:property value="#ss.score"/></td>
				</tr>
			</s:iterator>
	</table>
	</form>	
  </body>
</html>
