<%--
  Created by IntelliJ IDEA.
  User: paddy
  Date: 2017/3/14
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>模拟注册界面</h1>
<br>
<hr>
<form name="registerForm" action="/blog_tosave.do" method="post">
    <tr>
        <tb>账号:</tb>
        <tb><input type="text" name="user.userName" value=""/></tb>
    </tr><br>
    <tr>
        <tb>密码:</tb>
        <tb><input type="password" name="user.password" value=""/></tb>
    </tr><br>
    <tr>
        <tb><input type="submit" value="确认"/></tb>
    </tr><br>
    <%--${errorMsgRegister}--%>
    <span>
        <%
            String msg =(String) ActionContext.getContext ().getSession ().get ("errorMsgRegister");
            if (msg != null) {
                session.putValue ("errorMsgRegister", null);
                out.println(msg);
            }
        %>
    </span>
</form>
</body>
</html>
