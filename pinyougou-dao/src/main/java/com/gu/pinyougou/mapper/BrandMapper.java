package com.gu.pinyougou.mapper;

import com.gu.pinyougou.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> findAll(Brand brand);

    int deleteByIds(@Param("ids") Integer[] ids);

    List<Map<String, String>> findBrandAllForTypeTemplate();
}