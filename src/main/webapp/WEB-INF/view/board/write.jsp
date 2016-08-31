<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<title>글쓰기</title>
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
<c:set var="s_id" value="<%=s_id%>"/>
<c:if test="${empty s_id}">
    <c:redirect url="/login"/>
</c:if>

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/main">Home</a></li>
        </ul>
        <h3 class="text-muted">글쓰기</h3>
    </div>
    <form role="form" action="/board/write" method="post">
        <div class="form-group">
            <label for="username">이름</label>
            <input type="text" name="username" class="form-control" id="username" placeholder="이름을 입력하세요" value="<%=s_id%>" required>
        </div>
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" name="title" class="form-control" id="title" placeholder="제목을 입력하세요" required>
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" rows="4" id="content" name="content" placeholder="내용을 입력하세요" required></textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div> <!-- /container -->
<script src="/assets/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
