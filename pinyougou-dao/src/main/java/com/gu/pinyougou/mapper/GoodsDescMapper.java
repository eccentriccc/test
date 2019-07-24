package com.gu.pinyougou.mapper;

import com.gu.pinyougou.entity.GoodsDesc;

import java.util.List;

public interface GoodsDescMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(GoodsDesc record);

    int insertSelective(GoodsDesc record);

    GoodsDesc selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(GoodsDesc record);

    int updateByPrimaryKey(GoodsDesc record);

    List<GoodsDesc> findAll(Object o);

    void deleteByIds(Integer[] ids);
}