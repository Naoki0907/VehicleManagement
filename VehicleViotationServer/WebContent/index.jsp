<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.sql.*,javax.sql.*" %>
<%@ page import="javax.servlet.*,javax.servlet.http.*" %>
<%@ page import="com.wfeel.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>大象装修</title>
	<script src="js/jquery.js"></script>
	<style type="text/css"> 
		 * { 
			padding: 0px; 
			margin: 0px; 
		 } 
		 body {
		    overflow-x: hidden;  
    	 }
		 a { 
		  	text-decoration: none; 
		  	display:inline-bolck;
		  	color:#551A8B
		 }
		 a:hover {
		 	background:#bbbbbb;
		 } 
		 ul { 
		    list-style: outside none none; 
		 } 
		 .slider, .slider-panel img, .slider-extra { 
		    width: 100%; 
		    height: 413px; 
		    margin-left: 0
		 } 
		 .slider { 
		  text-align: center; 
		  margin: 30px auto; 
		  position: relative; 
		 } 
		 .slider-panel, .slider-nav, .slider-pre, .slider-next { 
		  position: absolute; 
		  z-index: 8; 
		 } 
		 .slider-panel { 
		  position: absolute; 
		 } 
		 .slider-panel img { 
		  border: none; 
		 } 
		 .slider-extra { 
		  position: relative; 
		 } 
		 .slider-nav { 
		  margin-left: -51px; 
		  position: absolute; 
		  left: 50%; 
		  bottom: 4px; 
		 } 
		 .slider-nav li { 
		  background: #3e3e3e; 
		  border-radius: 50%; 
		  color: #fff; 
		  cursor: pointer; 
		  margin: 0 2px; 
		  overflow: hidden; 
		  text-align: center; 
		  display: inline-block; 
		  height: 18px; 
		  line-height: 18px; 
		  width: 18px; 
		 } 
		 .slider-nav .slider-item-selected { 
		  background: blue; 
		 } 
		 .slider-page a{ 
		  background: rgba(0, 0, 0, 0.2); 
		  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#33000000,endColorstr=#33000000); 
		  color: #fff; 
		  text-align: center; 
		  display: block; 
		  font-family: "simsun"; 
		  font-size: 22px; 
		  width: 28px; 
		  height: 62px; 
		  line-height: 62px; 
		  margin-top: -31px; 
		  position: absolute; 
		  top: 50%; 
		 } 
		 .slider-page a:HOVER { 
		  background: rgba(0, 0, 0, 0.4); 
		  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#66000000,endColorstr=#66000000); 
		 } 
		 .slider-next { 
		  left: 100%; 
		  margin-left: -28px; 
		 } 
	</style>
	<script type="text/javascript"> 
		$(document).ready(function() { 
			var length, 
			currentIndex = 0, 
			interval, 
			hasStarted = false, //是否已经开始轮播 
			t = 3000; //轮播时间间隔 
			length = $('.slider-panel').length; 
			//将除了第一张图片隐藏 
			$('.slider-panel:not(:first)').hide(); 
			//将第一个slider-item设为激活状态 
			$('.slider-item:first').addClass('slider-item-selected'); 
			//隐藏向前、向后翻按钮 
			$('.slider-page').hide(); 
			//鼠标上悬时显示向前、向后翻按钮,停止滑动，鼠标离开时隐藏向前、向后翻按钮，开始滑动 
			$('.slider-panel, .slider-pre, .slider-next').hover(function() { 
				stop(); 
				$('.slider-page').show(); 
			}, function() { 
			$('.slider-page').hide(); 
				start(); 
			}); 
			$('.slider-item').hover(function(e) { 
				stop(); 
				var preIndex = $(".slider-item").filter(".slider-item-selected").index(); 
				currentIndex = $(this).index(); 
				play(preIndex, currentIndex); 
				}, function() { 
					start(); 
				}); 
				$('.slider-pre').unbind('click'); 
				$('.slider-pre').bind('click', function() { 
					pre(); 
				}); 
				$('.slider-next').unbind('click'); 
				$('.slider-next').bind('click', function() { 
					next(); 
			}); 
			/** 
			* 向前翻页 
			*/
			function pre() { 
				var preIndex = currentIndex; 
				currentIndex = (--currentIndex + length) % length; 
				play(preIndex, currentIndex); 
			} 
			/** 
			* 向后翻页 
			*/
			function next() { 
				var preIndex = currentIndex; 
				currentIndex = ++currentIndex % length; 
				play(preIndex, currentIndex); 
			} 
			/** 
			* 从preIndex页翻到currentIndex页 
			* preIndex 整数，翻页的起始页 
			* currentIndex 整数，翻到的那页 
			*/
			function play(preIndex, currentIndex) { 
				$('.slider-panel').eq(preIndex).fadeOut(500) 
				.parent().children().eq(currentIndex).fadeIn(1000); 
				$('.slider-item').removeClass('slider-item-selected'); 
				$('.slider-item').eq(currentIndex).addClass('slider-item-selected'); 
			} 
			/** 
			* 开始轮播 
			*/
			function start() { 
				if(!hasStarted) { 
					hasStarted = true; 
					interval = setInterval(next, t);  //间隔3s显示下一张图片 
				} 
			} 
			/** 
			* 停止轮播 
			*/
			function stop() { 
				clearInterval(interval); 
				hasStarted = false; 
			} 
			//开始轮播 
			start(); 
		}); 
	</script> 
  </head>
  
  <body>
    <div id="container">
    
    	<header id="header" style="height:40px; width:100%;">
    		<div id="welcome" style="width:50%; height:100%; float:left">
    			<p style="text-align:center;line-height:40px; margin:auto auto">欢迎来到大象装修</p>
    		</div>
    		<div class="wraper" style="width:50%; height:100%;float:right;";>
    		<nav>
    		<%
					HttpServletRequest httpReq = (HttpServletRequest) request;
					session = httpReq.getSession();
					if ("true".equals(session.getAttribute("isLogin"))) {
						out.println("<font color='red' style='line-height:40px;margin-left:350px;text-decoration:none'>"+((DecorateUser)session.getAttribute("user")).getLoginName() + "</font>,欢迎您！" + "<a  href='/DecorateServer/pages/login.jsp'>重新登录</a>");
					} else {
						out.println("<a style='line-height:40px;margin-left:350px;text-decoration:none' href='/DecorateServer/pages/login.jsp'>登录</a>");
						out.println("<a style='line-height:40px;text-decoration:none' href='/DecorateServer/pages/register.jsp'>注册</a>");
					}
				%>
    			
    			</nav>
    		</div>
    	</header>
    	
    	<div class="line" style="height:1px; background-color:#dddddd; width:100%"></div>
    	
    	<div id="headTitle" style="height:40px; width:100%">
    		<div id="tip" style="width:100%; height:100%; text-align: center; margin:10px auto;">
    			<center>
    			 <marquee behavior="alternate">欢迎来到大象装修，有疑问可以致电我们人工客服：400-129-1653</marquee> 
    			</center>
    		</div>
    	</div>
    	
    	<sql:setDataSource var="total" driver="org.gjt.mm.mysql.Driver"
    		url="jdbc:mysql://localhost:3306/db_decorate"
    		user="root"
    		password="hanzhichu"/>
    		
		<sql:query dataSource="${total}" var="result" sql="SELECT * from totalimg" />

    	<div class="page-wrapper" style="height:400px;width:100%;">
    		   <ul class="slider-main">
    		   <c:forEach var="row" items="${result.rows}">
    		   	 <li class="slider-panel" style="width:100%"> 
			       <a><img src="${row.SaveLocation}"></a> 
			     </li> 
    		   </c:forEach> 
			  </ul> 
			  <div class="slider-extra">
			   <ul class="slider-nav"> 
			    <li class="slider-item">1</li> 
			    <li class="slider-item">2</li> 
			    <li class="slider-item">3</li> 
			    <li class="slider-item">4</li> 
			   </ul> 
			  <div class="slider-page"> 
				    <a class="slider-pre" href="javascript:pre();"></a> 
				    <a class="slider-next" href="javascript:next();"></a> 
			  </div> 
			</div>
    	</div>
    	<div id="footer" style="position:fixed; bottom:0px; background-color:#232323; height:80px; width:100%">
    		<p style="color:white; font-size:22px; line-height:80px; text-align:center">
    		微感觉工作室制作
    		</p>
    	</div>
    </div>
  </body>
</html>
