<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<title>试卷列表</title>
    <style>
    *{ margin:0; padding:0;font-size: 12px;}
	.table{ margin:0 auto;}
	.table td,.table th{ border-bottom:1px solid #CCC;}
	#div{ margin-top:10px;}
	#div input{ background:#FFF;}
	</style>
    <base href="<%=basePath%>">
	<script type="text/javascript">
	
		function findPaper() {
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
				alert("请选择需要编辑，修改的试卷！");
				return;
			}
			if (count > 1) {
				alert("一次只能修改一套试卷！");
				return;
			}
			window.self.location = "<%=basePath%>t/FindTest?paperId="+selectFlags[j].value;
		}
		
		function deletePaper() {
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
				alert("请选择需要删除的试卷！");
				return;
			}
			if (count > 1) {
				alert("一次只能删除一套试卷！");
				return;
			}
			window.self.location = "t/deletePaper?courseId=<s:property value="#session.onlineTeacher.courseId"/>&paperId="+selectFlags[j].value;
		}
		
		function addPaper(){
			window.self.location = "<%=basePath%>teacher/addPaper.jsp";
		}
	</script>
  </head>
  <body class="bgImage" bgcolor="#ADD9E6">
  <form id="userform" name="userform">
  <h2 align="center"><font color="#009900"><s:property value="#session.onlineTeacher.name"/></font>,以下是您的试卷列表</h2>
  <table align="center" class="table"  border="0" cellpadding="0" cellspacing="0">
     <tr height="30" bgcolor="#0066FF"><td></td><th width="223">序号</th><th width="223">试卷名称</th><th width="223">创建时间</th></tr>
	<s:iterator value="PaperList" var="s" status="sta">
		<tr bgcolor="#FFFFFF">
			<td height="31" align="center">
				<input type="checkbox" name="selectFlag" class="checkbox1" id="selectFL" value=<s:property value="#s.paperId"/>>
			</td>
			<td align="center"><s:property value="#sta.index+1"/></td>
      		<td align="center" bgcolor="#FFCCCC"><s:property value="#s.paperId"/></td>
		  <td align="center"><s:date name="#s.generateTime" format="yyyy-MM-dd HH:mm:ss"/></td>
			
		</tr>
		</s:iterator>
   </table>
			<div id="div" align="center">
				<input type="button" value="创建新试卷" onClick="addPaper()"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="添加/编辑试卷中的题目" onClick="findPaper()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="删除试卷" onClick="deletePaper()">
			</div>
	</form>	
  </body>
</html>
