<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>=首页=</title>

    <%@include file="/pages/common/header.jsp" %>

    <script>
        $(function () {
            $("a.logout").click(function () {
                return confirm("确定要注销登陆信息么？");
            });
        });
    </script>
</head>
<body style="background: #2A2A2A">
<div id="header">
    <span class="wel_word">交易市场</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/pages/user/login.jsp">登录 </a>
            <a href="${pageContext.request.contextPath}/pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临交易市场</span>
            <a href="${pageContext.request.contextPath}/manageServlet?action=getGoodsByUsername">出售物品管理</a>
            <a href="${pageContext.request.contextPath}/userServlet?action=logout" class="logout">注销</a>&nbsp;&nbsp;
        </c:if>

    </div>
</div>
<div id="main">
    <div id="book">
        <table>
            <tr style="padding: 30px">
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">物品</td>
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">价格</td>
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">出售者</td>
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">销量</td>
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">库存</td>
            </tr>

            <c:forEach items="${requestScope.limited_goods_list}" var="goods">
                <tr>
                    <td><img class="item_img" alt="" src="${pageContext.request.contextPath}/static/img/img_${goods.img_id}.PNG">
                            ${goods.goods_name}</td>
                    <td>${goods.price}</td>
                    <td>${goods.saler}</td>
                    <td>${goods.sales}</td>
                    <td>${goods.stocks}</td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="5" style="font-weight: bold;font-size: 20px; "><a href="${pageContext.request.contextPath}/manageServlet?action=getAllGoods" style="color: #FFD764">vv 查看更多 vv</a></td>
            </tr>
        </table>
    </div>
</div>


<div id="bottom">
		<span style="color: #666666">
			Developed By Solitary-Rhyme &copy;2021
		</span>
</div>

</body>
</html>
