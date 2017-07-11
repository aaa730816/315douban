<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 2017/7/1
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/userInfo.css?ver=0.0.3" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery.form.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/userInfo.js?ver=0.0.3"></script>
</head>
<body>
<div id="addFriTitle">
<span id="title">我的好友</span>
</div>
<button class="btn btn-default" id="addFriendsBtn">添加好友</button>
<br>
<br>
<br>
<table class="table table-hover">
        <tr>
            <th style="text-align: center">头像</th>
            <th style="text-align: center">用户名</th>
            <th style="text-align: center">操作</th>
        </tr>
    <c:forEach var="friend" items="${requestScope.friends}">
        <tr>
            <td>
                <img class="friImg" src="/user/getUserIcon?image=${friend.image}">
            </td>
            <td>
                <span class="friSpan"><c:out value="${friend.username}"></c:out></span>
            </td>
            <td><button name="${friend.username}" class="btn btn-primary delFri">删除</button> </td>
        </tr>
    </c:forEach>
</table>
<!-- 添加好友Modal -->
<div class="modal fade" id="addFriendModal" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">添加好友</h4>
            </div>
            <div class="modal-body">
                <div id="searchFriDiv">
                    <div class="col-sm-6">
                    <input type="text" class="form-control" id="searchFriWord">
                    </div>
                    <div class="col-sm-2">
                    <button class="btn btn-primary" id="searchFriBtn">搜索</button>
                    </div>
                </div>
                <br>
                <br>
                <br>
                <br>
                    <table  class="table table-hover">
                        <tbody id="searchFriTable">

                        </tbody>
                    </table>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- 好友操作Modal -->
<div class="modal fade" id="friStatusModal" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 id="friModalTitle" class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <span id="friStatusHint">提示</span>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" data-dismiss="modal">返回</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
