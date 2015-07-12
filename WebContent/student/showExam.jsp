<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>答题</title>
<script type="text/javascript">

 secs = 59;    
 wait = secs * 100;
 minute = 59;
 cycle();
	
	 function cycle(){
		 for(i=0;i<=(wait/100);i++) {  
		  window.setTimeout("doUpdate(" + i + ")",i*1000);
		 }                
	 }

	 function doUpdate(num) {
		 if(num == (wait/100)) {
		  cycle();
		 
		  if(minute==3){
		   alert("还有三分钟时间，请及时交卷！");
		  }
		 
		  if(minute<=0){
		   document.exam.action="<%=basePath%>s/showResults";
		   document.exam.submit();
		  }
		  minute--;
		  } else {
		  wut = (wait/100)-num;
		  s=wut<10?"0"+wut:wut;
		  m=minute<10?"0"+minute:minute;
		  document.getElementById('lefttime').innerHTML = "<b>欢迎您进入考试系统，距离考试结束还有：</b>"+ m+"分"+s + "秒";
		  }
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
	
	function init(){ 
		var strSession = "<%= session.getAttribute("onlineStudent") %>";
		if( strSession == "") {
			alert("你已经答过题目了，请重新登录，回答其他题目！");
		}
		//window.location.href="<%=basePath%>studentLoginInput"; 
	}
	
	function finsh() {
		if(window.confirm("确定要提交试卷吗?")) {
			with(document.getElementById("exam")){
				action="<%=basePath%>s/showResults";
				method="post";
				submit();
			}
		}
	}
	window.onbeforeunload = function(){
		    return "您之前的操作尚未保存，是否保存？";
	}
	
</script>

<style type="text/css">
*{margin: 0; padding: 0;}
body{
	width:100%;
	font-family:Arial;
	font-size:18px;
	text-align:center;
	background:#CCC;
}
.container{
	position:relative;
	background:#fff;
	margin:0px auto;
	width:970px;
	text-align: left;
	border:1px solid #999;
}

.test{
	margin:0px; padding:0px;
	background-color:red;
	color:#FF0;
	width:970px;
	height:30px;
	position:fixed;
	font-size:20px;
	}
.navigation {
	width:900px;
	margin:0px auto;
	font-family:Arial;
	text-align: left;
	margin-top:10px;
}
.navigation2 {
	width:900px;
	margin:0px auto;
	font-family:Arial;
	text-align: left;
	margin-top:20px;
	margin-bottom: 20px;
}
.navigation ul {
	list-style-type:none;				
	margin:0px,auto;
	padding:0px;
}
.navigation input{
	margin-left:20px;
}
input{
	background-color:green;
	font-size: 20px;
}
textarea{
	font-size: 19px;
	width: 800px;
	height: 200px;
}
</style>
</head>

<body onload="init()">
	<form name="exam" id="exam">
	<input type="hidden" name="paperId" value=<s:property value="paperId"/> />
	<div class="container">
	<div class="test" align="center">
	           <span><b><s:property value="#session.onlineStudent.name"/></b></span><span id="lefttime" ></span>
	</div><br/><br/>
		
			<div class="navigation">
			<font color="green"><b>一、选择题</b></font>
			</div>
	        <s:iterator value="Objectives" var="o" status="stat">
	        <div class="navigation">
	        <input type="hidden" name="objAnswer.id" value=<s:property value="#o.id"/> ></input>
	        	<ul>
	        		<input type="hidden" name="objId"/>
	        		<s:property value='#stat.index+1'/>.&nbsp;&nbsp;<s:property value="#o.detail"/>
	        			<li><input type="radio" name="rObjId_<s:property value='#stat.index+1' />" value="A"/>&nbsp;&nbsp;A.<s:property value="#o.optionA"/></li>
	        			<li><input type="radio" name="rObjId_<s:property value='#stat.index+1' />" value="B"/>&nbsp;&nbsp;B.<s:property value="#o.optionB"/></li>
	        			<li><input type="radio" name="rObjId_<s:property value='#stat.index+1' />" value="C"/>&nbsp;&nbsp;C.<s:property value="#o.optionC"/></li>
	        			<li><input type="radio" name="rObjId_<s:property value='#stat.index+1' />" value="D"/>&nbsp;&nbsp;D.<s:property value="#o.optionD"/></li>
	        	</ul>
	        </div>
	        </s:iterator>
	        <!-- <s:property value='#o.id'/> -->
	        
	        <!-- <s:property value='#s.id'/> -->
	        <br/><br/>
	        <div class="navigation">
	        <font color="green"><b>二、简答题（在题目下方输入您的答案）</b></font>
	        </div>
			<div class="navigation2">
	        <s:iterator value="Subjectives" var="s" status="st">
	          <input type="hidden" name="subAnswer.id" value=<s:property value="#s.id"/> ></input>
	          <input type="hidden" name="subId"/>
	        	<s:property value='#st.index+1'/>.<s:property value="#s.detail"/><br/>
	        		<textarea style="color:green" name="subAnswer.content"></textarea>
	        	<br/><br/><br/>
	        </s:iterator>
	        </div><br/>
			
		</div><br/>
		<input type="button" style="color:yellow" value="提交答卷" onclick="finsh()"></input><br/><br/>
	</form>
</body>

</html>
