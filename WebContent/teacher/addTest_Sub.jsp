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
<style type="text/css">
input{
<%--	background-color:green;--%>
	font-size: 14px;
}
textarea{
	font-size: 14px;
	width: 900px;
	height: 100px;
}
</style>
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
	
	function getkeyword(){
		var words=document.getElementById("KeyWords").value;
		if(words!=""){
			var url = "<%=basePath%>teacher/validateKey.jsp";
			var param = "words="+words+"&time="+new Date().getTime(); 
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
	

	//其他部分
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
		for (var i=0; i<trim(document.getElementById("chapterId").value).length; i++) {
			var c = trim(document.getElementById("chapterId").value).charAt(i);
			if (!(c >= '0' && c <='9')) {
				alert("章节号必须为数字！");
				document.getElementById("chapterId").value.focus();
				return;
			}
		}
		//课程号不能为空
		if(trim(document.getElementById("courseId").value).length ==0){
			alert("课程号不能为空！");
			document.getElementById("courseId").focus();
			return false;
		}
		//关键词不能为空
		if(trim(document.getElementById("main").value).length ==0){
			alert("请点击生成关键词按钮，或者输入关键词！");
			document.getElementById("main").focus();
			return false;
		}
		//等同上面的写法
		if (window.confirm("请检查下关键词，确认添加吗？")){
			document.getElementById("userform").action="t/addTestSub?pageSize=15&pageNo=1";
			
			document.getElementById("userform").method="post";
			
			document.getElementById("userform").submit();
	}
	}
	function init() {
		document.getElementById("detail").focus();
	}	
</script>
<style>
strong{ font:Verdana; font-size:14px;}
.button{ background:#FFF;}
</style>
</head>
<body  onload="init()" bgcolor="#ADD9E6">
<form name="userform" id="userform">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="25">
					<tr>
						<td bgcolor="#0066FF" class="p1" height="25" nowrap>
							
							<font color="#FFFFFF">系统管理&gt;&gt;添加主观题</font>
						</td>
					</tr>
</table>
<hr>
<table border="0" cellpadding="0" cellspacing="0">
<tr><td>
<input type="hidden" name="courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" >
	<br><strong>试题题目：</strong><br><br>
	<textarea name="subjective.detail" id="detail" cols ="80" rows = "2"></textarea><br>
	<br><strong>章节号：</strong><input type="text" size="4" name="subjective.chapterId" id="chapterId"></input><font color="#FF0000">（*只能填数字 不支持小数）</font><br>
	<input type="hidden" name="subjective.courseId" value="<s:property value="#session.onlineTeacher.courseId"/>" id="courseId">
	<br><strong>标准答案：</strong><br><br>
	<textarea  name="subjective.biaozhundaan" id="KeyWords" cols ="100" rows = "5"></textarea><br>
	<br><strong>关键词：</strong><font color="#FF0000">（*请点击“生成关键词”按钮以便生成关键词，若无法生成，请手动输入并用英文","分开 如果关键词已经生成-请点击“提交”按钮）</font><br/><br>
	<textarea name="subjective.KeyWords" id="main" cols ="100" rows = "3"></textarea><br><br>
	<input class="button" type="button" value="生成关键词" onclick="getkeyword()">&nbsp;&nbsp;&nbsp;
	<input class="button" type="button" value="提交" onclick="addTestSub()">&nbsp;&nbsp;&nbsp; </form>
</td></tr>
</table>
</body>