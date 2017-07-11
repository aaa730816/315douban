<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/main.css?ver=0.0.1" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery.form.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js?ver=0.0.1"></script>
</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-default" role="navigation" style="margin-bottom: 0px">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">315豆瓣</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="#">电影</a></li>
                <li><a href="#">图书</a></li>
                <li><a href="#">音乐</a></li>
            </ul>
        </div>
        <div id="loginStatus">
            <c:if test="${sessionScope.currentUser!=null}">
                <div id="loginUser">
                    <a href="/views/userInfo.jsp" id="username"><c:out value="${sessionScope.currentUser.username}"></c:out></a>
                    <button class="btn btn-primary" id="logout">登出
                    </button>
                </div>
            </c:if>
            <c:if test="${sessionScope.currentUser==null}">
                <div id="tourist">
                    <button class="btn btn-primary" id="loginBtn" data-toggle="modal" data-target="#loginModal">登陆
                    </button>
                    <button class="btn btn-primary" id="registerBtn" data-toggle="modal" data-target="#registerModal">注册
                    </button>
                </div>
            </c:if>
        </div>
    </div>
</nav>
<!-- 登陆模态框 -->
<div class="modal fade" id="loginModal" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">登陆</h4>
            </div>
            <div class="modal-body">
                <form id="loginForm" method="post" action="/main/doLogin" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-6">
                            <input type="text" id="loginUsername" class="form-control" name="username"
                                   placeholder="请输入账号...">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" id="loginPassword" class="form-control" name="password"
                                   placeholder="请输入密码...">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">关闭</button>
                <button class="btn btn-primary" id="doLogin">登陆</button>
            </div>
        </div>
    </div>
</div>
<!-- 注册模态框 -->
<div class="modal fade" id="registerModal" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">注册</h4>
            </div>
            <div class="modal-body">
                <form id="registerForm" action="/main/doRegister" method="post" class="form-horizontal" role="form"
                      enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="registerUsername" name="username"
                                   placeholder="请输入账号">
                        </div>
                        <div class="col-sm-4">
                            <span id="userExistHint"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" id="registerPassword" class="form-control" name="password"
                                   placeholder="请输入密码">
                        </div>
                        <div class="col-sm-4">
                            <span id="passwordNotNullHint"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">头像</label>
                        <div class="col-sm-6">
                            <input type="file" class="form-control" name="image">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">验证码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="imageCode" name="imageCode"
                                   placeholder="请输入右边验证码">
                        </div>
                        <img id="code" title="看不清点击刷新验证码" src="/main/getImageCode">
                        <div class="col-sm-3">
                            <span id="imageCodeHint"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">关闭</button>
                <button class="btn btn-primary" id="doRegister">注册</button>
            </div>
        </div>
    </div>
</div>
<!-- 登陆成功提示框 -->
<div class="modal fade" id="loginStatusModal" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <span id="loginHint">提示</span>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" id="backMain"></button>
            </div>
        </div>
    </div>
</div>

<div id="banner">
    <div id="banner-wrap">
        <div id="bannerTitle">
            <span class="titleName">电影</span>
        </div>
        <div id="search">
            <input type="text" class="inp" name="keyword" placeholder="请输入关键词">
            <button class="btn btn-default">搜索</button>
        </div>
    </div>
</div>
<div id="bannerNav">
    <ul id="myTab" class="nav nav-tabs">
        <li class="tab"><a class="tabBtn" href="#">首页</a></li>
        <li class="tab"><a class="tabBtn" href="/film/getAllTypes">分类</a></li>
        <li class="tab"><a class="tabBtn" href="#">排行</a></li>
        <li class="tab"><a class="tabBtn" href="#">热评</a></li>
    </ul>
</div>
<div id="content"></div>
</body>
</html>
