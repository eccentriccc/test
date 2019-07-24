package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.ItemCat;
import com.gu.pinyougou.mapper.ItemCatMapper;
import com.gu.pinyougou.sellergoods.service.ItemCatService;
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
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private com.gu.pinyougou.mapper.ItemCatMapper ItemCatMapper;
    @Transactional(readOnly = true)
    @Override
    public List<ItemCat> findAll() {
        return ItemCatMapper.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows,ItemCat ItemCat) {
        Map<String,Object> dataMap = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List<ItemCat> all = ItemCatMapper.findAll(ItemCat);
        PageInfo<ItemCat> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows",pi.getList());
        return dataMap;
    }

    @Override
    public boolean save(ItemCat ItemCat) {
        int i = ItemCatMapper.insertSelective(ItemCat);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean update(ItemCat ItemCat) {
        int i = ItemCatMapper.updateByPrimaryKeySelective(ItemCat);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        ItemCatMapper.deleteByIds(ids);
        return false;
    }

    @Override
    public List<ItemCat> findByParentId(Integer parentId) {
        return ItemCatMapper.findByParentId(parentId);
    }
}

