<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/DecorateServer/css/common.css"/>
	<style>
		 body {
		    overflow-x: hidden; 
		 background:url(/DecorateServer/image/15.jpg);
    	 }
		 a { 
		  	text-decoration: none; 
		  	display:inline-bolck;
		  	color:#DDDDDD
		 }
		 a:hover {
		 	cursor: pointer
		 } 
		 .nav {
		 	height:50px; width:100%; background-color:#036ebe;
		 }
		 #logo {
		 	width: 25%;
		 	float: left;
		 }
		 #menu {
		 	width: 50%;
		 	float: left;
		 	margin-left: 5px;
		 }
		 #menu>li {
		 	color: #DDDDDD;
		 	list-style: none;
		 	display: inline-block;
		 	line-height: 50px;
		 	width: 20%;
		 }
	</style>
  </head>
  
  <body>
    <div id="container">
    	<header class="nav">
    		<div id="tip">
    			<label style="text-align:center;line-height:50px;color:#DDDDDD;margin-left: 10px;">欢迎来到<a href="/DecorateServer"><font color="red">大象装修</font></a></label>
    			<div style="clear: both"></div>
    		</div>
    	    <div class="wraper" style="width:50%; height:100%;float:right;";>
    			<nav>
    				<a style="line-height:40px;margin-left:350px;text-decoration:none" href="/DecorateServer/pages/login.jsp">登录</a>
    				<a style="line-height:40px;text-decoration:none" href="/DecorateServer/pages/register.jsp">注册</a>
    			</nav>
    		</div>
    	</header>

    		<div id="data" style="margin: 60px 215px; border:1px #dddddd solid; height:400px;">
    		<div id="data-in" style="margin:80px 350px">
    		<%
    			if ("error".equals(request.getParameter("flag"))) {
    				out.println("<p style='color:red'>您两次输入的密码不一致</p><br/>");
    			} else if ("empty".equals(request.getParameter("flag"))) {
    				out.println("<p style='color:red'>您的用户名或密码未输入</p><br/>");
    			} else if ("hasUser".equals(request.getParameter("flag"))) {
    				out.println("<p style='color:red'>用户名已存在</p><br/>");
    			} 
    		 %>
    			<label><font size="4px" face="arial" color="black">注册</font></label>
    			<div class="line" style="height:1px; background-color:#dddddd; width:100%; margin:5px 1px;"></div>
    			<form action="/DecorateServer/regDecorateUser" method="post">
	    			<input type="text" name="loginName" style="width:100%;height:45px;margin:8px 5px;font-size:18px" placeholder="请输入用户名"  />
	    			<input type="password" name="loginPwd" style="width:100%;height:45px;margin:8px 5px;font-size:18px" placeholder="请输入密码" />
	    			<input type="password" name="loginPwdAgain" style="width:100%;height:45px;margin:8px 5px;font-size:18px" placeholder="请再次输入密码" />
	    			<br/>
	    			<center><input type="submit" value="注册" style="width:200px;height:35px"/></center>
    			</form>
    		</div>
    	</div>
    	
    	<div id="footer" style="position:fixed; bottom:0px; background-color:#232323; height:80px; width:100%">
    		<p style="color:white; font-size:22px; line-height:40px; text-align:center;">
    		微感觉工作室制作
    		</p>
    </div>
    </div>
  </body>
</html>
