package service.Impl;

import DAO.Impl.GoodsDAOImpl;
import DAO.GoodsDAO;
import pojo.Goods;
import service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    GoodsDAO goodsDAO = new GoodsDAOImpl();

    @Override
    public void addGood(Goods goods) {
        goodsDAO.saveGood(goods);
    }

    @Override
    public List<Goods> getGoodsByUsername(String saler) {
        return goodsDAO.getGoodsByUsername(saler);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDAO.getAllGoods();
    }

    @Override
    public Goods getGoodById(Integer id) {
        return goodsDAO.getGoodById(id);
    }

    @Override
    public void updateGood(Goods goods) {
        if(goods.getSales() == null){
            //用户更新商品信息时运行的update
            goodsDAO.updateGood(goods);
        }else{
            //用户购买商品时运行的update
            goodsDAO.updateGoodwithSales(goods);
        }

    }

    @Override
    public void deleteGoodById(Integer id) {
        goodsDAO.deleteGoodById(id);
    }

    @Override
    public List<Goods> getLimitedGoods(Integer limited) {
        return goodsDAO.getLimitedGoods(limited);
    }

    @Override
    public List<Goods> getFilteredGoods(String sort_type, Integer upper_price, Integer lower_price) {
        return goodsDAO.getFilteredGoods(sort_type,upper_price,lower_price);
    }

    @Override
    public List<Goods> getGoodsByName(String goods_name) {
        return goodsDAO.getGoodsByName(goods_name);
    }

    @Override
    public List<Goods> getFilteredGoodsByName(String goods_name, String sort_type, Integer upper_price, Integer lower_price) {
        return goodsDAO.getFilteredGoodsByName(goods_name,sort_type,upper_price,lower_price);
    }

}
