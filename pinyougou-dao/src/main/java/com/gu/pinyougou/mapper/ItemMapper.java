package com.gu.pinyougou.mapper;

import com.gu.pinyougou.entity.Item;

import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> findAll(Item item);

    void deleteByIds(Integer[] ids);
}