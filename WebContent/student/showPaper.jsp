<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
 <!--
	body{
		margin:0px;
		font-family:Arial;
		text-align:center;
	}
	
	.auto{ margin:0px auto;}
	
	table{
	 border:none;
	 color:#565;
	 font:12px arial;
	 text-align:left;
	}
	table caption{
	 font-size:24px;
	 border-bottom:2px solid #b3de94;
	}
	table,td,th{
	 margin:0;
	 padding:0;
	 vertical-align:middle;
	}
	tbody td,tbody th{
	 border-bottom:2px solid #b3de94;
	 border-top:3px solid #fff;
	 padding:9px;
	}
	tfoot td, tfoot th{
	 font-weight:bold;
	 padding:4px 8px 6px 9px;
	 text-align:center;
	}
	thead th{
	 font-size:18px;
	 font-weight:bold;
	 line-height:19px;
	 padding:0 8px 2px;
	 text-align:center;
	}
	tbody tr.even th,tbody tr.even td{
	 background-color:#cea;
	 border-bottom:2px solid #67bd2a;
	}
	col.price{
	 text-align:right;
	}
 -->
</style>
    <base href="<%=basePath%>">
    
    <title>试卷列表</title>
    <script src="<%=basePath%>script/client_validate.js"></script>
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
	
	function begin(paperId){
		if(paperId.length!=0){
			var url = "<%=basePath%>student/validateStu.jsp";
			var param = "paperId="+paperId+"&time="+new Date().getTime(); 
			sendRequestPost(url,param); 
		}else{
			document.getElementById("main").innerHTML="";
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
			if(res!=""){
				document.getElementById("main").innerHTML="<font color='red'><h3>"+res+"</h3></font>";
			}else{
				document.getElementById("main").innerHTML="";
			}
		}else{ 
			window.alert("请求页面异常"); 
			} 
		} 
	} 
	
		
		function ok(paperId){
			if(trim(document.getElementById("main").innerHTML)!=""){
				alert("此套试卷你不能重复答题！")
				document.getElementById("main").innerHTML!="";
				return;
			}else if(trim(document.getElementById("main").innerHTML)==""){
				window.open( "<%=basePath%>s/showQuestions?paperId="+paperId, "_blank", "titlebar=no,fullscreen=yes,channelmode=yes, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no");
				//window.open( "<%=basePath%>s/showQuestions?paperId="+paperId, "1","height="+window.screen.height+",width="+window.screen.width);
				exitSystem();
		}
	}	
		function exitSystem(){
			//不加这句就会有提示框弹出！
		   	window.opener=null;
		   	window.open("","_self");
		    window.close();
		}
	</script>
  </head>
  <body>
  	<h4><s:property value="#session.onlineStudent.name"/>,你的试卷列表如下：</h4>
  	<hr align="center" width="50%" color="green"/>
    <table class="auto" align="center" border="0" cellpadding="0" cellspacing="1">
     <tr><th colspan="3" width="650" bgcolor="green" align="center"><font color="white">重要信息</font></th></tr>
	 <tr><td colspan="3" align="center"><span id="main"></span></td></tr>
    <tr class="even"><th width="100" bgcolor="#CCCCCC" align="center">试卷名称</th><th width="223" bgcolor="#CCCCCC" align="center">时间</th><th width="223" bgcolor="#CCCCCC" align="center">操作</th></tr>
    <s:iterator value="papers" var="p">
    		<tr><td align="center"><s:property value="#p.paperId"/></td><td align="center"><s:property value="#p.generateTime"/></td><td align="center"><input type="button" value="答题" onmouseover="begin('<s:property value='#p.paperId'/>')" onclick="ok('<s:property value='#p.paperId'/>')"/></td></tr>
    </s:iterator>
	</table>
  </body>
</html>
