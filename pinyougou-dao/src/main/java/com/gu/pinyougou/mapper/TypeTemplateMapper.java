package com.gu.pinyougou.mapper;

import com.gu.pinyougou.entity.TypeTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TypeTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TypeTemplate record);

    int insertSelective(TypeTemplate record);

    TypeTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TypeTemplate record);

    int updateByPrimaryKey(TypeTemplate record);

    List<TypeTemplate> findAll(TypeTemplate typeTemplate);

    void deleteByIds(@Param("ids") Integer[] ids);

    TypeTemplate findById(Integer id);

    List<Map<Long, String>> select2List();

    Map<Long, String> select2One(Integer id);
}