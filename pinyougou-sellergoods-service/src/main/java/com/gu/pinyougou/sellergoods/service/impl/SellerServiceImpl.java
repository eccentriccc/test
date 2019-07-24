package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.Seller;
import com.gu.pinyougou.mapper.SellerMapper;
import com.gu.pinyougou.sellergoods.service.SellerService;
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
public class SellerServiceImpl implements SellerService {
    @Autowired
    private com.gu.pinyougou.mapper.SellerMapper SellerMapper;
    @Transactional(readOnly = true)
    @Override
    public List<Seller> findAll() {
        return SellerMapper.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows,Seller Seller) {
        Map<String,Object> dataMap = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List<Seller> all = SellerMapper.findAll(Seller);
        PageInfo<Seller> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows",pi.getList());
        System.out.println(pi.getList());
        return dataMap;
    }

    @Override
    public boolean save(Seller Seller) {
        int i = SellerMapper.insertSelective(Seller);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean update(Seller Seller) {
        int i = SellerMapper.updateByPrimaryKeySelective(Seller);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        SellerMapper.deleteByIds(ids);
        return false;
    }

    @Override
    public Seller selectById(String id) {
        return SellerMapper.selectByPrimaryKey(id);
    }
}

