<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>大象装修登录</title>
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
    		<div class="wraper" style="width:20%; float: right";>
    			<nav>
    				<a style="line-height:50px;" href="/DecorateServer/pages/login.jsp">登录</a>
    				<a style="line-height:50px;" href="/DecorateServer/pages/register.jsp">注册</a>
    			</nav>
    		</div>
    	</header>
    	<div id="data" style="margin: 60px 215px; border:1px #dddddd solid; height:400px;">
    		<div id="data-in" style="margin:80px 350px">
    		<%
				if ("nouser".equals(request.getParameter("flag"))) {
    				out.println("<p style='color:red'>您要登录后才能浏览相关内容</p><br/>");
    			} else if ("".equals(request.getParameter("error"))) {
    				out.println("<p style='color:red'>您输入的用户名或密码有误</p><br/>");
    			} else if ("success".equals(request.getParameter("flag"))) {
 					out.println("<p style='color:red'>注册成功，请您登录</p><br/>");
    			}
    		 %>
    			<label><font size="4px" face="arial" color="black">已有账号</font></label>
    			<div class="line" style="height:1px; background-color:#dddddd; width:100%; margin:5px 1px;"></div>
    			<form action="/DecorateServer/DecorateUserServer" method="post">
	    			<input type="text" name="loginName" style="width:100%;height:45px;margin:8px 5px;font-size:18px" placeholder="请输入用户名"  />
	    			<input type="password" name="loginPwd" style="width:100%;height:45px;margin:8px 5px;font-size:18px" placeholder="请输入密码" />
	    			<input type="hidden" name="origin_uri" value="${requestScope.origin_uri }" />
	    			<br/>
	    			<center><input type="submit" value="登录" style="width:200px;height:35px"/></center>
	    			<br/>
	    			<div align="center"><font size="2px" color="blue">管理员将直接登录后台系统</font></div>
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
