<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<base href="<%=basePath%>">
		
		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8"><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>ExamStack</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<link rel="shortcut icon" href="<%=basePath%>resources/images/favicon.ico" />
		<link href="resources/bootstrap/css/bootstrap-huan.css" rel="stylesheet">
		<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
		<link href="resources/css/exam.css" rel="stylesheet" type="text/css">
		<link href="resources/css/style.css" rel="stylesheet">
		<style type="text/css">
			input[type="radio"]{
				font-size:100px;
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
								
								<a href="student/usercenter" id="system-info-account" target="_blank">${sessionScope.student.stuname}</a>
								<span>|</span>
								<a href="student/logout"><i class="fa fa-sign-out"></i> 退出</a>
							</div>
						</c:when>
						<c:otherwise>
							<!-- <a class="btn btn-primary" href="register">用户注册</a> -->
							<a class="btn btn-success" href="student/login">登录</a>
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
							<a href="student/exam"><i class="fa  fa-paper-plane-o"></i>在线考试${sessionScope.student.stuid}</a>
						</li>
						<li>
							<a href="student/usercenter"><i class="fa fa-cogs"></i>个人中心</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>

		<!-- Navigation bar ends -->

		<div class="content" style="margin-bottom: 100px;">

			<div class="container">
				<div class="row">
					<div class="col-xs-2" style="padding-right: 0px;padding-bottom:15px;">
						<div class="def-bk" id="bk-exam-control">

							<div class="def-bk-content" id="exam-control">

								<div id="question-time" class="question-time-normal">
									<div style="height:140px;text-align: center;">
										<i id="time-icon" class="fa fa-clock-o"> </i>
									</div>

									<span style="margin-right:10px;color: #B8B8B8;">已用时</span>
									<span id="exam-clock">&nbsp;</span>
									<span id="exam-timestamp" style="display:none;">${duration}</span>
									<div id="answer-save-info"></div>

								</div>
								<div id="question-submit">
									<button class="btn-success btn" style="width:100%;">
										我要交卷
									</button>
								</div>
								<div id="exam-info" style="display:none;">
									<span id="answer-hashcode"></span>
								</div>
							</div>

						</div>

					</div>
					<div class="col-xs-10" style="padding-right: 0px;">
						<div class="def-bk" id="bk-exampaper">

							<div class="expand-bk-content" id="bk-conent-exampaper">
								<div id="exampaper-header">
									<div id="exampaper-title">
										<i class="fa fa-send"></i>
										<span id="exampaper-title-name"> 模拟试卷${examstarttime } </span>
										<span style="display:none;" id="exampaper-id">1</span>
									</div>
									<div id="exampaper-desc-container">
										<div id="exampaper-desc" class="exampaper-filter">
										
										</div>
									</div>
									
								</div>
								<input type="hidden" id="start-time" value="<fmt:formatDate value='${examstarttime}' pattern='yyyy-MM-dd HH:mm:ss'/>">
								<!--<input type="hidden" id="hist-id" value="${examHistoryId }">-->
								<input type="hidden" id="paper-id" value="${examPaperId }">
								<input type="hidden" id="exam-id" value="${examId }">
								<input type="hidden" id="duration" value="${duration}">
								<input type="hidden" id="stu-id" value="${sessionScope.student.stuid}">
								<ul id="exampaper-body">
								<c:forEach items="${questionList}" var="item">
								<li style="display: list-item;" class="question qt-singlechoice"><div
										class="question-title">
										<div class="question-title-icon"></div>
										<span class="question-no">1.</span><span class="question-type"
											style="display: none;">singlechoice</span><span
											class="knowledge-point-id" style="display: none;">0</span><span
											class="question-type-id" style="display: none;">1</span><span>[单选题]</span><span
											class="question-point-content"><span>(</span><span
											class="question-point">${item.titscore}</span><span>分)</span></span><span
											class="question-id" style="display: none;">10</span><span
											class="question-mark" title="Marked as uncertain"><i
											class="fa fa-bookmark-o"></i></span>
									</div>
									<form class="question-body">
										<p class="question-body-text">${item.titname}</p>
										<ul class="question-opt-list">
										  <c:if test="${item.titA!=''}">
											<li class="question-list-item"><input value="A"
												name="question-radio1" class="question-input" type="radio">A:
												${item.titA}</li>
										  </c:if>
										  <c:if test="${item.titB!=''}">
											<li class="question-list-item"><input value="B"
												name="question-radio1" class="question-input" type="radio">B:
												${item.titB}</li>
										  </c:if>
										  <c:if test="${item.titC!=''}">
											<li class="question-list-item"><input value="C"
												name="question-radio1" class="question-input" type="radio">C:
												${item.titC}</li>
										  </c:if>
										  <c:if test="${item.titD!=''}">
											<li class="question-list-item"><input value="D"
												name="question-radio1" class="question-input" type="radio">D:
												${item.titD}</li>
										  </c:if>
										  <c:if test="${item.titE!=''}">
											<li class="question-list-item"><input value="E"
												name="question-radio1" class="question-input" type="radio">E:
												${item.titE}</li>
										  </c:if>
										  <c:if test="${item.titF!=''}">
											<li class="question-list-item"><input value="F"
												name="question-radio1" class="question-input" type="radio">F:
												${item.titF}</li>
										  </c:if>
										</ul>
									</form></li>
									</c:forEach>
							</ul>
								<div id="exampaper-footer">
									<div id="question-navi">
										<div id="question-navi-controller">
											<i class="fa fa-arrow-circle-down"></i>
											<span>答题卡</span>
										</div>
										<div id="question-navi-content">
										</div>
									</div>

								</div>
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
		<script type="text/javascript" src="resources/js/all.js?v=0712"></script>
		<script type="text/javascript" src="resources/js/paper-examing.js"></script>

		

	</body>
</html>
