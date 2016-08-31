<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/assets/ico/favicon.png">
    <title>회원가입</title>
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/jumbotron-narrow.css" rel="stylesheet">
    <script src="/assets/js/html5shiv.js"></script>
    <script src="/assets/js/respond.min.js"></script>
</head>

<body>
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/">Home</a></li>
        </ul>
        <h3 class="text-muted">회원 가입</h3>
    </div>
    <form role="form" action="/join" method="post">
        <div class="form-group">
            <label for="userid">ID</label>
            <input type="text" name="userid" class="form-control" id="userid" placeholder="ID를 입력하세요">
        </div>
        <div class="form-group">
            <label for="username">이름</label>
            <input type="text" name="username" class="form-control" id="username" placeholder="이름을 입력하세요">
        </div>
        <div class="form-group">
            <label for="userpassword">비밀번호</label>
            <input type="password" name="userpassword" class="form-control" id="userpassword" placeholder="비밀번호를 입력하세요">
        </div>
        <div class="form-group">
            <label for="useremail">이메일</label>
            <input type="email" name="useremail" class="form-control" id="useremail" placeholder="이메일을 입력하세요">
        </div>
        <button type="submit" class="btn btn-default">회원가입</button>
    </form>
</div> <!-- /container -->
<script src="/assets/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
