<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大象装修后台管理</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		});
		//$(".logout").click(function(){
		//	});

	})
</script>
</head>
<body>
	<div class="topbg">
		<div class="topleft">
			<a href="main.jsp" target="_parent">
			</a>
		</div>

		<ul class="nav">
			<div style="margin-top: 20px;font-size: 24px; color: white;" >大象装修后台管理</div>
		</ul>

		<div class="topright">
			<ul>
				<li><span><img src="<%=basePath %>backimg/help.png" title="帮助"
						class="helpimg" /></span><a href="#">帮助</a></li>
				<li><a href="#">关于</a></li>
				<li><a class="logout" href="<%=basePath%>"
					target="_parent">退出</a></li>
			</ul>

		</div>
	</div>
</body>
</html>
