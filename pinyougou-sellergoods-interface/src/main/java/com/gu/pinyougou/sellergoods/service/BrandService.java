package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<Brand> findAll();

    public Map<String,Object> partPage(Integer page,Integer rows,Brand brand);

    boolean save(Brand brand);

    boolean update(Brand brand);

    boolean delete(Integer[] ids);

    List<Map<String, String>> findBrandAllForTypeTemplate();
}
