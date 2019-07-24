package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.GoodsDesc;
import com.gu.pinyougou.mapper.GoodsDescMapper;
import com.gu.pinyougou.sellergoods.service.GoodsDescService;
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
public class GoodsDescServiceImpl implements GoodsDescService {
    @Autowired
    private GoodsDescMapper GoodsDescMapper;
    @Transactional(readOnly = true)
    @Override
    public List<GoodsDesc> findAll() {
        return GoodsDescMapper.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows,GoodsDesc GoodsDesc) {
        Map<String,Object> dataMap = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List<GoodsDesc> all = GoodsDescMapper.findAll(GoodsDesc);
        PageInfo<GoodsDesc> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows",pi.getList());
        return dataMap;
    }

    @Override
    public boolean save(GoodsDesc GoodsDesc) {
        int i = GoodsDescMapper.insertSelective(GoodsDesc);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean update(GoodsDesc GoodsDesc) {
        int i = GoodsDescMapper.updateByPrimaryKeySelective(GoodsDesc);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        GoodsDescMapper.deleteByIds(ids);
        return false;
    }
}

