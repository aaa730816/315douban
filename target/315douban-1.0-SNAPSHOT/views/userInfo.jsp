<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 2017/6/30
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/userInfo.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery.form.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/userInfo.js"></script>
</head>
<body>
<div id="listGroup">
<a href="#" class="list-group-item active">用户信息</a>
<a href="/views/myInfo.jsp" class="list-group-item clickA">用户资料</a>
<a href="/views/changePassword.jsp" class="list-group-item clickA">修改密码</a>
<a href="#" class="list-group-item clickA">我的评论</a>
<a href="#" class="list-group-item clickA">回复我的</a>
<a href="/user/toMyFriendPage" class="list-group-item clickA">我的好友</a>
<a href="#" class="list-group-item clickA">收藏的电影</a>
<a href="#" class="list-group-item clickA">收藏的书籍</a>
<a href="#" class="list-group-item clickA">收藏的音乐</a>
</div>
<div id="infoContent" ></div>
</body>
</html>
