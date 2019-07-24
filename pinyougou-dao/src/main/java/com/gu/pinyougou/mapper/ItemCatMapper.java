package com.gu.pinyougou.mapper;

import com.gu.pinyougou.entity.ItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemCat record);

    int insertSelective(ItemCat record);

    ItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemCat record);

    int updateByPrimaryKey(ItemCat record);

    List<ItemCat> findAll(Object o);

    void deleteByIds(@Param("ids") Integer[] ids);

    List<ItemCat> findByParentId(Integer parentId);
}