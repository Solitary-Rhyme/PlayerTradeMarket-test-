package DAO.Impl;

import DAO.GoodsDAO;
import pojo.Goods;

import java.util.List;

public class GoodsDAOImpl extends BaseDAO implements GoodsDAO {
    @Override
    public void saveGood(Goods goods) {
        String sql = "INSERT INTO goods (`goods_name`,`price`,`saler`,`sales`,`stocks`,`img_id`) VALUE (?,?,?,?,?,?)";
        update(sql,goods.getGoods_name(),goods.getPrice(),goods.getSaler(),goods.getSales(),goods.getStocks(),goods.getImg_id());
    }

    @Override
    public List<Goods> getGoodsByUsername(String saler) {
        String sql = "SELECT `id`,`goods_name`,`price`,`saler`,`sales`,`stocks`,`img_id` FROM goods WHERE `saler` = ?";
        return queryOfList(Goods.class,sql,saler);
    }

    @Override
    public List<Goods> getAllGoods() {
        String sql = "SELECT `id`,`goods_name`,`price`,`saler`,`sales`,`stocks`,`img_id` FROM goods";
        return queryOfList(Goods.class,sql);
    }

    @Override
    public Goods getGoodById(Integer id) {
        String sql = "SELECT `id`,`goods_name`,`price`,`saler`,`sales`,`stocks`,`img_id` FROM goods WHERE `id` = ?";
        return queryForOne(Goods.class,sql,id);
    }

    @Override
    public void updateGood(Goods goods) {
        String sql = "UPDATE goods SET `goods_name`=?,`price`=?,`stocks`=?,`img_id`=? WHERE id = ?";
        update(sql,goods.getGoods_name(),goods.getPrice(),goods.getStocks(),goods.getImg_id(),goods.getId());
    }

    @Override
    public void deleteGoodById(Integer id) {
        String sql = "DELETE FROM goods WHERE id = ?";
        update(sql,id);
    }

    @Override
    public List<Goods> getLimitedGoods(Integer limited) {
        String sql = "SELECT `id`,`goods_name`,`price`,`saler`,`sales`,`stocks`,`img_id` FROM goods limit ?";
        return queryOfList(Goods.class,sql,limited);
    }

    @Override
    public List<Goods> getFilteredGoods(String sort_type, Integer upper_price, Integer lower_price) {
        String sql = "SELECT `id`,`goods_name`,`price`,`saler`,`sales`,`stocks`,`img_id` FROM goods WHERE `price` BETWEEN ? AND ? ORDER BY " + sort_type;
        return queryOfList(Goods.class,sql,lower_price,upper_price);
    }

    @Override
    public List<Goods> getGoodsByName(String goods_name) {
        String sql = "SELECT `id`,`goods_name`,`price`,`saler`,`sales`,`stocks`,`img_id` FROM goods WHERE `goods_name` = ?";
        return queryOfList(Goods.class,sql,goods_name);
    }

    @Override
    public List<Goods> getFilteredGoodsByName(String goods_name, String sort_type, Integer upper_price, Integer lower_price) {
        String sql = "SELECT `id`,`goods_name`,`price`,`saler`,`sales`,`stocks`,`img_id` FROM goods WHERE `goods_name` = ? AND `price` BETWEEN ? AND ? ORDER BY " + sort_type;
        return queryOfList(Goods.class,sql,goods_name,lower_price,upper_price);
    }

    @Override
    public void updateGoodwithSales(Goods goods) {
        String sql = "UPDATE goods SET `goods_name`=?,`price`=?,`stocks`=?,`img_id`=?,`sales`=? WHERE id = ?";
        update(sql,goods.getGoods_name(),goods.getPrice(),goods.getStocks(),goods.getImg_id(),goods.getSales(),goods.getId());
    }
}
