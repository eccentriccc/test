package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.Specification;
import com.gu.pinyougou.mapper.SpecificationMapper;
import com.gu.pinyougou.sellergoods.service.SpecificationService;
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
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private com.gu.pinyougou.mapper.SpecificationMapper SpecificationMapper;
    @Transactional(readOnly = true)
    @Override
    public List<Specification> findAll() {
        return SpecificationMapper.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows,Specification Specification) {
        Map<String,Object> dataMap = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List<Specification> all = SpecificationMapper.findAll(Specification);
        PageInfo<Specification> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows",pi.getList());
        return dataMap;
    }

    @Override
    public long save(Specification specification) {
        int i = SpecificationMapper.insertSelective(specification);
        System.out.println(specification.getId());
        return specification.getId();
    }

    @Override
    public boolean update(Specification Specification) {
        int i = SpecificationMapper.updateByPrimaryKeySelective(Specification);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        SpecificationMapper.deleteByIds(ids);
        return false;
    }

    @Override
    public List<Map<String, String>> findSpecAllForTypeTemplate() {
        return SpecificationMapper.findSpecAllForTypeTemplate();
    }
}

