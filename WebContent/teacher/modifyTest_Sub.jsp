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
	
	function addTestSub(){
		
		
		if (trim(document.getElementById("detail").value).length == 0) {
			alert("题目不能为空！");
			document.getElementById("detail").focus();
			return false;
		}
		//课程编号不能为空
		if(trim(document.getElementById("KeyWords").value).length ==0){
			alert("参考答案不能为空！");
			document.getElementById("KeyWords").focus();
			return false;
			}

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
		document.getElementById("userForm").action="user_add.jsp";
		document.getElementById("userForm").method="post";
		document.getElementById("userForm").submit();
		*/
		
		//等同上面的写法
		var obId=document.getElementById("id").value;
	if (window.confirm("确认修改吗？")){
			document.getElementById("userform").action="t/modifyTestSub?id=obId&paperId=<s:property value="paperId"/>&courseId="+<s:property value="#session.onlineTeacher.courseId"/>;
			
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
	<strong>题　号：</strong>
	<input type="text" name="subjective.id" id="id" size="5" value="<s:property value="subjective.id"/>" readonly><br><br/>
	<strong>题　目：</strong>
	<input type="text" name="subjective.detail" id="detail" size="100" value="<s:property value="subjective.detail"/>"></input><br><br/>
	<strong>关键词：</strong>
	<input type="text" name="subjective.KeyWords" id="KeyWords" size="100" value="<s:property value="subjective.keyWords"/>"></input><br><br/>
	<strong>章节号：</strong>
	<input type="text" size="5" name="subjective.chapterId" id="chapterId" value="<s:property value="subjective.chapterId"/>"><br><br/>
	
	<input type="hidden" name="subjective.courseId" id="courseId" value="<s:property value="subjective.courseId"/>" readonly></input><br>
	<input type="button" value="提交" onclick="addTestSub()"></input>
</form>
</body>