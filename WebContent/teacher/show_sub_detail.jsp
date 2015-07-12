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
<title>显示选择题</title>
<script src="js/client_validate.js"></script>
<script type="text/javascript">
	function goBack() {
		window.self.location="t/findTestSubjectiveList?pageSize=20&pageNo=1&courseId=<s:property value="#session.onlineTeacher.courseId"/>"
	}
	
	function init() {
		document.getElementById("detail").focus();
	}	
</script>
<style>
input{ background:#FFF;}
</style>
</head>
<body onload="init()" bgcolor="#ADD9E6">
<form name="userform" id="userform">
<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="25">
					<tr>
						<td bgcolor="#0066FF" width="522" class="p1" height="25" nowrap>
							
							<font color="#FFFFFF">系统管理&gt;&gt;查看简答题</font>
						</td>
					</tr>
</table>
<hr>
	<strong>题号：</strong>
	<s:property value="subjective.id"/><br><br>
	<strong>题目：</strong>
	<s:property value="subjective.detail"/><br><br>
	 <strong>正确答案：</strong>
	 <s:property value="subjective.KeyWords"/><br><br>
    <strong>章节号：</strong>
    <s:property value="subjective.chapterId"/><br><br>
<input type="button" value="返回" onclick="goBack()">

</form>
</body>
</html>