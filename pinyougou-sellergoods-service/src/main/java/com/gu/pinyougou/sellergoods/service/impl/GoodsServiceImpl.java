package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.Goods;
import com.gu.pinyougou.entity.GoodsAndDesc;
import com.gu.pinyougou.entity.GoodsDesc;
import com.gu.pinyougou.mapper.GoodsDescMapper;
import com.gu.pinyougou.mapper.GoodsMapper;
import com.gu.pinyougou.sellergoods.service.GoodsService;
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
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private com.gu.pinyougou.mapper.GoodsMapper GoodsMapper;
    @Autowired
    private GoodsDescMapper gdm;

    @Transactional(readOnly = true)
    @Override
    public List<Goods> findAll() {
        return GoodsMapper.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows, Goods Goods) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        PageHelper.startPage(page, rows);
        List<Goods> all = GoodsMapper.findAll(Goods);
        PageInfo<Goods> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows", pi.getList());
        return dataMap;
    }

    @Override
    public boolean save(GoodsAndDesc goodsAndDesc) {
        Goods goods = goodsAndDesc.getGoods();
        GoodsDesc goodsDesc = goodsAndDesc.getGoodsDesc();
        int i = GoodsMapper.insertSelective(goods);
        int i1 = 0;
        if(i != 0){
            goodsDesc.setGoodsId(goods.getId());
           i1 = gdm.insertSelective(goodsDesc);
        }
        System.out.println(i);
        return i == 0 || i1 == 0 ? false : true;
    }

    @Override
    public boolean update(GoodsAndDesc goodsAndDesc) {
        Goods goods = goodsAndDesc.getGoods();
        GoodsDesc goodsDesc = goodsAndDesc.getGoodsDesc();
        int i = GoodsMapper.updateByPrimaryKeySelective(goods);
        int i1 = 0;
        if (i != 0) {
            goodsDesc.setGoodsId(goods.getId());
            i1 = gdm.updateByPrimaryKeySelective(goodsDesc);
        }
        System.out.println(i);
        return i == 0 || i1 == 0? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        GoodsMapper.deleteByIds(ids);
        return false;
    }
}

