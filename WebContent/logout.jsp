<%@page contentType="text/html; charset=GBK" language="java"  errorPage="error.jsp" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>用户退出</title>
</head>
<body>
<%
  session.invalidate();
  response.sendRedirect("index.jsp");
%>
</body>
</html>
