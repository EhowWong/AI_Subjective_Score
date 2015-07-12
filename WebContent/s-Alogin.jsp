<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		body{
			font-family:Arial;
			text-align:center;
		}
		.auto{
			margin-top:20px;
		}
		.div{
			border:1px solid #999;
			width:400px;
			height:300px;
			margin:0px auto;
			margin-top:180px;
		}
	</style>
</head>
<body>

	<div class="div">
	<form action="studentLogin" method="post">
		<table class="auto" align="center" valign="middle" border="0" cellpadding="0" cellspacing="0">
			<tr><td colspan="2"><h4><font color="green">您的信息已经失效，请重新登录</font></h4></td></tr>
	 		<tr><td width="50" height="50" align="right" valign="middle">学号：</td><td width="150" align="left"><input type="text" name="account" id="account" size=20></td></tr>
	 		<tr><td width="50" height="50" align="right" valign="middle" align="right">密码：</td><td width="150" align="left"><input type="password" name="password" id="password" size=21></td></tr>
			<tr><td colspan="2" height="50" valign="middle" align="center"><input type="submit" value="登录"/>　<input type="reset" value="重置"/></td></tr>
		</table>
	</form>
	</div>
</body>
</html>