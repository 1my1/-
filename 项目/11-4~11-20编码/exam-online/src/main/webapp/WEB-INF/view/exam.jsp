<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>ExamStack</title>
		<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="keywords" content="">
		<link href="resources/bootstrap/css/bootstrap-huan.css"
		rel="stylesheet">
		<link href="resources/font-awesome/css/font-awesome.min.css"
		rel="stylesheet">
		<link href="resources/css/style.css" rel="stylesheet">
		<style>
			.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
				padding: 8px 0;
				line-height: 1.42857143;
				vertical-align: middle;
				border-top: 1px solid #ddd;
			}

			a.join-practice-btn {
				margin-top: 0;
			}
		</style>
        <script type="text/javascript">
            
        </script>
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
								<a class="btn btn-primary" href="register">用户注册</a>
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
						<li class="active">
							<a href="student/exam"><i class="fa  fa-paper-plane-o"></i>在线考试</a>
						</li>
						<li>
							<a href="student/usercenter"><i class="fa fa-cogs"></i>个人中心</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>

		<!-- Navigation bar ends -->

		<!-- Slider starts -->
		<div class="content" style="margin-bottom: 100px;">

			<div class="container" style="margin-top: 40px;">
				
				<div class="row">
					<div class="col-xs-6">
						<div style="border-bottom: 1px solid #ddd;">
							<h3 class="title"><i class="fa fa-paper-plane-o"></i>我的考试</h3>
							
						</div>
						<div class="question-list">

							<table class="table-striped table">
								<thead>
									
									<tr>
										<td>考试名称</td><td>开始日期</td><td>截止日期</td><td></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${examLists}" var="item">
										<tr>
											<td>${item.examname}</td>
											<td><span class="span-info question-number"><fmt:formatDate value="${item.examstarttime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
											<td><span class="span-success question-number-2" id="${item.examname}"><fmt:formatDate value="${item.examstoptime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
											<jsp:useBean id="now" class="java.util.Date" /> 
											<c:if test="${item.examstarttime <now and item.examstoptime>now}">
											<td>
											<a href="student/examing/${item.examid}" id="${item.examid}" class="btn btn-success btn-sm join-practice-btn">正在考试</a>		
											</td>
											</c:if>
											<c:if test="${item.examstarttime > now}">
											<td>
											<a href="student/examing/${item.examid}" id="${item.examid}" class="btn btn-success btn-sm join-practice-btn">参与考试</a>		
											</td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot></tfoot>
							</table>

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
		<script type="text/javascript"
		src="resources/js/jquery/jquery-1.9.0.min.js"></script>
		<!-- Bootstrap JS -->
		<script type="text/javascript"
		src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$(".apply-exam-btn").click(function(){
					var examId = $(this).data("id");
					
					jQuery.ajax({
						headers : {
							'Accept' : 'application/json',
							'Content-Type' : 'application/json'
						},
						type : "GET",
						url : "student/exam/send-apply/" + examId,
						success : function(message, tst, jqXHR) {
							if (message.result == "success") {
								window.location.reload();
							} else {
								alert(message.result);
							}
						}
					});
				});
			});
			$(document).ready(function(){
				var obj=new Object();
            	var obj=jQuery.parseJSON('${examLists}');
            	//var obj={"name":"123"};
            	//var JsonObj=JSON.parse(obj);
            	alert(list.length);
            	
            });
		</script>
		<script>
			$(function() {
				bindQuestionKnowledage();
				var result = checkBrowser();
				if (!result) {
					alert("请至少更新浏览器版本至IE8或以上版本");
				}
			});

			function checkBrowser() {
				var browser = navigator.appName;
				var b_version = navigator.appVersion;
				var version = b_version.split(";");
				var trim_Version = version[1].replace(/[ ]/g, "");
				if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE7.0") {
					return false;
				} else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE6.0") {
					return false;
				} else
					return true;
			}

			function bindQuestionKnowledage() {
				$(".knowledge-title").click(function() {
					var ul = $(this).parent().find(".question-list-knowledge");

					if (ul.is(":visible")) {
						$(this).find(".fa-chevron-down").hide();
						$(this).find(".fa-chevron-up").show();

						$(".question-list-knowledge").slideUp();

					} else {
						$(".fa-chevron-down").hide();
						$(".fa-chevron-up").show();

						$(this).find(".fa-chevron-up").hide();
						$(this).find(".fa-chevron-down").show();

						$(".question-list-knowledge").slideUp();
						ul.slideDown();

					}

				});
			}
		</script>
		<script type="text/javascript">
			var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cspan id='cnzz_stat_icon_1252987997'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s19.cnzz.com/z_stat.php%3Fid%3D1252987997' type='text/javascript'%3E%3C/script%3E"));
		</script>
	</body>
</html>
