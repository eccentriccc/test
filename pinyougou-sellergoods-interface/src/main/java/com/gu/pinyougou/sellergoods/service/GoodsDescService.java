package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.GoodsDesc;

import java.util.List;
import java.util.Map;

public interface GoodsDescService {
    public List<GoodsDesc> findAll();

    public Map<String,Object> partPage(Integer page, Integer rows, GoodsDesc goodsDesc);

    boolean save(GoodsDesc goodsDesc);

    boolean update(GoodsDesc goodsDesc);

    boolean delete(Integer[] ids);
}
