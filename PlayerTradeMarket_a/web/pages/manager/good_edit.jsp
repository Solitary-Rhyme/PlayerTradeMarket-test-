<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑物品</title>

    <%@include file="/pages/common/header.jsp" %>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>

<body style="background: #2A2A2A">
<div id="header">
    <span class="wel_word">编辑物品</span>
    <span class="wel_word">交易物品管理系统</span>
    <a href="${pageContext.request.contextPath}/manageServlet?action=getGoodsByUsername" class="wel_word"
       style="margin-left: 530px; font-size: 25px; color: #FFD764;font-weight: bold">
        返回</a>
</div>

<div id="main">
    <form action="${pageContext.request.contextPath}/manageServlet" method="post">
        <input type="hidden" name="action" value="${param.method}"/>
        <input type="hidden" name="good_id" value="${requestScope.good.id}"/>
        <table style="position: relative; top: 100px">
            <tr style="padding: 30px;">
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">预设图片</td>
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">物品</td>
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">价格</td>
                <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">库存</td>
            </tr>
            <tr>
                <td>
                    <select name="pic">
                        <option value="0">[默认图片]</option>
                        <option value="1">铁锭</option>
                        <option value="2">食材</option>
                        <option value="3">食物</option>
                        <option value="4">武器</option>
                        <option value="5">护甲</option>
                        <option value="6">宠物</option>
                        <option value="7">药水</option>
                        <option value="8">卡牌</option>
                        <option value="9">奇怪的选项</option>
                    </select><br/>
                </td>
                <td><input name="name" type="text" value="${requestScope.good.goods_name}"/></td>
                <td><input name="price" type="text" value="${requestScope.good.price}"/></td>
                <td><input name="stock" type="text" value="${requestScope.good.stocks}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
