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
<script type="text/javascript">
	function goBack() {
		window.self.location="student_maint.jsp"
	}
	
	function addTestJudge() {
		
		
		if (trim(document.getElementById("detail").value).length == 0) {
			alert("题目不能为空！");
			document.getElementById("detail").focus();
			return false;
		}
		
		
		//参考答案不能为空
		if(trim(document.getElementById("answer").value).length ==3){
			alert("参考答案不能为空！");
			document.getElementById("answer").focus();
			return false;
			}
		/* 
		if(trim(document.getElementById("isSingleSelection").value).length ==0){
			alert("试题类型不能为空！");
			document.getElementById("isSingleSelection").focus();
			return false;
			} */
		//课程章节
		if(trim(document.getElementById("chapterId").value).length ==0){
			alert("章节号不能为空！");
			document.getElementById("chapterId").focus();
			return false;
		}
		//课程号不能为空
		if(trim(document.getElementById("courseId").value).length ==0){
			alert("课程号不能为空！");
			document.getElementById("courseId").focus();
			return false;
		}
		for (var i=0; i<trim(document.getElementById("chapterId").value).length; i++) {
			var c = trim(document.getElementById("chapterId").value).charAt(i);
			if (!(c >= '0' && c <='9')) {
				alert("章节号必须为数字！");
				document.getElementById("chapterId").value.focus();
				return;
			}
		}
		/*
		document.getElementById("userForm").action="t/addTestChoice";
		document.getElementById("userForm").method="post";
		document.getElementById("userForm").submit();
		*/
		
		//等同上面的写法
		if (window.confirm("确认添加吗？")) {
			document.getElementById("userform").action="t/addTestJudge?pageSize=10&pageNo=1";
			
			document.getElementById("userform").method="post";
			
			document.getElementById("userform").submit();
		}
		
	}
	
	function init() {
		document.getElementById("detail").focus();
	}	
</script>
<style>
input{ background:#FFF;}
</style>
</head>
<body  onload="init()" bgcolor="#ADD9E6">
<form name="userform" id="userform">
<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="25">
					<tr>
						<td bgcolor="#0066FF" width="522" class="p1" height="25" nowrap>
							
							<font color="#FFFFFF">系统管理&gt;&gt;添加判断题</font>
						</td>
					</tr>
</table>
<hr>
<input type="hidden" name="courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" >
	<strong>题目：</strong><br>
	<textarea name="objective.detail" id="detail" cols ="80" rows = "2"></textarea><br><br>
	<strong>正确答案：</strong><select onChange="check()" id="answer" name="objective.answer" >
					<option value="xxx">请选择</option>
  					<option value="1">正确</option>
  					<option value="0">错误</option>
			</select><br><br>
	<!-- 正确答案：<input type="text" name="objective.answer" id="answer"><br> --><%--
	类型：<br> <select onChange="check2()" id=isSingleSelection name="objective.isSingleSelection">
  					<option value="0">判断</option>
  					
		</select><br>
		--%><input type="hidden" name="objective.isSingleSelection" value="0" id="isSingleSelection" size="100" readonly>
	<strong>章节号：</strong><input type="text" size="5" name="objective.chapterId" id="chapterId"><br>
	<input type="hidden" name="objective.courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" id="courseId"><br><br>
	<input type="button" value="提交" onclick="addTestJudge()"><%--&nbsp;&nbsp;&nbsp; <input type="button" value="返回" onclick="goBack()"> 
	
--%></form>
</body>
</html>