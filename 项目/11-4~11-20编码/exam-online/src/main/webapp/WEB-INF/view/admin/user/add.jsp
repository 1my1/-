<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <form id="user_add_form" method="post" action="admin/user/doAdd">
                    <div class="form-group"><div class="label">
                    <label>用户名</label>
                    </div>
                    <div class="field">
                    <input type="text" class="input" name="adname" maxlength="50" value="" data-validate="required:请填写内容" placeholder="请填写用户名">
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label>角色名称</label>
                    </div>
                    <div class="field">
                           
                            <select name="role.roleid">
                               <c:forEach items="${roleLists}" var="role">
                                 <option value="">请选择...</option>
                                 <option value="${role.roleid}">${role.rolename}</option>
                               </c:forEach>
                            </select>
                            </div>
                            </div>
                    <div class="form-group"><div class="label">
                    <label>密码</label>
                    </div>
                    <div class="field">
                    <input type="password" class="input" name="adpass" maxlength="50" value="" data-validate="required:请填写密码" placeholder="请填写密码">
                    </div>
                    </div>
                     <div class="form-group">
                    <input class="button bg-red" type="submit" value="确认">&nbsp;&nbsp;&nbsp;&nbsp;<button class="button bg-yellow form-reset" type="reset">重设</button>
                    </div>
                    </form>