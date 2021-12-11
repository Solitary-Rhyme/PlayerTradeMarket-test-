package pojo;

public class Goods {

    Integer id;
    String goods_name;
    Integer price;
    String saler;
    Integer sales;
    Integer stocks;
    Integer img_id;

    public Goods() {
    }

    public Goods(Integer id, String goods_name, Integer price, String saler, Integer sales, Integer stocks, Integer img_id) {
        this.id = id;
        this.goods_name = goods_name;
        this.price = price;
        this.saler = saler;
        this.sales = sales;
        this.stocks = stocks;
        this.img_id = img_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", price=" + price +
                ", saler='" + saler + '\'' +
                ", sales=" + sales +
                ", stocks=" + stocks +
                ", img_id=" + img_id +
                '}';
    }
}
