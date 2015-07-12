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
<script src="js/client_validate.js"></script>
<!-- <link href="css/main.css" rel="stylesheet" type="text/css"> -->
<title>Insert title here</title>
<style>
*{ margin:0; padding:0;font-size: 12px;}
table{ margin:0 auto;}
.table td{ border-bottom:1px solid #CCC;}
#table{ margin-top:10px;}
#table input{ background:#FFF;}
</style>
<script type="text/javascript" language="javascript">

	//添加試題到試卷
	function addObjToPaper(){
	var selectFlags  = document.getElementsByName("selectFlag");
	var flag = false;
	var objectIds = "";
	for (var i=0; i<selectFlags.length; i++) {
		if (selectFlags[i].checked) {
			flag = true;
			var objectId=selectFlags[i].value
			objectIds += objectId + ",";
		}
	}
	if (!flag) {
		alert("请选择需要添加的试题！");
		return;
	}
		document.getElementById("userform").action="<%=basePath%>t/addToPaper?objectIds="+objectIds;
		
		document.getElementById("userform").method="post";
		
		document.getElementById("userform").submit();
}
 

	function modifyUser() {
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
	
	
	function findObject() {
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
			alert("请选择需要查看的用户！");
			return;
		}
		if (count > 1) {
			alert("一次只能查看一个用户！");
			return;
		}
		window.self.location = "<%=basePath%>t/showObjective?id="+selectFlags[j].value;
	}
	
	function deleteUser(){
		var selectFlags  = document.getElementsByName("selectFlag");
		var flag = false;
		for (var i=0; i<selectFlags.length; i++) {
			if (selectFlags[i].checked) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			alert("请选择需要删除的试题！");
			return;
		}
		if (window.confirm("确认删除吗？")) {
			with(document.getElementById("userform")){
				action="<%=basePath%>t/delTestObjective";
				method="post";
				submit();
			}
		}
		
	}
	
	function addPaper(){
			document.getElementById("userform").action="<%=basePath%>teacher/addTest_Choice.jsp";
			
			document.getElementById("userform").method="post";
			
			document.getElementById("userform").submit();
	}
	
	function checkAll(field) {
		var selectFlags = document.getElementsByName("selectFlag");
		for (var i=0; i<selectFlags.length; i++) {
			selectFlags[i].checked = field.checked;
		}
	}
	
	
	function topPage() {
	
			document.getElementById("userform").action="<%=basePath%>t/findTestObjectiveList?pageNo=<s:property value="pm.topPageNo"/>";
			
			document.getElementById("userform").method="post";
			
			document.getElementById("userform").submit();
	}
	function previousPage() {
	
			document.getElementById("userform").action="<%=basePath%>t/findTestObjectiveList?pageNo=<s:property value="pm.previousPageNo"/>";
			
			document.getElementById("userform").method="post";
			
			document.getElementById("userform").submit();
	}	
	
	function nextPage() {
		
			document.getElementById("userform").action="<%=basePath%>t/findTestObjectiveList?pageNo=<s:property value="pm.nextPageNo"/>";
			
			document.getElementById("userform").method="post";
			
			document.getElementById("userform").submit();
	}
	
	function bottomPage() {
		
			document.getElementById("userform").action="<%=basePath%>t/findTestObjectiveList?pageNo=<s:property value="pm.bottomPageNo"/>";
			
			document.getElementById("userform").method="post";
			
			document.getElementById("userform").submit();
	}

</script>
</head>
<body class="bgImage" bgcolor="#ADD9E6">
<form name="userform" id="userform">
  <input type="hidden" name="paperId" id="paperId" value="<s:property value="paperId"/>" size="100" readonly><br>
  <input type="hidden" name="paper.courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" id="courseId" size="100" readonly><br>
  <input type="hidden" name="courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" id="courseId" size="100" readonly><br>
	<div align="center"><h2>显示客观题</h2></div>
	<table id="usertable" align="center" border="0"  width="700" class="table" cellspacing="0" cellpadding="0">
		<tr height="30" bgcolor="#0066FF">
			<td width="24" align="center" >
					<input type="checkbox" name="ifAll" onClick="checkAll(this)">
			</td>
			<td width="20" align="center" ><b>序号</b></td>
			<td width="20" align="center" ><b>题号</b></td>
			<td width="20" align="center" ><b>章节</b></td>
			<td width="30" align="center" ><b>类型</b></td>
			<td width="100" align="center"><b>题目</b></td>
			
		</tr>
		
		<s:iterator value="pm.list" var="s" status="stat">
		<tr bgcolor="#FFFFFF">
			<td height="31" class="rd8" align="center" >
				<input type="checkbox" name="selectFlag" class="checkbox1" id="selectFL" value=<s:property value="#s.id"/>>
			</td>
			<td align="center" ><s:property value="#stat.index+1"/></td>
      		<td align="center" ><s:property value="#s.id"/></td>
			<td align="center" ><s:property value="#s.chapterId"/></td>
			<td align="center" ><s:if test="#s.isSingleSelection==1">选择题</s:if><s:else>判断</s:else></td>
			<td align="center"><s:property value="#s.detail"/></td>
		</tr>
		</s:iterator>
	</table>
	
	<table width="80%" id="table" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td nowrap height="2">
				<div align="left">
					<font color="#000000">&nbsp;共&nbsp;</font>
					<font color="#FF0000"><s:property value="pm.totalPages"/></font>
					<font color="#000000">&nbsp;页</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#000000">当前第</font>&nbsp;
					<font color="#FF0000"><s:property value="pm.pageNo"/></font>&nbsp;
					<font color="#000000">页</font>
				</div>
			</td>
			<td nowrap>
				<div align="right">
					<input name="btnTopPage" type="button"
								id="btnTopPage" value="首页" title="首页"
								onClick="topPage()">
					<input name="btnPreviousPage" type="button"
								id="btnPreviousPage" value="上一页" title="上一页"
								onClick="previousPage()">
					<input name="btnNextPage" type="button"
								id="btnNextPage" value="下一页" title="下一页" onClick="nextPage()">
					<input name="btnBottomPage" type="button"
								id="btnBottomPage" value="尾页" title="尾页"
								onClick="bottomPage()">
			    <input type="button" value="添加题目" onClick="addPaper()">
				<input type="button" value="修改" onClick="modifyUser()">
				<input type="button" value="查看" onClick="findObject()">
				<input type="button" value="删除" onClick="deleteUser()">
				<input type="button" value="添加題目到試卷" onClick="addObjToPaper()">
				</div>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>