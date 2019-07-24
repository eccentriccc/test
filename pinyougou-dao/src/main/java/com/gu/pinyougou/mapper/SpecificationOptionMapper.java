package com.gu.pinyougou.mapper;

import com.gu.pinyougou.entity.SpecificationOption;

import java.util.List;

public interface SpecificationOptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecificationOption record);

    int insertSelective(SpecificationOption record);

    SpecificationOption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecificationOption record);

    int updateByPrimaryKey(SpecificationOption record);

    List<SpecificationOption> findAll(SpecificationOption specificationOption);

    void deleteByIds(Integer[] ids);

    List<SpecificationOption> findBySpedId(Integer id);

    int deleteBySpecId(Long id);
}