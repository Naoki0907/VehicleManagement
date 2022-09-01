<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
String path=request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台主页的左侧栏</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
});	
</script>


</head>
<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span></div>
    
    <!-- 后台主页左侧菜单  -->
    <dl class="leftmenu">
        
    <dd>
    <div class="title"><span></span><a href="sysInfo.jsp" target="rightFrame">首页</a>
    </div>
    </dd>
        
    <dd><div class="title"><span></span>用户管理</div>
      <ul class="menuson">
        <li><cite></cite><a href="usermanage.jsp" target="rightFrame">用户列表</a>
        <li><cite></cite><a href="userInfoCheck.jsp" target="rightFrame">注册管理员审核</a>
      </ul>
    </dd>   
    
    <dd><div class="title"><span></span>装修攻略管理</div>
      <ul class="menuson">
        <li><cite></cite><a href="addDecorateStrategy.jsp" target="rightFrame">添加装修攻略</a>
        <li><cite></cite><a href="deleteDecorateStrategy.jsp" target="rightFrame">删除装修攻略</a>
      </ul>
    </dd>  
    <dd><div class="title"><span></span>首页图片管理</div>
      <ul class="menuson">
        <li><cite></cite><a href="addShouyeImg.jsp" target="rightFrame">客户端轮播图片</a>
        <li><cite></cite><a href="addSystemImg.jsp" target="rightFrame">系统轮播图片</a>
      </ul>
    </dd>  
    
     <dd><div class="title"><span></span><a href="billmanage.jsp" target="rightFrame">装修记账管理</a></div>
    </dd>  
    </dl>
    
</body>
</html>
