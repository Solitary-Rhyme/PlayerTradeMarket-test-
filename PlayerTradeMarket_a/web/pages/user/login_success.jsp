<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录页面</title>

    <%@include file="/pages/common/header.jsp" %>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
            color: #FFD764;
            font-weight: bold;
            font-size: 35px
        }

        h1 a {
            color: red;
        }
    </style>
</head>

<body style="background: #2A2A2A">
<div id="header"></div>

<div id="main">
    <h1>欢迎回来&nbsp;&nbsp; ${sessionScope.user.username}&nbsp;&nbsp; <a href="../../index.jsp">转到主页</a></h1>
</div>
</body>

</html>