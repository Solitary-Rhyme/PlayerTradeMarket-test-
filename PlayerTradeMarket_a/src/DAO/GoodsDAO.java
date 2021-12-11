package DAO;

import pojo.Goods;

import java.util.List;

public interface GoodsDAO {
    void saveGood(Goods goods);

    List<Goods> getGoodsByUsername(String saler);

    List<Goods> getAllGoods();

    Goods getGoodById(Integer id);

    void updateGood(Goods goods);

    void deleteGoodById(Integer id);

    List<Goods> getLimitedGoods(Integer limited);

    List<Goods> getFilteredGoods(String sort_type, Integer upper_price, Integer lower_price);

    List<Goods> getGoodsByName(String goods_name);

    List<Goods> getFilteredGoodsByName(String goods_name, String sort_type, Integer upper_price, Integer lower_price);

    void updateGoodwithSales(Goods goods);
}
