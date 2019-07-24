package com.gu.pinyougou.mapper;

import com.gu.pinyougou.entity.Specification;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpecificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);

    List<Specification> findAll(Specification specification);

    void deleteByIds(@Param("ids") Integer[] ids);

    List<Map<String, String>> findSpecAllForTypeTemplate();
}