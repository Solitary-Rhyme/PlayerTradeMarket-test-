<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>交易市场</title>

    <%@include file="/pages/common/header.jsp" %>

    <script>
        $(function () {
            $("a.logout").click(function () {
                return confirm("确定要注销登陆信息么？");
            });
        });

        $(function () {
            if(${not empty requestScope.sales_status}){
                $("input[type=radio][name=filter][value='sales']").attr("checked",'checked');
            } else if(${not empty requestScope.price_status}){
                $("input[type=radio][name=filter][value='price']").attr("checked",'checked');
            } else if(${not empty requestScope.id_status}){
                $("input[type=radio][name=filter][value='id DESC']").attr("checked",'checked');
            } else if(${not empty requestScope.goods_name_status}){
                $("input[type=radio][name=filter][value='goods_name']").attr("checked",'checked');
            }
        });
    </script>
</head>
<body style="background: #2A2A2A">
<%--	头部栏信息显示--%>
<div id="header">
    <span class="wel_word_goods" style="float: left">交易市场</span>

<%--	搜索框--%>
    <form action="${pageContext.request.contextPath}/clientGoodsServlet" method="post" style="float: left">
        <input type="hidden" name="action" value="selected" />
        <img class="select_img" alt="" src="static/img/select.png">
        <input class="select_text" type="text" placeholder="请输入要查询的物品信息"
               autocomplete="off" tabindex="1" name="goods_name_sel">
        <input type="submit" value="搜索" id="select_sub_btn"/>
    </form>


<%--	右侧功能栏--%>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/pages/user/login.jsp">登录 </a>
            <a href="${pageContext.request.contextPath}/pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/manageServlet?action=getGoodsByUsername">出售物品管理</a>
            <a href="${pageContext.request.contextPath}/userServlet?action=logout" class="logout">注销</a>&nbsp;&nbsp;
        </c:if>
    </div>
</div>

<%--筛选框信息显示--%>
<div class="select_form">
    <form action="${pageContext.request.contextPath}/clientGoodsServlet" method="post">
        <input type="hidden" name="action" value="filtered" />
        <div class="select_small_title">分类</div>
        <input type="radio" name="filter" value="sales"/>
            <label class="select_radio">按销量排序</label><br>
        <input type="radio" name="filter" value="price"/>
            <label class="select_radio">按价格排序</label><br>
        <input type="radio" name="filter" value="id DESC" />
            <label class="select_radio">按出售时间排序</label><br>
        <input type="radio" name="filter" value="goods_name" />
            <label class="select_radio">按首字母排序</label><br>
        <input type="radio" name="filter" value="ava"/>
            <label class="select_radio">奇怪的选项</label><br><br><br>

        <div class="select_small_title">价格区间</div>
        <label class="select_radio">-最高价格</label><br>
        <input class="itxt" autocomplete="off" tabindex="1" name="upper_price" value="${requestScope.upper_price}"/><br><br>
        <label class="select_radio">-最低价格</label><br>
        <input class="itxt" autocomplete="off" tabindex="1" name="lower_price" value="${requestScope.lower_price}"/><br>

        <input type="submit" value="筛选" id="select_left_btn"/>
    </form>
</div>


<%--商品信息显示--%>
<div id="main" style="border: none; position: relative; top: 30px; float: left">
    <table>
        <tr style="padding: 30px">
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">物品</td>
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">价格</td>
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">出售者</td>
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">销量</td>
            <td style="color: #FFD764;border-bottom: 3px #FFFFBB solid;padding: 10px;">库存</td>
        </tr>

        <c:forEach items="${requestScope.goods_list}" var="goods">
        <tr>
            <td><img class="item_img" alt="" src="${pageContext.request.contextPath}/static/img/img_${goods.img_id}.PNG">${goods.goods_name}</td>
            <td>${goods.price}</td>
            <td>${goods.saler}</td>
            <td>${goods.sales}</td>
            <td>${goods.stocks}</td>
            <c:if test="${not empty sessionScope.user}">
                <td style="width: 50px;">
                    <a href="${pageContext.request.contextPath}/clientGoodsServlet?action=buyGoods&id=${goods.id}&amount=1" style="color: #FFFFDF;font-size: 12px">购买</a><br/>
                    <a href="${pageContext.request.contextPath}/clientGoodsServlet?action=buyGoods&id=${goods.id}&amount=10" style="color: #FFFFDF;font-size: 12px">购买x10</a>
                </td>
            </c:if>
        </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>