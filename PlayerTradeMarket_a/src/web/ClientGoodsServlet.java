package web;

import pojo.Goods;
import service.Impl.GoodsServiceImpl;
import service.GoodsService;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClientGoodsServlet extends BaseServlet{

    GoodsService goodsService = new GoodsServiceImpl();

    protected void getGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer limited = 5;

        List<Goods> LimitedGoodsList = goodsService.getLimitedGoods(limited);

        req.setAttribute("limited_goods_list",LimitedGoodsList);

        req.getRequestDispatcher("pages/client/index.jsp").forward(req,resp);
    }

    protected void filtered(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sort_type = req.getParameter("filter");
        if(sort_type == null){
            sort_type = "id";
        }
        Integer upper_price = WebUtils.toInteger(req.getParameter("upper_price"),Integer.MAX_VALUE);
        Integer lower_price = WebUtils.toInteger(req.getParameter("lower_price"),0);

        switch (sort_type){
            case "sales": req.setAttribute("sales_status","checked"); break;
            case "price": req.setAttribute("price_status","checked"); break;
            case "id DESC": req.setAttribute("id_status","checked"); break;
            case "goods_name": req.setAttribute("goods_name_status","checked"); break;
        }

        if(upper_price != Integer.MAX_VALUE){
            req.setAttribute("upper_price",upper_price);
        }
        if(lower_price != 0){
            req.setAttribute("lower_price",lower_price);
        }

        //看看是否限定了搜索名
        String select_text = (String) req.getSession().getAttribute("select_text");

        if(select_text == null || select_text == ""){

            //从来没有限定过搜索名，或者搜索名为空;独立获取物品列表
            List<Goods> FilteredGoodsList = goodsService.getFilteredGoods(sort_type,upper_price,lower_price);
            req.setAttribute("goods_list",FilteredGoodsList);

        } else{

            //限定过搜索名，调用联合搜索
            List<Goods> SelectedAndFilteredGoodsList = goodsService.getFilteredGoodsByName(select_text,sort_type,upper_price,lower_price);
            req.setAttribute("goods_list",SelectedAndFilteredGoodsList);
        }

        req.getRequestDispatcher("pages/goods/goods.jsp").forward(req,resp);
    }

    protected void selected(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取搜索框中的文本，并储存到session域中
        req.getSession().setAttribute("select_text",req.getParameter("goods_name_sel"));

        //调用filtered让它根据情况判断使用那种搜索方式
        filtered(req,resp);
    }

    protected void buyGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = WebUtils.toInteger(req.getParameter("id"),0);
        String method = req.getParameter("method");
        Integer amount = WebUtils.toInteger(req.getParameter("amount"),1);

        Goods good = goodsService.getGoodById(id);
        if(good.getStocks() < amount){
            amount = good.getStocks();
        }
        good.setSales(good.getSales() + amount);
        good.setStocks(good.getStocks() - amount);

        goodsService.updateGood(good);

        resp.sendRedirect("/PlayerTradeMarket_a_war_exploded/manageServlet?action=getAllGoods");
    }
}
