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
		window.self.location="t/findTestObjectiveList?pageSize=20&pageNo=1&courseId=<s:property value="#session.onlineTeacher.courseId"/>"
	}
	function init() {
		document.getElementById("detail").focus();
	}	
</script>
</head>
<body onload="init()" bgcolor="#ADD9E6">
<form name="userform" id="userform">
<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="25">
					<tr>
						<td width="522" class="p1" height="25" nowrap>
							
							<b>系统管理&gt;&gt;查看判断题</b>
						</td>
					</tr>
</table>
<hr>
	题号：<s:property value="objective.id"/><br>
	题目：<s:property value="objective.detail"/><br>
	正确答案：<s:if test="objective.answer">正确</s:if><s:else>错误</s:else><br>
	章节号：<s:property value="objective.chapterId"/><br>
<input type="button" value="返回" onclick="goBack()">

</form>
</body>
</html>