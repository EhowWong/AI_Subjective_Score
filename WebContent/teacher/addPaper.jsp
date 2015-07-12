<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addPaper.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/client_validate.js"></script>
<script type="text/javascript">

		//采用Ajax技术，创建Ajax对象
	var xmlHttpRequest; 
	function createXMLHttpRequest(){
		//表示当前浏览器不是Ie，如火狐，Google
		if(window.XMLHttpRequest){
			xmlHttpRequest=new XMLHttpRequest();
		}else if(window.ActiveXObject){
			xmlHttpRequest=new ActiveXObject("Microsoft.XMLHttp");
		}
	}
	
	function vaildatepaperId(field){
		var words=field.value;
		if(words!=""){
			var url = "<%=basePath%>teacher/validatePaperId.jsp";
			var param = "paperId="+words+"&time="+new Date().getTime(); 
			sendRequestPost(url,param); 
			}
	}
	
	//发送请求函数 
	function sendRequestPost(url,param){ 
		createXMLHttpRequest(); 
		xmlHttpRequest.open("POST",url,true); 
		xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
		xmlHttpRequest.onreadystatechange = processResponse; 
		xmlHttpRequest.send(param); 
	} 
	//处理返回信息函数 
	function processResponse(){ 
		if(xmlHttpRequest.readyState == 4){ 
			if(xmlHttpRequest.status == 200){ 
			var res = trim(xmlHttpRequest.responseText); 
			document.getElementById("main").innerHTML=res;
		}else{ 
			window.alert("请求页面异常"); 
			} 
		} 
	} 
		
		function addPaperId(){
		
			if(document.getElementById("main").innerHTML!=""){
					alert("请注意，试卷名称不能重复！")
					return false;
			}
			if(trim(document.getElementById("els_paperId").value).length ==0){
				var els_paperId=document.getElementById("els_paperId").value;
				alert("试卷名称不能为空！");
				document.getElementById("els_paperId").focus();
				return false;
				
			}
<%-- 			for (var i=0; i<trim(document.getElementById("els_paperId").value).length; i++) {
				var c = trim(document.getElementById("els_paperId").value).charAt(i);
				if (!(c >= '0' && c <='9')) {
					alert("试卷名称必须为数字！");
					document.getElementById("els_paperId").value.focus();
					return;
				}
			}
--%>
			if(trim(document.getElementById("objScore").value).length ==0){
				alert("选择题目的分数不能为空！");
				//alert(els_paperId);
				document.getElementById("objScore").focus();
				return false;
				
			}
			for (var i=0; i<trim(document.getElementById("objScore").value).length; i++) {
				var c = trim(document.getElementById("objScore").value).charAt(i);
				if (!(c >= '0' && c <='9')) {
					alert("分数必须为数字！");
					document.getElementById("objScore").value.focus();
					return;
				}
			}

			if(trim(document.getElementById("subScore").value).length ==0){
				alert("简答题目的分数不能为空！");
				//alert(els_paperId);
				document.getElementById("subScore").focus();
				return false;
				
			}
			for (var i=0; i<trim(document.getElementById("subScore").value).length; i++) {
				var c = trim(document.getElementById("subScore").value).charAt(i);
				if (!(c >= '0' && c <='9')) {
					alert("分数必须为数字！");
					document.getElementById("subScore").value.focus();
					return;
				}
			}
			var courseId=document.getElementById("courseId").value;
			var els_paperId=document.getElementById("els_paperId").value;
		
			//window.self.location = "t/addPaper?paperId=";
			if (window.confirm("确认添加吗？")) {
			document.getElementById("userform").action="t/addPaper?paperId=els_paperId&courseId="+<s:property value="#session.onlineTeacher.courseId"/>;
			
			document.getElementById("userform").method="post";
			
			document.getElementById("userform").submit();
		}
		}
		function init() {
			document.getElementById("els_paperId").focus();
		}	
	</script>
    <style>
	input,strong{ font-size:14px;}
	table{ margin:0 auto; background:#06F; border:1px solid #666;}
	input{ background:#FFF;}
	</style>
  </head>
  
  <body onload="init()" bgcolor="#ADD9E6">
    <form name="userform" id="userform">
    <table align="center" border="0" cellpadding="0" cellspacing="10">
  <tr>
    <td align="right" valign="middle"><strong>试卷名称：</strong></td>
    <td align="left" valign="middle"><input type="text" name="paper.paperId" id="els_paperId" size="30" onblur="vaildatepaperId(this)"><span id="main"></span></td>
  </tr>
  <tr>
    <td align="right" valign="middle"><strong>每道选择题的分数：</strong></td>
    <td align="left" valign="middle"><input type="text" name="paper.objScore" id="objScore" size="30"></td>
  </tr>
  <tr>
    <td align="right" valign="middle"><strong>每道简答题题的分数： </strong></td>
    <td align="left" valign="middle"><input type="text" name="paper.subScore" id="subScore" size="30"><br>
	  <input type="hidden" name="paper.courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" id="courseId" size="100" readonly></td>
  </tr>
  <tr>
    <td colspan="2" align="center" valign="middle">
<%--   		考试时间：<input type="text" name="paper.examTime" id="els_examTime" size="100"><br>--%>
    		<input type="button" value="提交" onclick="addPaperId()">
    </td>
  </tr>
</table>
</form>
  </body>
</html>
