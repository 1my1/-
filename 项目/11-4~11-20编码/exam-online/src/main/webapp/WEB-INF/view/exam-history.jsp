<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- <%@taglib uri="spring.tld" prefix="spring"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    	<base href="<%=basePath%>">
    
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8"><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>用户中心</title>
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="keywords" content="">
		<link rel="shortcut icon" href="<%=basePath%>resources/images/favicon.ico" />
		<link href="resources/bootstrap/css/bootstrap-huan.css" rel="stylesheet">
		<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/css/style.css" rel="stylesheet">
		
		<link href="resources/css/exam.css" rel="stylesheet">
		<link href="resources/chart/morris.css" rel="stylesheet">
		<!--[if lte IE 8]>
			<script type="text/javascript" src="resources/chartjs/excanvas.js"></script>
		<![endif]-->
		<style>
			.table-striped a{
				text-decoration: underline;
			}
			
			.span-success{
				color:#5cb85c;
				font-weight:bolder;
			}
			
			.span-danger{
				color:#d9534f;
				font-weight:bolder;
			}
			
			.span-info{
				color:#5bc0de;
				font-weight:bolder;
			}
			
			h6{
				font-weight:bold !important; 
			}
			
			.radar-legend li span {
				display: block;
				position: absolute;
				left: 0;
				top: 0;
				width: 20px;
				height: 100%;
				border-radius: 5px;
			}
			
			.radar-legend li {
				display: block;
				padding-left: 30px;
				position: relative;
				margin-bottom: 4px;
				border-radius: 5px;
				padding: 2px 8px 2px 28px;
				font-size: 14px;
				cursor: default;
				-webkit-transition: background-color 200ms ease-in-out;
				-moz-transition: background-color 200ms ease-in-out;
				-o-transition: background-color 200ms ease-in-out;
				transition: background-color 200ms ease-in-out;
			}				
			
			#field-switch{
				margin:15px 0 10px 0px;;
				height:34px;
				width:200px;
			}
		</style>
	</head>
	<body>
		<header>
			<div class="container">
				<div class="row">
					<div class="col-xs-5">
						<div class="logo">
							<h1><a href="#"><img alt="" src="resources/images/logo.png"></a></h1>
						</div>
					</div>
					<div class="col-xs-7" id="login-info">
						<c:choose>
							<c:when test="${not empty sessionScope.student.stuname}">
								<div id="login-info-user">
									
									<a href="usercenter" id="system-info-account" target="_blank">${sessionScope.student.stuname}</a>
									<span>|</span>
									<a href="logout"><i class="fa fa-sign-out"></i> 退出</a>
								</div>
							</c:when>
							<c:otherwise>
								<!-- <a class="btn btn-primary" href="register">用户注册</a> -->
								<a class="btn btn-success" href="login">登录</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</header>
		<!-- Navigation bar starts -->

		<div class="navbar bs-docs-nav" role="banner">
			<div class="container">
				<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
					<ul class="nav navbar-nav">
						<li>
							<a href="student/home"><i class="fa fa-home"></i>主页</a>
						</li>
						<!-- <li>
							<a href="practice-list"><i class="fa fa-edit"></i>试题练习</a>
						</li> -->
						<li>
							<a href="student/exam"><i class="fa  fa-paper-plane-o"></i>在线考试</a>
						</li>
						<li class="active">
							<a href="student/usercenter"><i class="fa fa-cogs"></i>个人中心</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>

		<!-- Navigation bar ends -->

		<!-- Slider starts -->

		<div>
			<!-- Slider (Flex Slider) -->

			<div class="container" style="min-height:500px;">

				<div class="row">
					<div class="col-xs-2">
						<ul class="nav default-sidenav">
							<li>
								<a> <i class="fa fa-dashboard"></i> 用户中心 </a>
							</li>
							<li  class="active">
								<a href="student/exam-history"> <i class="fa fa-history"></i> 考试历史 </a>
							</li>
							
						</ul>
					</div>
					<div class="col-xs-10">
						<div class="page-header">
							<h1><i class="fa fa-dashboard"></i>历史试卷</h1>
						</div>
						<div class="page-content row">
							<div class="col-xs-4">
								<h6>试卷信息</h6>
								<c:forEach items="${efList}" var="ef">
								<div>
									<span >试卷ID：</span>
									<span> ${ef.examid}</span>
								</div>
								<div>
									<span >试卷名称：</span>
									<span> ${ef.examname}</span>
								</div>
								<div>
									<span >参考人姓名：</span>
									<span> ${ef.stuname} </span>
								</div>
								<hr width=300 size=1 color=#00ffff align=center noshade>
								</c:forEach>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<footer>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="copy">
							<p>
								ExamStack Copyright © <a href="http://www.examstack.com/" target="_blank">ExamStack</a> - <a href="." target="_blank">主页</a> | <a href="http://www.examstack.com/" target="_blank">关于我们</a> | <a href="http://www.examstack.com/" target="_blank">FAQ</a> | <a href="http://www.examstack.com/" target="_blank">联系我们</a>
							</p>
						</div>
					</div>
				</div>

			</div>

		</footer>

		<!-- Slider Ends -->

		<!-- Javascript files -->
		<!-- jQuery -->
		<script type="text/javascript" src="resources/js/jquery/jquery-1.9.0.min.js"></script>
		
		<!-- Bootstrap JS -->
		<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>