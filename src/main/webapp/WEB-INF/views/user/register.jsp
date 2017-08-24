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

<%--<form action="/regist">--%>
    <%--用户名:<input type="text" name="username"><br>--%>
    <%--密码:<input type="password" name="password"><br>--%>
    <%--重置密码:<input type="text" name="secpassword"><br>--%>
    <%--电话:<input type="text" name="tel"><br>--%>
    <%--地址:<input type="text" name="address"><br>--%>
   <%--<input type="submit">--%>
<%--</form>--%>
<div class="container-fluid">
    <div class="col-md-6">
                        <div class="modal-body">
                            <form role="form" id="regForm" method="post"  >
                                <div class="form-group">

                                    <label for="name"> 用户名: </label>
                                    <input class="form-control" id="name" type="text" placeholder="用户名"/>
                                    <span id="checkNameResult"></span>
                                </div>
                                <div class="form-group">
                                    <label for="password"> 密码 :</label>
                                    <input class="form-control" id="password" type="password" />
                                </div>
                                <div class="form-group">
                                    <label for="password1"> 密码确认 :</label>
                                    <input class="form-control" id="password1" type="password" />
                                </div>
                                <div class="form-group">
                                    <label for="tel"> 电话 :</label>
                                    <input class="form-control" id="tel" type="tel" />
                                </div>
                                <div class="form-group">
                                    <label for="address"> 地址 :</label>
                                    <input class="form-control" id="address" type="address" />
                                </div>
                                <div class="checkbox">
                                    <label> <input type="checkbox" /> 记住密码
                                    </label>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-default" type="button" id="btn" onclick="reg()">注册</button>

                        </div>

    </div>

</div>

</body>

<script>
//    $("#btn").click(function () {
//        $.ajax({
//            url: "/regist",
//            type: "get",
//            data: {
//                name: $("#name").val(),
//                password: $("#password").val(),
//                tel: $("#tel").val(),
//                address: $("#address").val()
//
//            },
//            success: function (result) {
//                alert(result)
//            }
//
//        })
//    })
    $(document).ready(
        function() {
            //验证用户名是否可用
            $("#name").blur(function () {
                $.post(
                    "/checkUserName",
                    {
                        name: $("#name").val()
                    },
                    function (result) {
                        console.log(result)
                        if (result.Msg) {
                            $("#checkNameResult").html("该用户名可用");
                        }
                        else {
                            $("#checkNameResult").html("对不起，该用户名已被占用，请更换");
                        }
                    });
            })

            function reg() {
                $.post(
                    "/reg",
                    $('#regForm').serialize(),
                    function (result) {
                    $('#regFormModal').modal('hide');
                    if (result.reg == "yes") {
                        $("#msgTitle").html("注册成功");
                        $("#msgBody").html("恭喜您，注册成功");
                        $("#msgModal").modal();
                    }
                    else {
                        $("#msgTitle").html("注册失败");
                        $("#msgBody").html("对不起，注册失败");
                        $("#msgModal").modal();
                    }
                })
            }
        })








</script>
</html>
