<%--
  Created by IntelliJ IDEA.
  User: paddy
  Date: 2017/3/13
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Volton - Responsive Mobile Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/css/normalize.css">
    <link rel="stylesheet" href="/resources/css/font-awesome.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/templatemo-style.css">
    <script src="/resources/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="/resources/js/vendor/jquery-1.10.2.min.js"></script>
    <script src="/resources/js/min/plugins.min.js"></script>
    <script src="/resources/js/min/main.min.js"></script>
    <script>
        function myReload() {
            document.getElementById("check_Code").src = document.getElementById("check_Code").src + + "?nocache=" + new Date().getTime();
        }
    </script>
    <title>Title</title>
</head>
<body>
<div class="main-content">
    <div class="container" >
        <form action="/blog_userLogin.do" method="post" name="loginForm" >
            <h3>模拟登录</h3>
            <tr>
                <tb>账号:</tb>
                <tb><input type="text" value="" name="user.userName"></tb>
            </tr><br>
            <tr>
                <tb>密码:</tb>
                <tb><input type="password" value="" name="user.password"/></tb>
            </tr><br>
            <tr>
                <tb>验证码:</tb>
                <tb><input name="IdCode" type="text" value=""/></tb>
                <tb><img id="check_Code" src="/check/IdCode_getCode.do" width="90" height="30" style="margin-left: 10px"/></tb>
                <tb><a href="" onclick="myReload()">看不清</a></tb>
            </tr><br>
            <tr>
                <tb><input type="submit" value="确认"/></tb>
                ${error_message}
            </tr>
        </form>

    </div>
</div>
</body>
</html>
