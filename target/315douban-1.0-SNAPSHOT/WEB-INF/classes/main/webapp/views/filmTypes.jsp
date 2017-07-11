<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 2017/7/3
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <head>
        <link href="${pageContext.request.contextPath}/css/filmType.css?ver=0.0.2" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet"
              type="text/css"/>
        <script src="${pageContext.request.contextPath}/js/jQuery/jquery-3.2.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery/jquery.form.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#filmTypesBody").width((($(window).width()-600)/4)*3);
                $(".typeA").click(function () {
                    $("#content").load(this.href);
                    return false;
                })

            })
        </script>
    </head>
<body>
<div id="filmTypesTitle">类别:</div>
<div id="filmTypesBody">
    <c:forEach var="type" items="${requestScope.filmTypes}">
        <span class="label label-info" style="font-size: 18px;font-family: 'Microsoft YaHei UI Light';margin-right: 10px;display: block;float: left;margin-bottom: 20px">
            <a class="typeA" href="/film/toFilmsOfTypePage?type=${type}">${type}</a>
        </span>
    </c:forEach>
</div>
</body>
</html>
