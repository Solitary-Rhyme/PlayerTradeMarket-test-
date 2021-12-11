package web;

import pojo.Goods;
import pojo.User;
import service.Impl.GoodsServiceImpl;
import service.GoodsService;
import util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManageServlet extends BaseServlet{

    GoodsService goodsService = new GoodsServiceImpl();

    protected void getAllGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Goods> allGoodsList = goodsService.getAllGoods();

        req.setAttribute("goods_list",allGoodsList);

        req.getRequestDispatcher("pages/goods/goods.jsp").forward(req,resp);
    }

    protected void getGoodsByUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User a_user = (User)req.getSession().getAttribute("user");
        String saler = a_user.getUsername();

        List<Goods> user_goods_list = goodsService.getGoodsByUsername(saler);

        req.setAttribute("user_goods_list",user_goods_list);

        req.getRequestDispatcher("/pages/manager/goods_manager.jsp").forward(req,resp);
    }


    protected void addGood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String goods_name = req.getParameter("name");
        Integer price = WebUtils.toInteger(req.getParameter("price"),0);
        Integer img_id = WebUtils.toInteger(req.getParameter("pic"),0);

        User a_user = (User)req.getSession().getAttribute("user");
        String saler = a_user.getUsername();

        Integer sales = 0;
        Integer stocks = WebUtils.toInteger(req.getParameter("stock"),0);

        Goods goods = new Goods(null,goods_name,price,saler,sales,stocks,img_id);

        goodsService.addGood(goods);

        resp.sendRedirect("/PlayerTradeMarket_a_war_exploded/manageServlet?action=getGoodsByUsername");
    }

    protected void getGood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = WebUtils.toInteger(req.getParameter("id"),0);
        String method = req.getParameter("method");

        Goods good = goodsService.getGoodById(id);

        req.setAttribute("good",good);

        req.getRequestDispatcher("/pages/manager/good_edit.jsp?method=" + method).forward(req,resp);
    }

    protected void updateGood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = WebUtils.toInteger(req.getParameter("good_id"),0);
        String goods_name = req.getParameter("name");
        Integer price = WebUtils.toInteger(req.getParameter("price"),0);
        Integer stocks = WebUtils.toInteger(req.getParameter("stock"),0);
        Integer img_id = WebUtils.toInteger(req.getParameter("pic"),0);

        Goods goods = new Goods(id,goods_name,price,null,null,stocks,img_id);

        goodsService.updateGood(goods);

        resp.sendRedirect("/PlayerTradeMarket_a_war_exploded/manageServlet?action=getGoodsByUsername");
    }

    protected void deleteGood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = WebUtils.toInteger(req.getParameter("id"),0);

        goodsService.deleteGoodById(id);

        resp.sendRedirect("/PlayerTradeMarket_a_war_exploded/manageServlet?action=getGoodsByUsername");
    }
}
