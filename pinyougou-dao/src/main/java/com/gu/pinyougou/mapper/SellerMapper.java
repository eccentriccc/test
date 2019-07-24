package com.gu.pinyougou.mapper;

import com.gu.pinyougou.entity.Seller;

import java.util.List;

public interface SellerMapper {
    int deleteByPrimaryKey(String sellerId);

    int insert(Seller record);

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(String sellerId);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);

    List<Seller> findAll(Seller seller);

    void deleteByIds(Integer[] ids);
}