<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 2017/7/3
  Time: 14:49
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
        <script src="${pageContext.request.contextPath}/js/filmType.js?ver=0.0.2"></script>
    </head>
<body>
<div id="typeName" content="${requestScope.typeName}">${requestScope.typeName}:</div>
<div id="filmsOFType">

</div>
</body>
</html>
