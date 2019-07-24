package com.gu.pinyougou.entity;

import java.io.Serializable;
import java.util.List;

public class GoodsAndDesc implements Serializable {
    private Goods goods;
    private GoodsDesc goodsDesc;
    private List<Item> itemList;
    @Override
    public String toString() {
        return "GoodsAndDesc{" +
                "goods=" + goods +
                ", goodsDesc=" + goodsDesc +
                '}';
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(GoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}
