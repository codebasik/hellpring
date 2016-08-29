<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<title>상세보기</title>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/assets/ico/favicon.png">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/jumbotron-narrow.css" rel="stylesheet">
    <script src="/assets/js/html5shiv.js"></script>
    <script src="/assets/js/respond.min.js"></script>
</head>

<body>
<%
    String s_id = (String) session.getAttribute("s_id");
%>
<%--<c:set var="s_id" value="<%=s_id%>"/>--%>
<%--<c:if test="${empty s_id}">--%>
    <%--<c:redirect url="/login.do"/>--%>
<%--</c:if>--%>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/main.do">Home</a></li>
        </ul>
        <h3 class="text-muted">상세보기</h3>
    </div>
    <form>
        <div class="form-group">
            <label for="username">이름</label>
            <input type="text" name="username" class="form-control .form-control-static" id="username" value="${detail.username}" readonly>
        </div>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" name="title" class="form-control" id="title" value="${detail.title}" readonly>
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" rows="4" id="content" name="content" readonly>${detail.content}</textarea>
        </div>
    </form>
    <div class="text-right">
        <a href="/board/delete?seq=${detail.seq}" class="btn btn-default">글삭제</a>
        <a href="/board/list" class="btn btn-default">목록으로</a>
    </div>
</div> <!-- /container -->
<script src="/assets/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
