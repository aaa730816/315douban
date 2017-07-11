<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 2017/7/1
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/userInfo.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery.form.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/userInfo.js"></script>
</head>
<body>
<form action="/user/changePassword" id="changePassForm" method="post" class="form-horizontal" role="form">
    <div class="form-group">
        <label class="col-sm-2 control-label">原密码:</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" id="oriPass">
        </div>
        <div class="col-sm-4">
            <span id="changePassHint"></span>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">新密码:</label>
        <div class="col-sm-6">
            <input type="password" name="newPass" id="newPass" class="form-control">
        </div>

    </div>
</form>
    <div id="changeBtnDiv">
        <button class="btn btn-primary" id="changePassBtn" >提交</button>
    </div>
<!-- 更改密码成功提示框 -->
<div class="modal fade" id="changePassStatusModal" role="dialog" aria-hidden="true">
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
