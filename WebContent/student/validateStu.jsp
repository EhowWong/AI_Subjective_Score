<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.exam.domain.*" %>
<%@ page import="com.exam.service.*" %>
<%
		Student student=(Student) session.getAttribute("onlineStudent");
		String account = student.getAccount();
		String name = student.getName();
		String paperId=request.getParameter("paperId");
		List<InvPaper> ip=StudentService.getInstance().loadAnswer(paperId,account);
		List<InvPaperT> it=StudentService.getInstance().loadSubA(paperId, account);
		if(!(0==ip.size()) || !(0==it.size())){
			out.print("*"+name+"同学,你已经答过【"+paperId+"】这套试卷了，不能重复答题！");
		}else{
			out.print("");
		}
%>