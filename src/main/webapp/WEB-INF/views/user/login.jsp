<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/8/23
  Time: 下午4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <script src="js/jquery-3.2.1.js" type="text/javascript"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form class="form-signin" id="logform" method="post">
                <h2 class="form-signin-heading">请登录 </h2>
                <label for="name" class="sr-only"> Email address</label> <input
                    type="email" name="name" id="name" class="form-control"
                    placeholder="用户名" required autofocus>
                <label
                    for="password" class="sr-only">Password </label> <input
                    type="password" name="password" id="password" class="form-control"
                    placeholder="密码" required>
                <div class="checkbox">
                    <label> <input type="checkbox" value="remember-me ">
                        记住密码
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block"
                        type="button" id="btn" onclick="login()">登录
                </button>
                <button class="btn btn-lg btn-primary btn-block"
                        type="button" id="regist" onclick="reg()">注册
                </button>

                <span id="login"></span>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
<script>
    function login() {
        $.post(
            "/loginUser",
            {
                name: $("#name").val(),
                password: $("#password").val()
            },
            function (result) {
                if (result=="yes"){
                    $("#login").html("登录成功!")
                    window.location.href="/jumpindex"
                }else {
                    $("#login").html("登录失败");
//                    window.location.href="/jumplogin"
                }
            })
    }

    //跳转页面
    function reg() {
        window.location.href="/jumpregister"
    }










</script>


</html>
