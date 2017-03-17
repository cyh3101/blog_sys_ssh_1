<%@ page import="com.opensymphony.xwork2.ActionContext" %><%--
  Created by IntelliJ IDEA.
  User: paddy
  Date: 2017/3/17
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="utf-8" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .text1{width:100px; height:100px}
    </style>
</head>
<body>
<h1>简单文本分割</h1>
<form action="/split/split.do" method="post">
    <textarea rows="3" cols="30" name="getTxt"></textarea>
    <input type="submit" value="提交">
</form><br>
<span>
    <%
        String getSplit = (String) ActionContext.getContext ( ).getSession ( ).get ("sendSplit");
        if (getSplit != null) {
            session.putValue ("sendSplit", null);
            out.print ("分句为:" + getSplit);
        }
    %>
</span>
</body>
</html>
