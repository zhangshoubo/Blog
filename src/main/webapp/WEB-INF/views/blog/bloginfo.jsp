<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/8/24
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.js" type="text/javascript"></script>
</head>
<body>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-8">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        博客标题
                    </th>
                    <th>
                        博客描述
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${param.title}</td>
                    <td> ${param.des}</td>
                    <td> ${param.content}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>


</html>
