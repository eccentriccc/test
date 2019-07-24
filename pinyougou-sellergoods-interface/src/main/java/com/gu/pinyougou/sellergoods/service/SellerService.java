package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.Seller;

import java.util.List;
import java.util.Map;

public interface SellerService {
    public List<Seller> findAll();

    public Map<String,Object> partPage(Integer page, Integer rows, Seller seller);

    boolean save(Seller seller);

    boolean update(Seller seller);

    boolean delete(Integer[] ids);

    Seller selectById(String id);
}
