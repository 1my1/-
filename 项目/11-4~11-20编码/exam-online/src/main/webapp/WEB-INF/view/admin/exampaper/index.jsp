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
		<script src="js/ajaxForm.js"></script>
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
								<li class="active"><a href="admin/question/index">录入试题</a></li>
							</ul>
						</li>
						<li class="active"><a href="admin/testQuestion/index" class="icon-shopping-cart"> 试卷</a>
						    <ul>
								<li class="active"><a href="admin/testQuestion/index">创建试卷</a></li>
							</ul>
						</li>
						<li><a href="admin/exam/index" class="icon-user"> 考试</a>
						    <ul>
								<li><a href="#">发布考试</a></li>
							</ul>
						</li>
						<li><a href="admin/user/index" class="icon-user"> 用户</a>
						    <ul>
								<li><a href="#">教师管理</a></li>
								<li><a href="#">学生管理</a></li>
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
					<div class="panel-head"><strong>试卷列表</strong></div>
					<div class="padding border-bottom">
					<form method="post" action="index">
					<table>
					<tr>
					<td class="my_td">试卷名称:<input type="text" name="tqname" class="my_input">  </td>
                    <td class="my_td"><input type="submit" class="button bg-sub" value="检索"></td>
					</tr>
					</table>
					</form>
					</div>
					<div class="padding border-bottom">
						<input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选" />
						<input type="button" id="create_testQuestion" class="button button-small border-green" value="创建试卷" />
						<input type="button" class="button button-small border-yellow" value="批量删除" />
						<input type="button" class="button button-small border-blue" value="回收站" />
						
				    </div>
					<table class="table table-hover">
						<tr>
							<th width="45">选择</th>
							<th width="30">id</th>
							<th width="120">试卷名称</th>
							<th width="100">操作</th>
						</tr>
						<c:forEach items="${pi.lists}" var="tq">
						<tr>
							<td>
								<input type="checkbox" name="id" value="1"/>
							</td>
							<td>${tq.tqid}</td>
							<td>${tq.tqname}</td>
							<td><a class="button border-yellow button-little" style="cursor:pointer;" onclick="doDelete(${tq.tqid})">删除</a></td>
						</tr>
						</c:forEach>
					</table>
					<div class="panel-foot text-center">
					<ul class="pagination">
						<li style="border: 0;">
									<a>共计：${pi.pc.pagecount}页/${pi.pc.rscount}条记录</a>
								</li>
	
								<li>
									<c:if test="${pi.pc.currentindex==1}" var="fp">
										<a style="disabled: true">上一页</a>
									</c:if>
									<c:if test="${!fp}">
										<a
											href="admin/testQuestion/index?currindex=${pi.pc.currentindex-1}
											<c:if test='${testQuestionname!=null}'>
											   &titname=${testQuestionname.tqname}
											   </c:if>
											">上一页</a>
									</c:if>
								</li>
	
								<c:forEach begin="${pi.pc.minpage}" step="1"
									end="${pi.pc.maxpage}" var="index">
									<li>
										<c:if test="${pi.pc.currentindex==index}" var="t">
											<a style="color: red; background-color: #bbb">${index}</a>
										</c:if>
										<c:if test="${!t}">
											<a href="admin/testQuestion/index?currindex=${index}
											   <c:if test='${testQuestionname!=null}'>
											   &titname=${testQuestionname.tqname}
											   </c:if>
											">${index}</a>
										</c:if>
									</li>
								</c:forEach>
								<li>
									<c:if
										test="${pi.pc.currentindex==pi.pc.pagecount}"
										var="fp">
										<a style="disabled: true">下一页</a>
									</c:if>
									<c:if test="${!fp}">
										<a
											href="admin/testQuestion/index?currindex=${pi.pc.currentindex+1}
											<c:if test='${testQuestionname!=null}'>
											   &titname=${testQuestionname.tqname}
											   </c:if>
											">下一页</a>
									</c:if>
								</li>
					</ul>

				</div>
				</div>
			</form>
			<br />
			<p class="text-right text-gray">基于<a class="text-gray" target="_blank" href="http://www.pintuer.com">拼图前端框架</a>构建</p>
		</div>
		
		<!-- 添加 -->
		<div id="testQuestion_form" class="hidden" style="padding:20px;">
		<form id="testQuestion_add_form" method="post" action="admin/testQuestion/doAdd">
			<div class="form-group">
				<div class="label">
					<label>试卷名称</label>
				</div>
				<div class="field">
					<input type="text" class="input" name="tqname" maxlength="50"
						value="" data-validate="required:请填写内容" placeholder="请填写试卷名称">
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>试卷类型</label>
				</div>
				<div class="field">
					<select class="" id="couid" name="couid" data-validate="required:请选择,length#>=1:至少选择1项">
                            <c:forEach items="${courseLists}" var="course">
								<option value="${course.couid}">${course.couname}</option>
							</c:forEach>
                    </select>
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>及格分数</label>
				</div>
				<div class="field">
					<input type="text" class="input" name="tqscore" maxlength="50"
						value=""
						data-validate="required:请填写数字,plusinteger:请输入不含0和负数的数字,length#<5:字数在5个"
						placeholder="请填写及格分数">
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>时长（分钟）</label>
				</div>
				<div class="field">
					<input type="text" class="input" name="duration" maxlength="50"
						value="" data-validate="required:请填写内容" placeholder="请填写时长">
				</div>
			</div>
			<div class="form-group">
				<input class="button bg-red" type="submit" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="button bg-yellow form-reset" type="reset">重设</button>
			</div>
		</form>
		</div>
		
		<div class="hidden">
			
			<script src="js/layer.js"></script>
		<script>
		
		//添加弹出层
		$("#create_testQuestion").on('click', function(){
			layer.open({
                type: 1,
                title: "创建试卷",
                area: ['500px', '500px'],
                skin: 'layui-layer-rim', //加上边框
                content: $('#testQuestion_form'),
                success: function(){
                	$('#testQuestion_form').removeClass("hidden");
                },
                cancel: function(index){
                	$('#testQuestion_form').addClass("hidden");
                	layer.closeAll();
                }
            });
		});
		
		//调用
	    $(document).ready(function(){
			$('#testQuestion_add_form').bind('submit', function(){
				ajaxSubmit(this, function(data){
					alert(data.message);
					window.location.href="admin/testQuestion/update?tqid="+data.tqid;
				});
				return false;
			});
	    });
			function doDelete(id1){
				if(confirm('确认删除?')){
							$.ajax({
						        url: "admin/testQuestion/doDelete",
						        type: "post",
						        data: {id:id1},
						        success: function(data){
						        	alert(data.message);
						        	window.location.href="admin/testQuestion/index";
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