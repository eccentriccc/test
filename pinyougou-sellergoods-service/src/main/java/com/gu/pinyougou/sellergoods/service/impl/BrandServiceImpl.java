package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.Brand;
import com.gu.pinyougou.mapper.BrandMapper;
import com.gu.pinyougou.sellergoods.service.BrandService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper bm;
    @Transactional(readOnly = true)
    @Override
    public List<Brand> findAll() {
        return bm.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows,Brand brand) {
        Map<String,Object> dataMap = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List<Brand> all = bm.findAll(brand);
        PageInfo<Brand> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows",pi.getList());
        return dataMap;
    }

    @Override
    public boolean save(Brand brand) {
        int i = bm.insertSelective(brand);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean update(Brand brand) {
        int i = bm.updateByPrimaryKeySelective(brand);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        bm.deleteByIds(ids);
        return false;
    }

    @Override
    public List<Map<String, String>> findBrandAllForTypeTemplate() {
        List<Map<String, String>> all = bm.findBrandAllForTypeTemplate();
        System.out.println(all);
        return all;
    }
}
