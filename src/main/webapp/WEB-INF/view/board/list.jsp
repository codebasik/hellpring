<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>글목록</title>
<head>
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
    <%--<c:redirect url="/login"/>--%>
<%--</c:if>--%>

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/">Home</a></li>
            <c:if test="${not empty s_id}">
                <li><a href="/logout">로그아웃</a></li>
            </c:if>
        </ul>
        <h3 class="text-muted">글목록</h3>
    </div>
    <div>
        <div>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" name="searchWord" class="form-control" placeholder="검색어"
                           value="${boardSearch.searchWord}" required>
                </div>
                <div class="form-group">
                    <select class="form-control" name="queryInput" id="queryInput" onchange="queryInputChange();" >
                        <option value="ALL">전체</option>
                        <option value="NAME"
                                <c:if test="${boardSearch.queryInput eq 'NAME'}">selected</c:if> >글쓴이
                        </option>
                        <option value="CONTENT"
                                <c:if test="${boardSearch.queryInput eq 'CONTENT'}">selected</c:if> >내용
                        </option>
                        <option value="TITLE"
                                <c:if test="${boardSearch.queryInput eq 'TITLE'}">selected</c:if> >제목
                        </option>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">검색</button>
            </form>
        </div>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>글쓴이</th>
                <th>제목</th>
                <th>내용</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${boardList}" var="list">
                <tr>
                    <td>${list.seq}</td>
                    <td>${list.username}</td>
                    <td><a href="/board/detail?seq=${list.seq}">${list.title}</td>
                    <td>${list.content}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="text-right">
        <a href="/board/write" class="btn btn-default">글쓰기</a>
    </div>
</div> <!-- /container -->
</body>
</html>

