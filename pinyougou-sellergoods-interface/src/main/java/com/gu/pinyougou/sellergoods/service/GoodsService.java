package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.Goods;
import com.gu.pinyougou.entity.GoodsAndDesc;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    public List<Goods> findAll();

    public Map<String,Object> partPage(Integer page, Integer rows, Goods goods);

    boolean save(GoodsAndDesc goods);

    boolean update(GoodsAndDesc goods);

    boolean delete(Integer[] ids);
}
