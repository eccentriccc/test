package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.SpecificationOption;

import java.util.List;
import java.util.Map;

public interface SpecificationOptionService {
    public List<SpecificationOption> findAll();

    public Map<String,Object> partPage(Integer page, Integer rows, SpecificationOption specificationOption);

    boolean save(SpecificationOption specificationOption);

    boolean update(SpecificationOption specificationOption);

    boolean delete(Integer[] ids);

    List<SpecificationOption> findBySpedId(Integer id);

    boolean deleteBySpecId(Long id);
}
