package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.Item;
import com.gu.pinyougou.mapper.ItemMapper;
import com.gu.pinyougou.sellergoods.service.ItemService;
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
public class ItemServiceImpl implements ItemService {
    @Autowired
    private com.gu.pinyougou.mapper.ItemMapper ItemMapper;
    @Transactional(readOnly = true)
    @Override
    public List<Item> findAll() {
        return ItemMapper.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows, Item Item) {
        Map<String,Object> dataMap = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List<Item> all = ItemMapper.findAll(Item);
        PageInfo<Item> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows",pi.getList());
        return dataMap;
    }

    @Override
    public boolean save(Item Item) {
        int i = ItemMapper.insertSelective(Item);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean update(Item Item) {
        int i = ItemMapper.updateByPrimaryKeySelective(Item);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        ItemMapper.deleteByIds(ids);
        return false;
    }
}

