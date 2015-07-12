<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <style>
<!--
body{
	margin:200px auto;
	width:100%;
	font-family:Arial;
	font-size:20px;
	text-align:center;
}
.navigation {
	width:300px;
	font-family:Arial;
	margin:0px auto;
}
.navigation ul {
	list-style-type:none;				/* 不显示项目符号 */
	margin:0px;
	padding:0px;
}
.navigation li {
	border-bottom:1px solid #ED9F9F;	/* 添加下划线 */
}
.navigation li a{
	display:block;						/* 区块显示 */
	padding:5px 5px 5px 0.5em;
	text-decoration:none;
	border-left:12px solid #096;		/* 左边的粗红边 */
	border-right:1px solid #0F0;		/* 右侧阴影 */
}
.navigation li a:link, .navigation li a:visited{
	background-color:#09F;
	color:#FFF;
	font-weight:900;
}
.navigation li a:hover{					/* 鼠标经过时 */
	background-color:#FFFF17;			    /* 改变背景色 */
	color:#E87400;						/* 改变文字颜色 */
}
-->
</style>
 <base href="<%=basePath%>">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Insert title here</title>
 </head>
 <body>
 <h1>欢迎你：${onlineStudent.name }同学</h1><br/>
 <div class="navigation">
 <ul>
 <li><a href="<%=basePath%>s/showPaper">显示你当前课程的试卷列表</a>
 </li>
 </ul>
 </div>
 </body>
</html>