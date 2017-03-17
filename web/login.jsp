<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
  Created by IntelliJ IDEA.
  User: paddy
  Date: 2017/3/13
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Volton - Responsive Mobile Template</title>
    <script>
        function myReload() {
            document.getElementById("check_Code").src = document.getElementById("check_Code").src + + "?nocache=" + new Date().getTime();
        }
    </script>
    <title>Title</title>
</head>
<body>
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
    <span>
    <%--${errorMsg}--%>
        <%
            String msg =(String) ActionContext.getContext ().getSession ().get ("errorMsg");
            if (msg != null) {
            	session.putValue ("errorMsg", null);
            	out.println(msg);
            }
        %>
    </span>
    <tr>
        <tb><input type="submit" value="确认"/></tb>
    </tr>
</form>
</body>
</html>
