<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
	<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>在线题库系统-后台管理</title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="stylesheet" href="css/layer.css">
		<link rel="stylesheet" href="css/layer.ext.css">
		<script src="js/jquery.js"></script>
		<script src="js/ajaxForm.js"></script>
		<script src="js/pintuer.js"></script>
		<script src="js/admin.js"></script>
		<link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
		<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
		<style>
		.nodisplay{display:none;}
		</style>
	</head>

	<body>
		<div class="lefter">
			<div class="logo">
				<a href="http://www.pintuer.com" target="_blank"><img src="images/logo.png" alt="后台管理系统" /></a>
			</div>
		</div>
		<div class="righter nav-navicon" id="admin-nav">
			<div class="mainer">
				<div class="admin-navbar">
					<span class="float-right">
                    <a class="button button-little bg-main" href="http://www.pintuer.com" target="_blank">前台首页</a>
                    <a class="button button-little bg-yellow" href="login.html">注销登录</a>
                </span>
					<ul class="nav nav-inline admin-nav">
						<li>
							<a href="admin/index" class="icon-home"> 开始</a>
							<ul>
								<li><a href="system.html">系统设置</a></li>
								<li><a href="admin/question/index">试题管理</a></li>
								<li><a href="admin/testQuestion/index">试卷管理</a></li>
								<li><a href="admin/exam/index">考试管理</a></li>
								<li><a href="admin/user/index">用户管理</a></li>
								<li><a href="#">统计管理</a></li>
							</ul>
						</li>
						<li>
							<a href="system.html" class="icon-cog"> 系统</a>
							<ul>
								<li><a href="#">系统公告</a></li>
								<li class="active"><a href="#">登录日志</a></li>
								<li><a href="#">管理员列表</a></li>
							</ul>
						</li>
						<li>
							<a href="admin/question/index" class="icon-file-text"> 试题</a>
							<ul>
								<li><a href="#">录入试题</a></li>
							</ul>
						</li>
						<li><a href="admin/testQuestion/index" class="icon-shopping-cart"> 试卷</a>
						    <ul>
								<li class="active"><a href="#">创建试卷</a></li>
							</ul>
						</li>
						<li><a href="admin/exam/index" class="icon-user"> 考试</a>
						    <ul>
								<li><a href="#">发布考试</a></li>
							</ul>
						</li>
						<li class="active"><a href="admin/user/index" class="icon-user">用户</a>
						    <ul>
						        <li class="active"><a href="admin/user/index">用户管理</a></li>
								<li><a href="#">教师管理</a></li>
								<li><a href="#">学生管理</a></li>
								<li><a href="admin/classes/index">班级管理</a>
								<li><a href="admin/dept/idnex">专业管理</a>
							</ul>
						</li>
						<li><a href="#" class="icon-user"> 统计</a>
						    <ul>
								<li><a href="#">统计图表</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="admin-bread">
					<span>您好，admin，欢迎您的光临。</span>
					<ul class="bread">
						<li><a href="index.html" class="icon-home"> 开始</a></li>
						<li>后台首页</li>
					</ul>
				</div>
			</div>
		</div>
<div class="admin">
     <form id="user_update_form" method="post" action="admin/user/doUpdate">
                    <input type="hidden" name="adid" value="${updateAdmin.adid}">
                    <div class="form-group"><div class="label">
                    <label>用户名</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="adname" maxlength="50" value="${updateAdmin.adname}" data-validate="required:请填写内容" placeholder="请填写用户名">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label>角色名称</label>
                    </div>
                    <div class="field">
                           
                            <select name="role.roleid">
                               <option value="">请选择...</option>
                               <c:forEach items="${updateRoleLists}" var="role">
                                 <option value="${role.roleid}"
                                    <c:if test='${role.roleid==updateAdmin.role.roleid}'>selected</c:if>
                                 >${role.rolename}</option>
                               </c:forEach>
                            </select>
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label>密码</label>
                    </div>
                    <div class="field">
                    <input type="password" class="input" name="adpass" maxlength="50" value="${updateAdmin.adpass}" data-validate="required:请填写密码" placeholder="请填写密码">
                    </div>
                    </div>
                     <div class="form-group">
                    <input class="button bg-red" type="submit" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;<button class="button bg-yellow form-reset" type="reset">重设</button>
                    </div>
                    </form>
                    </div>
<div class="hidden">
			<script>
			//调用
		    $(document).ready(function(){
				$('#user_update_form').bind('submit', function(){
					ajaxSubmit(this, function(data){
						alert(data.message);
						window.location.href="admin/user/index";
					});
					return false;
				});
		    });
		  //将form转为AJAX提交
			function ajaxSubmit(frm, fn) {
			    var dataPara = getFormJson(frm);
			    $.ajax({
			        url: frm.action,
			        type: frm.method,
			        data: dataPara,
			        success: fn
			    });
			}
			//将form中的值转换为键值对。
			function getFormJson(frm) {
			    var o = {};
			    var a = $(frm).serializeArray();
			    $.each(a, function () {
			        if (o[this.name] !== undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            o[this.name].push(this.value || '');
			        } else {
			            o[this.name] = this.value || '';
			        }
			    });

			    return o;
			}
			</script>
		</div>
	</body>

</html>