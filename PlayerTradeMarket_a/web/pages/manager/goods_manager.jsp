<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>交易物品管理</title>

    <%@include file="/pages/common/header.jsp" %>

    <script type="text/javascript">
        $(function () {
            //给删除的标签绑定单击事件，用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                return confirm("确定要删除" + $(this).parent().parent().find("td:first").text() + "么?")
            });
        });
    </script>

</head>


<body style="background: #2A2A2A">

<div id="header">
    <span class="wel_word">交易物品管理系统</span>
    <a href="${pageContext.request.contextPath}/manageServlet?action=getAllGoods" class="wel_word"
       style="margin-left: 730px; font-size: 25px; color: #FFD764;font-weight: bold">
        返回</a>
</div>

<div id="main">
    <table>
        <tr style="padding: 30px">
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">物品</td>
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">价格</td>
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">出售者</td>
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">销量</td>
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">库存</td>
        </tr>

        <c:forEach items="${requestScope.user_goods_list}" var="goods">
            <tr>
                <td>${goods.goods_name}</td>
                <td>${goods.price}</td>
                <td>${goods.saler}</td>
                <td>${goods.sales}</td>
                <td>${goods.stocks}</td>
                <td><a href="${pageContext.request.contextPath}/manageServlet?action=getGood&id=${goods.id}&method=updateGood" style="color: #FFFFDF">修改</a> ||
                <a href="${pageContext.request.contextPath}/manageServlet?action=deleteGood&id=${goods.id}" class="deleteClass" style="color: #FFFFDF">删除</a></td>
            </tr>
        </c:forEach>
        <td style="position: relative;left: 475px; font-weight: bold;">
            <a href="${pageContext.request.contextPath}/pages/manager/good_edit.jsp?method=addGood" style="color: #FFFFDF;border: 2px solid #BEBEBE; border-radius: 15px">
                添加商品</a>
        </td>
    </table>
</div>
</body>
</html>
