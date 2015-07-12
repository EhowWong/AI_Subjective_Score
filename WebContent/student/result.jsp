<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<style type="text/css">
		body{
			margin:200px auto;
			font-family:Arial;
			text-align:center;
		}
		.auto{ margin:0px auto;}
		.t_div{ }
		.test{
			margin:0px auto;
			padding:0px;
			background-color:red;
			color:#FF0;
			height:20px;
			width:300px;
			}
		#th1 th{ border-right:1px #FFFFFF solid;}
		.th2 th{ border-bottom:1px #666666 solid; height:20px;}
		.auto th{font-size: 12px;}
	</style>
  </head>
  
  <body>
    <h1>${onlineStudent.name }同学，你的答题情况如下</h1><br/>
    
   		<table calss="auto" align="center" border="0" cellpadding="0" cellspacing="1">
		    <tr><th width="300" bgcolor="green"><font color="white">您答题所用的时间为：<s:property value="time_f"/>分<s:property value="time_s"/>秒</font></th>
		</table><br/><br/>
		
	    <table calss="auto" align="center" border="0" cellpadding="0" cellspacing="0">
		    <tr id="th1"><th width="373" bgcolor="#CCCCCC">选择题目数</th><th width="373" bgcolor="#CCCCCC">正确题目数</th>
		    	<tr class="th2"><th align="center"><s:property value="objId.length"/></th><th align="center"><font color="red"><b><s:property value="rightNumber"/></b></font></th></tr>
		</table><br/><br/>
		
		<!--  *客观题分数开始*/-->
		<table  calss="auto" align="center" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left" valign="top">
				<table calss="auto" border="0" cellpadding="0" cellspacing="0">
		    		<tr id="th1">
		            	<th width="223" bgcolor="#CCCCCC">简答题题号</th><th width="300" bgcolor="#CCCCCC">问题内容</th>
		            </tr>
		     		<s:iterator value="Subjectives" var="s" status="st">
		            <tr class="th2">
		            	<th align="center"><s:property value="#st.index+1"/></th><th align="center"><s:property value="#s.detail"/></th>
		            </tr>
					</s:iterator>
			   </table>
		    </td>
			<td align="left" valign="top">
		    	<table calss="auto" border="0" cellpadding="0" cellspacing="0">
					<tr><th width="223" bgcolor="#CCCCCC">得分</th></tr>
					<s:iterator value="sc" var="s">
		     		<tr class="th2"><th align="center"><font color="red"><s:property value="#s.score"/></font></th></tr>
					</s:iterator>
				</table>
		    </td>
		</tr>
		</table><br/><br/>
		<!--  *客观题分数end*/-->
	
	<div class="test" align="center" >
			<span id="lefttime"></span>
		</div><br/><br/><br/>
		
  </body>
	<script type="text/javascript">
		 secs = 30;    
		 wait = secs * 100;
		 minute = 0;
		 cycle();
			
		 function cycle(){
			 for(i=0;i<=(wait/100);i++) {  
			  window.setTimeout("doUpdate(" + i + ")",i*1000);
			 }                
		 }
		
		 function doUpdate(num) {
			 if(num == (wait/100)) {
			  	  cycle();
				  if(minute<=0){
				  		exitSystem();
				  		//window.location.href="<%=basePath%>studentLoginInput"
				  	}else{
				  		minute--;
				  	}
			  } else {
				  wut = (wait/100)-num;
				  s=wut<10?"0"+wut:wut;
				  m=minute<10?"0"+minute:minute;
				  document.getElementById('lefttime').innerHTML = "<b>还有：</b>"+ m+ "分" + s + "<b>秒将自动退出系统。</b>";
			  }
		 }
		
		 function exitSystem(){
			//不加这句就会有提示框弹出！
		   	window.opener=null;
		   	window.open("","_self");
		    window.close();
		}

	var message="sorry,U can't do it!"; 
	//////////////////////////////////禁止右键/ 
	function clickIE() {if (document.all) {(message);return false;}} 
	function clickNS(e) {if 
	(document.layers||(document.getElementById&&!document.all)) { 
	if (e.which==2||e.which==3) {(message);return false;}}} 
	if (document.layers) 
	{document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;} 
	else{document.onmouseup=clickNS;document.oncontextmenu=clickIE;} 
	document.oncontextmenu=new Function("return false");
		
	</script> 
</html>