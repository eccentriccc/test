package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.TypeTemplate;
import com.gu.pinyougou.mapper.TypeTemplateMapper;
import com.gu.pinyougou.sellergoods.service.TypeTemplateService;
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
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private com.gu.pinyougou.mapper.TypeTemplateMapper TypeTemplateMapper;
    @Transactional(readOnly = true)
    @Override
    public List<TypeTemplate> findAll() {
        return TypeTemplateMapper.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows,TypeTemplate TypeTemplate) {
        Map<String,Object> dataMap = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List<TypeTemplate> all = TypeTemplateMapper.findAll(TypeTemplate);
        PageInfo<TypeTemplate> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows",pi.getList());
        return dataMap;
    }

    @Override
    public boolean save(TypeTemplate TypeTemplate) {
        int i = TypeTemplateMapper.insertSelective(TypeTemplate);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean update(TypeTemplate TypeTemplate) {
        int i = TypeTemplateMapper.updateByPrimaryKeySelective(TypeTemplate);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        TypeTemplateMapper.deleteByIds(ids);
        return false;
    }

    @Override
    public TypeTemplate findById(Integer id) {
        return TypeTemplateMapper.findById(id);
    }

    @Override
    public List<Map<Long, String>> select2List() {
        return TypeTemplateMapper.select2List();
    }

    @Override
    public Map<Long, String> select2One(Integer id) {
        return TypeTemplateMapper.select2One(id);
    }
}

