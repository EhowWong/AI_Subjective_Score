<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <style>
    *{ margin:0; padding:0;font-size: 12px;}
    </style>
    <script type="text/javascript">
    function deleteUser1(){
    	var selectFlags  = document.getElementsByName("selectFlag");
		var flag = false;
		var objectIds="";
		for (var i=0; i<selectFlags.length; i++) {
			if (selectFlags[i].checked) {
				flag = true;
				var objectId=selectFlags[i].value
				objectIds += objectId + ",";
			}
		}
		if (!flag) {
			alert("请选择需要删除的试题！");
			return;
		}
		if (window.confirm("确认删除吗？")) {
			with(document.getElementById("userform")){
				action="<%=basePath%>t/deleteObFromPaper?objectIds="+objectIds;
				method="post";
				submit();
			}
		}
    }
    
    function deleteUser2(){
    	var selectFlags  = document.getElementsByName("selectFlag");
		var flag = false;
		var subjectIds="";
		for (var i=0; i<selectFlags.length; i++) {
			if (selectFlags[i].checked) {
				flag = true;
				var sbjectId=selectFlags[i].value
				subjectIds += sbjectId + ",";
			}
		}
		if (!flag) {
			alert("请选择需要删除的试题！");
			return;
		}
		if (window.confirm("确认删除吗？")) {
			with(document.getElementById("userform2")){
				action="<%=basePath%>t/deleteSubFromPaper?subjectIds="+subjectIds;
				method="post";
				submit();
			}
		}
		
    }
	
	function findJudge() {
		var selectFlags  = document.getElementsByName("selectFlag");
		var count = 0;
		var j = 0;
		for (var i=0; i<selectFlags.length; i++) {
			if (selectFlags[i].checked) {
			    j = i;
				count++;
			}
		}
		if (count == 0) {
			alert("请选择需要查看的试题！");
			return;
		}
		if (count > 1) {
			alert("一次只能查看一个试题！");
			return;
		}
		window.self.location = "<%=basePath%>t/showObjectiveJudge?paperId=<s:property value="paperId"/>&id="+selectFlags[j].value;
	}
	
	function findsub() {
		var selectFlags  = document.getElementsByName("selectFlag");
		var count = 0;
		var j = 0;
		for (var i=0; i<selectFlags.length; i++) {
			if (selectFlags[i].checked) {
			    j = i;
				count++;
			}
		}
		if (count == 0) {
			alert("请选择需要查看的试题！");
			return;
		}
		if (count > 1) {
			alert("一次只能查看一个试题！");
			return;
		}
		window.self.location = "<%=basePath%>t/showSubjective?paperId=<s:property value="paperId"/>&id="+selectFlags[j].value;
	}
	
    function modifyUser1() {
		var selectFlags  = document.getElementsByName("selectFlag");
		var count = 0;
		var j = 0;
		for (var i=0; i<selectFlags.length; i++) {
			if (selectFlags[i].checked) {
			    j = i;
				count++;
			}
		}
		if (count == 0) {
			alert("请选择需要修改的试题！");
			return;
		}
		if (count > 1) {
			alert("一次只能修改一个试题！");
			return;
		}
		window.self.location = "<%=basePath%>t/findObjective?id="+selectFlags[j].value;
	}
    
    function modifyUser2() {
		var selectFlags  = document.getElementsByName("selectFlag");
		var count = 0;
		var j = 0;
		for (var i=0; i<selectFlags.length; i++) {
			if (selectFlags[i].checked) {
			    j = i;
				count++;
			}
		}
		if (count == 0) {
			alert("请选择需要修改的试题！");
			return;
		}
		if (count > 1) {
			alert("一次只能修改一个试题！");
			return;
		}
		window.self.location = "<%=basePath%>t/findObjective?id="+selectFlags[j].value;
	}
    
    function modifyUser3() {
		var selectFlags  = document.getElementsByName("selectFlag");
		var count = 0;
		var j = 0;
		for (var i=0; i<selectFlags.length; i++) {
			if (selectFlags[i].checked) {
			    j = i;
				count++;
			}
		}
		if (count == 0) {
			alert("请选择需要修改的用户！");
			return;
		}
		if (count > 1) {
			alert("一次只能修改一个用户！");
			return;
		}
		window.self.location = "<%=basePath%>t/findSubjective?id="+selectFlags[j].value;
	}
    
    function addTestObjective(){
    	var paperId=document.getElementById("paperId").value;
		var courseId=document.getElementById("courseId").value;
		document.getElementById("userform").action="<%=basePath%>t/findTestObjectiveList?paperId=<s:property value="paperId"/>&pageSize=20&pageNo=1&courseId="+courseId;
		
		document.getElementById("userform").method="post";
		
		document.getElementById("userform").submit();
    }
    
    function addTestSubjective(){
    		var paperId=document.getElementById("paperId").value;
    		var courseId=document.getElementById("courseId").value;
    		document.getElementById("userform2").action="<%=basePath%>t/findTestSubjectiveList?paperId=<s:property value="paperId"/>&pageSize=20&pageNo=1&courseId="+courseId;
    		
    		document.getElementById("userform2").method="post";
    		
    		document.getElementById("userform2").submit();
    }
    </script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#ADD9E6">
  <form name="userform" id="userform">
  <div align="center"><h2>您的试卷名称是：<s:property value="paperId"/></h2></div>
  <input type="hidden" name="paper.paperId" id="paperId" value="<s:property value="paperId"/>" size="100" readonly><br>
  <input type="hidden" name="paper.courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" id="courseId" size="100" readonly><br>
  <h3>选择题:</h3>
    <style>
	.table{ margin:0 auto;}
	.table td,.table th{ border-bottom:1px solid #CCC; line-height:25px;}
	input{ background:#FFF;}
	</style>
	<table id="usertable" border="0"  width="1100" class="table" cellspacing="0" cellpadding="0">
		<tr bgcolor="#0066FF">
			<td width="24" height="30"></td>
			<th width="100" align="center">序号</th>
			<th width="876" align="center">题目</th>
			<th width="100" align="center" >章节号</th>
		</tr>
		
		<s:iterator value="ObjectiveList" var="s" status="stat">
		<tr bgcolor="#FFFFFF">
			<td height="31" class="rd8" align="center" >
				<input type="checkbox" name="selectFlag" class="checkbox1" id="selectFL" value=<s:property value="#s.id"/>>
			</td>
      		<td align="center"><s:property value="#stat.index+1"/></td>
      		<td bgcolor="#FFCCFF" align="left"><s:property value="#s.id"/>:<s:property value="#s.detail"/>()<br>
      		<s:if test="#s.isSingleSelection==1">
      			A:<s:property value="#s.OptionA"/><br>
      			B:<s:property value="#s.OptionB"/><br>
      			C:<s:property value="#s.OptionC"/><br>
      			D:<s:property value="#s.OptionD"/><br>
      			</s:if>
      			<s:else>
      			正确：<input type="radio"/>&nbsp;&nbsp;&nbsp;错误：<input type="radio"/>
      			</s:else>
      		</td>
			<td align="center" ><s:property value="#s.chapterId"/></td>
		</tr>
		</s:iterator>
	</table><br>
		<input type="button" value="从题库添加试题" onClick="addTestObjective()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="删除" onClick="deleteUser1()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="修改" onClick="modifyUser2()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</form>
	
	<form name="userform2" id="userform2">
	<input type="hidden" name="paper.paperId" id="paperId" value="<s:property value="paperId"/>" size="100" readonly><br>
  	<input type="hidden" name="paper.courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" id="courseId" size="100" readonly><br>
	<h3>简答题:</h3>
	<table id="Usertable" border="0"  width="1100" class="table" cellspacing="0" cellpadding="0">
		<tr bgcolor="#0066FF">
			<td width="24" height="30"></td>
			<th width="100" align="center">序号</th>
			<th width="876" align="center">题目</th>
			<th width="100" align="center" >章节号</th>
		</tr>
		
		<s:iterator value="SubjectiveList" var="s" status="stat">
		<tr bgcolor="#FFFFFF">
			<td height="31" class="rd8" align="center" >
				<input type="checkbox" name="selectFlag" class="checkbox1" id="selectFL" value=<s:property value="#s.id"/>>
			</td>
			<td align="center" ><s:property value="#stat.index+1"/></td>
      		<td bgcolor="#FFFF99"><s:property value="#s.id"/>:<s:property value="#s.detail"/>()<br>
			<td align="center" ><s:property value="#s.chapterId"/></td>
		</tr>
		</s:iterator>
	</table><br>
		<input type="button" value="从题库添加试题" onClick="addTestSubjective()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="删除" onClick="deleteUser2()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="修改" onClick="modifyUser3()"></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</form>
  </body>
</html>
