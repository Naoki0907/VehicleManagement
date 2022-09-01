<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>系统信息</title>
<link href="<%=basePath %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/js/jquery.js"></script>

</head>

<body>
<%
String Agent = request.getHeader("User-Agent");

String datetime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 

// 取得本机的信息
//操作系统信息
String systemName = System.getProperty("os.name"); //win2003竟然是win XP？
String systemversion =  System.getProperty("os.version");
String systemarch =  System.getProperty("os.arch");

//当前浏览器信息
String browinfo = request.getHeader("User-Agent");

String ip = request.getRemoteAddr();//获得客户端的IP地址

String remoteHost =  request.getRemoteHost(); //获得客户端电脑的名字，若失败，则返回客户端电脑的IP地址

String protocolt = request.getProtocol();

%>
    <!-- 个人信息  -->
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">系统信息</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="<%=basePath %>/backimg/sun.png" alt="天气" /></span>
    <b>欢迎使用大象装修后台管理系统</b>
    </div>
    
    <div class="welinfo">
    <span><img src="<%=basePath %>/backimg/time.png" alt="时间" /></span>
    <i>当前系统时间：<%=datetime %></i>
    </div>
    
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <br/>
     <div class="welinfo">
    <i>当前操作系统：<%= systemName %></i>
    </div>
     <div class="welinfo">
    <i>当前系统版本：<%= systemversion %></i>
    </div>
     <div class="welinfo">
    <i>当前系统CPU：<%= systemarch %></i>
    </div>
     <div class="welinfo">
    <i>当前使用浏览器：<%= browinfo %></i>
    </div>
     <div class="welinfo">
    <i>当前客服端地址：<%= ip %></i>
    </div>
    </div>

</body>

</html>
