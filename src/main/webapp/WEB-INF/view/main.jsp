<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/assets/ico/favicon.png">
    <title>메인</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/jumbotron-narrow.css" rel="stylesheet">
    <script src="/assets/js/html5shiv.js"></script>
    <script src="/assets/js/respond.min.js"></script>
</head>

<%
    String s_user = (String) session.getAttribute("s_id");
%>

<c:set var="s_user" value="<%=s_user%>"/>

<c:if test="${empty s_user}">
    <c:redirect url="/login"/>
</c:if>

<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/">Home</a></li>
            <c:if test="${empty s_user}">
                <li><a href="/login">로그인</a></li>
            </c:if>
            <li><a href="/board/list">글목록</a></li>
            <c:if test="${not empty s_user}">
                <li><a href="/logout">로그아웃</a></li>
            </c:if>
        </ul>
        <h3 class="text-muted">메인</h3>
    </div>

    <div class="form-group">
        <h1>지옥자바</h1>
        <p>지옥자바 게시판 만들기 과제</p>
    </div>


</div> <!-- /container -->
<script src="/assets/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
