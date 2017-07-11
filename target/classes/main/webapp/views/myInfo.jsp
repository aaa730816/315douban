<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 2017/6/30
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <table class="table table-hover">
        <tr>
            <td>头像:</td>
            <td><img id="changeUserIcon" src="/user/getUserIcon?image=${sessionScope.currentUser.image}" class="img-circle"></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><c:out value="${sessionScope.currentUser.username}"></c:out></td>
        </tr>
        <tr>
            <td>注册时间:</td>
            <td><c:out value="${sessionScope.currentUser.registerDate}"></c:out></td>
        </tr>
    </table>
    <!--更换头像Modal-->
    <div class="modal fade" id="changeIconModal" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">更换头像</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="post" action="/user/changeUserIcon" role="form" enctype="multipart/form-data" id="changeUserIconForm">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">头像</label>
                            <div class="col-sm-6">
                                <input type="file" class="form-control" name="image">
                            </div>
                        </div>
                        <input type="hidden" name="username" value="${sessionScope.currentUser.username}">
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button class="btn btn-primary" id="changeUerIconBtn">更换</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 更换头像成功提示框 -->
    <div class="modal fade" id="changeStatusModal" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <span id="changeHint">提示</span>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" id="back"></button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
