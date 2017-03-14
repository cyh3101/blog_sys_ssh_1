<%--
  Created by IntelliJ IDEA.
  User: paddy
  Date: 2017/3/12
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Volton - Responsive Mobile Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="/resources/css/normalize.css">
    <link rel="stylesheet" href="/resources/css/font-awesome.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/templatemo-style.css">
    <script src="/resources/js/vendor/modernizr-2.6.2.min.js"></script>
    <title>$Title$</title>
</head>
<body>

<!-- SIDEBAR -->
<div class="sidebar-menu hidden-xs hidden-sm">
    <div class="top-section">
        <div class="profile-image">
            <img src="/resources/img/profile.jpg" alt="Volton">
        </div>
        <h3 class="profile-title">${userName}</h3>
        <p class="profile-description">职业：学生</p>
    </div> <!-- top-section -->
    <div class="main-navigation">
        <ul class="navigation">
            <li><a href="#about"><i class="fa fa-globe"></i>关于我</a></li>
            <li><a href="#article"><i class="fa fa-pencil"></i>我的文章</a></li>
        </ul>
    </div> <!-- .main-navigation -->
</div> <!-- .sidebar-menu -->

<div class="collapse navbar-collapse">
    <ul class="nav navbar-nav pull-right">
        <li><a href="#">登录</a></li>
        <li><a href="#">注册</a></li>
    </ul>
</div><!-- /.nav-collapse -->

<!--1-->
<div class="banner-bg" id="about">
    <div class="banner-overlay"></div>
    <div class="welcome-text">
        <h2>自我介绍</h2>
        <h5>喜欢底层的东西，喜欢新技术</h5>
    </div>
</div>

<!-- MAIN CONTENT -->
<div class="main-content">
    <div class="fluid-container">

        <div class="content-wrapper">

            <!-- ABOUT -->
            <div class="page-section" id="article">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="widget-title " >文章列表</h4>
                        <ul class="navigation">
                            <li><a href="#" target="_blank">123</a></li>
                            <li><a href="#" target="_blank">123</a></li>
                            <li><a href="#" target="_blank">123</a></li>
                            <li><a href="#" target="_blank">123</a></li>
                        </ul>
                        <hr>
                    </div>
                </div> <!-- #about -->
            </div>

            <div class="row" id="footer">
                <div class="col-md-12 text-center">
                    <p class="copyright-text">Create &copy; 2017 <a href="#" target="_blank" title="邮箱地址">邮箱地址</a>&nbsp;<a href="#" target="_blank">GitHub项目地址</a></p>
                </div>
            </div>

        </div>

    </div>
</div>

<script src="/resources/js/vendor/jquery-1.10.2.min.js"></script>
<script src="/resources/js/min/plugins.min.js"></script>
<script src="/resources/js/min/main.min.js"></script>

</body>
</html>
