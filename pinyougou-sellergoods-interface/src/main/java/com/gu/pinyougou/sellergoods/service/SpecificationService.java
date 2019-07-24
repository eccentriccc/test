package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.Specification;

import java.util.List;
import java.util.Map;

public interface SpecificationService {
    public List<Specification> findAll();

    public Map<String,Object> partPage(Integer page, Integer rows, Specification specification);

    long save(Specification specification);

    boolean update(Specification specification);

    boolean delete(Integer[] ids);

    List<Map<String, String>> findSpecAllForTypeTemplate();
}
