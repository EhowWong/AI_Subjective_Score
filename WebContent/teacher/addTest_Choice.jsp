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
<title>添加选择题</title>
<script src="js/client_validate.js"></script>
<script type="text/javascript">
	function goBack() {
		window.self.location="t/findTestObjectiveList?pageSize=10&pageNo=1&courseId=1"
	}
	
	function addTestChoice() {
		
		
		if (trim(document.getElementById("detail").value).length == 0) {
			alert("题目不能为空！");
			document.getElementById("detail").focus();
			return false;
		}
		
		
		if(trim(document.getElementById("optionA").value).length ==0){
			alert("选项A不能为空！");
			document.getElementById("optionA").focus();
			return false;
			}
		if(trim(document.getElementById("optionB").value).length ==0){
			alert("选项B不能为空！");
			document.getElementById("optionB").focus();
			return false;
			}
		if(trim(document.getElementById("optionC").value).length ==0){
			alert("选项C不能为空！");
			document.getElementById("optionC").focus();
			return false;
			}
		if(trim(document.getElementById("optionD").value).length ==0){
			alert("选项D不能为空！");
			document.getElementById("optionD").focus();
			return false;
			}	
		//alert(document.getElementById("answer").value);
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
			}
		*/
		//课程章节
		if(trim(document.getElementById("chapterId").value).length ==0){
			alert("章节号不能为空！");
			
			document.getElementById("chapterId").focus();
			return false;
		}
		for (var i=0; i<trim(document.getElementById("chapterId").value).length; i++) {
			var c = trim(document.getElementById("chapterId").value).charAt(i);
			if (!(c >= '0' && c <='9')) {
				alert("章节号必须为数字！");
				document.getElementById("chapterId").value.focus();
				return false;
			}
		}
		//课程号不能为空
		if(trim(document.getElementById("courseId").value).length ==0){
			alert("课程号不能为空！");
			document.getElementById("courseId").focus();
			return false;
		}
		
		if (window.confirm("确认添加吗？")) {
			document.getElementById("userform").action="t/addTestChoice?pageNo=1";
			
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
<body onload="init()" bgcolor="#ADD9E6">
<form name="userform" id="userform">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
					height="25">
					<tr>
						<td bgcolor="#0066FF" class="p1" height="25" nowrap>
							
							<font color="#FFFFFF">系统管理&gt;&gt;添加选择题</font>
						</td>
					</tr>
</table>
<hr>

<input type="hidden" name="courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" >
	<strong>题目：</strong><br>
	<textarea name="objective.detail" id="detail" cols ="80" rows = "2"></textarea><br>
	<strong>选项A：</strong><br>
	<textarea name="objective.optionA" id="optionA" cols ="80" rows = "2"></textarea><br>
	<strong>选项B：</strong><br>
	<textarea name="objective.optionB" id="optionB" cols ="80" rows = "2"></textarea><br>
	<strong>选项C：</strong><br>
	<textarea name="objective.optionC" id="optionC" cols ="80" rows = "2"></textarea><br>
	<strong>选项D：</strong><br>
	<textarea name="objective.optionD" id="optionD" cols ="80" rows = "2"></textarea><br><br>
	 <strong>正确答案：</strong><select onChange="check()" id="answer" name="objective.answer" >
	 				<option value="xxx">请选择</option>
  					<option value="A">A</option>
  					<option value="B">B</option>
  					<option value="C">C</option>
  					<option value="D">D</option>
			</select><br><br>
	<!-- 正确答案：<input type="text" name="objective.answer" id="answer"><br> -->
	 <%--试题类型：<br><select onChange="check2()" id=isSingleSelection name="objective.isSingleSelection">
  					<option value="1">选择</option>
  					
		</select><br>
		--%><input type="hidden" name="objective.isSingleSelection" value="1" id="isSingleSelection" size="100" readonly>
	<!-- 类型选择：<input type="text" name="objective.isSingleSelection" id="isSingleSelection"><br> -->
	<strong>章节号：</strong><input type="text" size="5" name="objective.chapterId" id="chapterId"><br>
	<input type="hidden" name="objective.courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" id="courseId"><br><br>
	
	
	<input type="button" value="提交" onclick="addTestChoice()"> <%--<input type="button" value="返回" onclick="goBack()">
--%></form>
</body>
</html>