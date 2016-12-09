<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		<script src="js/pintuer.js"></script>
		<script src="js/admin.js"></script>
		<link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
		<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
		<style>
		.nodisplay{display:none;}
		.my_input{border: solid 1px #ddd;border-radius: 4px;}
		.my_td{width:250px;}
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
							<a href="admin/index" class="icon-home">开始</a>
							<ul>
								<li><a href="system.html">系统设置</a></li>
								<li><a href="admin/question/index">试题管理</a></li>
								<li><a href="admin/exampaper/index">试卷管理</a></li>
								<li><a href="admin/exam/index">考试管理</a></li>
								<li><a href="admin/user/index">用户管理</a></li>
								<li><a href="#">统计管理</a></li>
							</ul>
						</li>
						<li>
							<a href="system.html" class="icon-cog">系统</a>
							<ul>
								<li><a href="#">系统公告</a></li>
								<li class="active"><a href="#">登录日志</a></li>
								<li><a href="#">管理员列表</a></li>
							</ul>
						</li>
						<li>
							<a href="admin/question/index" class="icon-file-text">试题</a>
							<ul>
								<li><a href="#">录入试题</a></li>
							</ul>
						</li>
						<li>
						   <a href="admin/testQuestion/index" class="icon-shopping-cart"> 试卷</a>
						    <ul>
								<li><a href="#">创建试卷</a></li>
							</ul>
						</li>
						<li><a href="admin/exam/index" class="icon-user">考试</a>
						    <ul>
								<li><a href="#">发布考试</a></li>
							</ul>
						</li>
						<li class="active"><a href="admin/user/index" class="icon-user"> 用户</a>
						    <ul>
						        <li><a href="admin/user/index">用户管理</a></li>
								<li><a href="#">教师管理</a></li>
								<li><a href="#">学生管理</a></li>
								<li><a href="admin/classes/index">班级管理</a>
								<li class="active"><a href="admin/dept/index">专业管理</a>
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
					<span>您好，${sessionScope.admin.adname}，欢迎您的光临。</span>
					<ul class="bread">
						<li><a href="index.html" class="icon-home"> 开始</a></li>
						<li>后台首页</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="admin">
			<form>
				<div class="panel admin-panel">
				    <div class="panel-head">${error}</div>
					<div class="panel-head"><strong>班级列表</strong></div>
					<div class="padding border-bottom">
					<form method="post" action="admin/dept/doUpdate">
					<table>
					<tr>
					<td class="my_td">班级名称:<input type="text" name="claname" class="my_input">  </td>
                    <td class="my_td"><input type="submit" class="button bg-sub" value="检索"></td>
					</tr>
					</table>
					</form>
					</div>
					<div class="padding border-bottom">
						<input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选" />
						<input type="button" id="create_dept" class="button button-small border-green" value="创建专业" />
						<input type="button" class="button button-small border-yellow" value="批量删除" />
						<input type="button" class="button button-small border-blue" value="回收站" />
						
				</div>
					<table class="table table-hover">
						<tr>
							<th width="45">选择</th>
							<th width="30">id</th>
							<th width="120">专业名称</th>
							<th width="100">操作</th>
						</tr>
						<c:forEach items="${pi.lists}" var="dept">
						<tr>
							<td>
								<input type="checkbox" name="deptid" value="1" />
							</td>
							<td>${dept.deptid}</td>
							<td>${dept.deptname}</td>
							<td><a class="button border-blue button-little" href="admin/dept/update?id=${dept.deptid}">修改</a> <a class="button border-yellow button-little" style="cursor:pointer;" onclick="doDelete(${dept.deptid})">删除</a></td>
						</tr>
						</c:forEach>
					</table>
				<div class="panel-foot text-center">
					<ul class="pagination">
						<li style="border: 0;"><a>共计：${pi.pc.pagecount}页/${pi.pc.rscount}条记录</a>
						</li>

						<li><c:if test="${pi.pc.currentindex==1}" var="fp">
								<a style="disabled: true">上一页</a>
							</c:if> <c:if test="${!fp}">
								<a
									href="admin/dept/index?currindex=${pi.pc.currentindex-1}
										<c:if test='${deptname!=null}'>
										   &deptname=${deptname.deptname}
										   </c:if>
										">上一页</a>
							</c:if></li>

						<c:forEach begin="${pi.pc.minpage}" step="1"
							end="${pi.pc.maxpage}" var="index">
							<li><c:if test="${pi.pc.currentindex==index}" var="t">
									<a style="color: red; background-color: #bbb">${index}</a>
								</c:if> <c:if test="${!t}">
									<a
										href="admin/dept/index?currindex=${index}
										   <c:if test='${deptname!=null}'>
										   &deptname=${deptname.deptname}
										   </c:if>
										">${index}</a>
								</c:if></li>
						</c:forEach>
						<li><c:if test="${pi.pc.currentindex==pi.pc.pagecount}"
								var="fp">
								<a style="disabled: true">下一页</a>
							</c:if> <c:if test="${!fp}">
								<a
									href="admin/dept/index?currindex=${pi.pc.currentindex+1}
										<c:if test='${deptname!=null}'>
										   &deptname=${deptname.deptname}
										   </c:if>
										">下一页</a>
							</c:if></li>
					</ul>

				</div>
			</div>
			</form>
			<br />
			<p class="text-right text-gray">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</p>
		</div>
		
		
		<!-- 添加 -->
		<div class="hidden" id="dept_form" style="padding: 20px;">
			<%-- <%@ include file="groupadd.jsp" %> --%>
			<form id="dept_add_form" method="get"
				action="admin/dept/doAdd">
				<div class="form-dept">
					<div class="label">
						<label>专业名称</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="deptname" maxlength="50"
							value="" data-validate="required:请填写内容" placeholder="请填写班级名称">
					</div>
				</div>
				<div class="form-dept">
					<input class="button bg-red" type="submit" value="下一步">&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="button bg-yellow form-reset" type="reset">重设</button>
				</div>
			</form>
		</div>

	<div class="hidden">
			
			<script src="js/layer.js"></script>
			<script>
			//添加弹出层
			$("#create_dept").on('click', function(){
				layer.open({
                    type: 1,
                    title: "创建班级",
                    area: ['400px', '400px'],
                    skin: 'layui-layer-rim', //加上边框
                    content: $('#dept_form'),
                    success: function(){
                    	$('#dept_form').removeClass("hidden");
                    },
                    cancel: function(index){
                    	$('#dept_form').addClass("hidden");
                    	layer.closeAll();
                    }
                });
			});
			
			//修改弹出层
			/*$("#update_exam").on('click', function(){
				layer.open({
                    type: 2,
                    area: ['900px', '500px'],
                    skin: 'layui-layer-rim', //加上边框
                    content: 'update.jsp'
                   
                });
			});*/
	
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
			
			//调用
		    /*$(document).ready(function(){
				$('#group_add_form').bind('submit', function(){
					ajaxSubmit(this, function(data){
						alert(data.message);
						window.location.href="user/groupupdate";
					});
					return false;
				});
		    });*/
			
			function doDelete(id1){
				if(confirm('确认删除?')){
							$.ajax({
						        url: "admin/dept/doDelete",
						        type: "post",
						        data: {"deptid":id1},
						        success: function(data){
						        	alert(data.message);
						        	window.location.href="admin/dept/index";
						        }
						    });
					return true;
					}
				return false;
			}
			</script>
		</div>
	</body>

</html>