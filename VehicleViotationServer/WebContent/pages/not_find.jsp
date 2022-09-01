<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8"/>
<meta http-equiv="cache-control" content="no-cache">
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>错误页面</title>
<link href="<%=basePath%>css/not_find.css" rel="stylesheet" type="text/css" media="all"/>

</head>
<body class="home_body">

<div class="wrap">
    <div class="not_find"></div>
    <div class="light"></div>
    <div class="fish"></div>
    <div class="tips">授权失败!</div>
</div>
<div class="inner_wave"></div>

</body>
</html>	
