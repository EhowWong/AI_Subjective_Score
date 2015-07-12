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
		/* if(trim(document.getElementById("answer").value).length ==0){
			alert("参考答案不能为空！");
			document.getElementById("answer").focus();
			return false;
			}
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
		/*
		document.getElementById("userForm").action="t/addTestChoice";
		document.getElementById("userForm").method="post";
		document.getElementById("userForm").submit();
		*/
		
		//等同上面的写法
		var obId=document.getElementById("tid").value;
		//alert(obId);
		if (window.confirm("确认修改吗？")) {
			document.getElementById("userform").action="t/modifyTestJudge?id=obId&paperId=<s:property value="paperId"/>&courseId="+<s:property value="#session.onlineTeacher.courseId"/>;
			
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
	<strong>题号：</strong>
	<input type="text" size="5" name="objective.id" id="tid" size="100" value="<s:property value="objective.id"/>" readonly><br><br>
	<strong>题目：</strong>
	<input type="text" name="objective.detail" id="detail" size="100" value="<s:property value="objective.detail"/>"><br><br>
	<strong>正确答案：</strong>
	<select onChange="check()" id="answer" name="objective.answer" >
  					<option value="1">正确</option>
  					<option value="0">错误</option>
			</select><br><br>
	<!-- 正确答案：<input type="text" name="objective.answer" id="answer"><br> -->
	<strong>类型：</strong>
	<select onChange="check2()" id=isSingleSelection name="objective.isSingleSelection">
  					<option value="0">判断</option>
  					
		</select><br><br>
    <strong>章节号：</strong>
    <input type="text" size="5" name="objective.chapterId" id="chapterId" value="<s:property value="objective.chapterId"/>"><br>
	<input type="hidden" name="objective.courseId" id="courseId" value="<s:property value="objective.courseId"/>" readonly><br><br>
	<input type="button" value="提交" onclick="addTestJudge()">&nbsp;&nbsp;&nbsp; <%--<input type="button" value="返回" onclick="goBack()"> 
	
--%></form>
</body>
</html>