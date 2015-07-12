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
	
	function modifyUser() {
		
		
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
		/* if(trim(document.getElementById("answer").value).length ==0){
			
			alert("参考答案不能为空！");
			document.getElementById("answer").focus();
			return false;
			} 
		 
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
		//课程号不能为空
		if(trim(document.getElementById("courseId").value).length ==0){
			alert("课程号不能为空！");
			document.getElementById("courseId").focus();
			return false;
		}
		var obId=document.getElementById("id").value;
		
		if (window.confirm("确认修改吗？")) {
			document.getElementById("userform").action="t/modifyTestChoice?id=obId&paperId=<s:property value="paperId"/>&courseId="+<s:property value="#session.onlineTeacher.courseId"/>;
			
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
	<strong>题号：</strong><br/><input type="text" name="objective.id" id="id" size="100" value="<s:property value="objective.id"/>" readonly><br>
	<strong>题目：</strong><br/><input type="text" name="objective.detail" id="detail" size="100" value="<s:property value="objective.detail"/>" ><br>
	<strong>选项A</strong><br/><input type="text" name="objective.optionA" id="optionA" size="100" value="<s:property value="objective.optionA"/>"><br>
	<strong>选项B</strong><br/><input type="text" name="objective.optionB" id="optionB" size="100" value="<s:property value="objective.optionB"/>"><br>
	<strong>选项C</strong><br/><input type="text" name="objective.optionC" id="optionC" size="100" value="<s:property value="objective.optionC"/>"><br>
	<strong>选项D</strong><br/><input type="text" name="objective.optionD" id="optionD" size="100" value="<s:property value="objective.optionD"/>"><br><br/>
	 <strong>正确答案：</strong><select onChange="check()" id="answer" name="objective.answer" >
  					<option value="A">A</option>
  					<option value="B">B</option>
  					<option value="C">C</option>
  					<option value="D">D</option>
			</select><br><br/>
	<!-- 正确答案：<input type="text" name="objective.answer" id="answer"><br> -->
	<strong>类型：</strong><select onChange="check2()" id=isSingleSelection name="objective.isSingleSelection">
  					<option value="1">选择</option>
  					
		</select><br><br/>
	<!-- 类型选择：<input type="text" name="objective.isSingleSelection" id="isSingleSelection"><br> -->
	<strong>章节号：</strong><input type="text" size="5" name="objective.chapterId" id="chapterId" value="<s:property value="objective.chapterId"/>"><br>
	<input type="hidden" name="objective.courseId" id="courseId" value="<s:property value="objective.courseId"/>" readonly><br><br/>
	
	
	<input type="button" value="修改" onclick="modifyUser()"> <%--<input type="button" value="返回" onclick="goBack()">
--%></form>
</body>
</html>