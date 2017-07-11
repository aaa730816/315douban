<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 2017/7/4
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/filmInfo.css?ver=0.0.1" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jQuery/jquery.form.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/filmInfo.js?ver=0.0.6"></script>
</head>
<body>
<c:set var="film" value="${requestScope.film}"></c:set>
<div id="filmInfoDiv">
    <div id="filmImg"><img src="${film.filmImg}"></div>
    <div id="filmInfo">
        <table>
            <tr>
                <td>片名:</td>
                <td>${film.filmName}</td>
                <input type="hidden" id="filmName" value="${film.filmName}">
            </tr>
            <tr>
                <td>导演:</td>
                <td>${film.filmDirec}</td>
            </tr>
            <tr>
                <td>编剧:</td>
                <td>${film.filmWri}</td>
            </tr>
            <tr>
                <td>地区:</td>
                <td>${film.filmArea}</td>
            </tr>
            <tr>
                <td>类型:</td>
                <td>${film.filmType}</td>
            </tr>
            <tr>
                <td>语言:</td>
                <td>${film.filmLang}</td>
            </tr>
            <tr>
                <td>上映日期:</td>
                <td>${film.filmDate}</td>
            </tr>
            <tr>
                <td>时长:</td>
                <td>${film.filmLen}</td>
            </tr>
        </table>
    </div>
    <div id="filmScore">
        <div id="filmSc">
            <div id="curFilmScore">
                <c:if test="${film.filmSc==null}">
                    <span style="margin-top: 40%;font-size: 24px">暂无用户打分</span>
                </c:if>
                <c:if test="${film.filmSc!=null}">
                    <span style="font-size: 48px;color: #1b6d85"> ${film.filmSc}</span>
                </c:if>
            </div>
            <div id="userScoreFilm">
                <c:if test="${sessionScope.currentUser==null}">
                    <span style="color: #c9302c">您未登录，不可打分！</span>
                </c:if>
                <c:if test="${sessionScope.currentUser!=null}">
                    <c:if test="${requestScope.isScored==false}">
                        <button class="btn btn-default" data-toggle="modal" data-target="#userScoreFilmModal">打分
                        </button>
                    </c:if>
                </c:if>
            </div>
        </div>
        <div id="filmDBSc">
            <span style="font-size: 24px;color: #3e8f3e">豆瓣评分:</span>
            <span style="font-size: 24px;"><c:out value="${film.filmDbsc}"></c:out></span>
        </div>
    </div>
    <div>
        <c:if test="${sessionScope.currentUser==null}">
            您未登陆，不可以评论
        </c:if>
        <c:if test="${sessionScope.currentUser!=null}">
            <ul class="pager">
                <li id="shortComment" style="float: left"><a href="#">写短评</a></li>
                <li id="longComment" style="float: right"><a href="#">写长评</a></li>
            </ul>
        </c:if>
    </div>
</div>
<div id="filmIntro">
    <span>影片简介:</span><br>
    <div id="introContent">
        ${film.filmIntro}
    </div>
</div>
<div id="shortCom">
    <span>用户短评:</span><br>
    <c:set var="sComs" value="${requestScope.sComs}"></c:set>
    <c:forEach var="sCom" items="${sComs}">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-title">
                        ${sCom.user.username}&nbsp;&nbsp;${sCom.filmScomDate}
                            <input type="hidden" value="${sCom.filmScomId}">
                            <div class="likesCom" style="float: right">
                                <img style="width: 20px;height: 20px;"
                                     src="../image/like.png">&nbsp;
                                    <span>${sCom.filmScomLike==null?0:sCom.filmScomLike}</span>
                            </div>
                </div>
            </div>
            <div class="panel-body">
                    ${sCom.filmScomContent}
            </div>
        </div>
    </c:forEach>
</div>
<div id="moreScom">
<c:if test="${fn:length(sComs)==0}">
    无
</c:if>
<c:if test="${fn:length(sComs)>0}">
    <button class="btn btn-default">
        <div style="width: 100px;text-align: center">
            点击查看更多<br>
            <span class="glyphicon glyphicon-chevron-down"></span>
        </div>
    </button>
</c:if>
</div>
<div id="longCom">
    <span>用户长评:</span><br>
    <c:set value="${requestScope.lComs}"  var="lComs"></c:set>
    <c:forEach var="lCom" items="${lComs}">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">${lCom.user.username}&nbsp;&nbsp;${lCom.filmLcomDate}
                    <input type="hidden" value="${lCom.filmLcomId}">
                    <div class="likelCom" style="float: right">
                        <img style="width: 20px;height: 20px;"
                             src="../image/like.png">&nbsp;
                        <span>${lCom.filmLcomLike==null?0:lCom.filmLcomLike}</span>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                标题&nbsp;:&nbsp;${lCom.title}
                    <%--<hr>--%>
            </div>
            <div class="lComContent" hidden>
                <hr>
                    ${lCom.filmLcomContent}
            </div>
            <div class="showContent">
                <span style="vertical-align: middle" class="glyphicon glyphicon-chevron-down"></span>
            </div>
        </div>
    </c:forEach>
</div>
<div id="moreLcom">
<c:if test="${fn:length(lComs)==0}">
    无
</c:if>
<c:if test="${fn:length(lComs)>0}">
    <button class="btn btn-default">
        <div style="width: 100px;text-align: center">
            点击查看更多<br>
            <span class="glyphicon glyphicon-chevron-down"></span>
        </div>
    </button>
</c:if>
</div>
<!-- 打分提示框 -->
<div class="modal fade" id="userScoreFilmModal" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">打分</h4>
            </div>
            <div class="modal-body">
                <div id="stars">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                    <img class="star" src="../image/starO.png">
                </div>
                <div id="userScore">
                    <span style="font-size: 16px">你的打分:</span>
                    <span style="font-size: 16px"></span>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" id="subScore">提交</button>
                <button class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 评论模态框 -->
<div class="modal fade" id="commentModal" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">评论</h4>
            </div>
            <div class="modal-body">
                <input id="commentTitle" style="margin-bottom: 20px;width: 300px" type="text" class="form-control"
                       hidden>
                <div id="commentHint">
                    <textarea id="commentWords" maxlength="150"></textarea>
                    <br>
                    字数:<span id="wordNums"></span>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" id="commentBtn">提交</button>
                <button class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- 打分状态提示框 -->
<div class="modal fade" id="userScoreFilmStatus" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <div id="scoreFilmHint">

                </div>

            </div>
            <div class="modal-footer">
                <button class="btn btn-default" id="back">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
