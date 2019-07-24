package com.gu.pinyougou.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gu.pinyougou.entity.SpecificationOption;
import com.gu.pinyougou.mapper.SpecificationOptionMapper;
import com.gu.pinyougou.sellergoods.service.SpecificationOptionService;
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
public class SpecificationOptionServiceImpl implements SpecificationOptionService {
    @Autowired
    private com.gu.pinyougou.mapper.SpecificationOptionMapper SpecificationOptionMapper;
    @Transactional(readOnly = true)
    @Override
    public List<SpecificationOption> findAll() {
        return SpecificationOptionMapper.findAll(null);
    }

    @Override
    public Map<String, Object> partPage(Integer page, Integer rows,SpecificationOption SpecificationOption) {
        Map<String,Object> dataMap = new HashMap<String,Object>();
        PageHelper.startPage(page,rows);
        List<SpecificationOption> all = SpecificationOptionMapper.findAll(SpecificationOption);
        PageInfo<SpecificationOption> pi = new PageInfo<>(all);
        dataMap.put("total", pi.getTotal());
        dataMap.put("rows",pi.getList());
        return dataMap;
    }

    @Override
    public boolean save(SpecificationOption SpecificationOption) {
        int i = SpecificationOptionMapper.insertSelective(SpecificationOption);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean update(SpecificationOption SpecificationOption) {
        int i = SpecificationOptionMapper.updateByPrimaryKeySelective(SpecificationOption);
        System.out.println(i);
        return i == 0 ? false : true;
    }

    @Override
    public boolean delete(Integer[] ids) {
        SpecificationOptionMapper.deleteByIds(ids);
        return false;
    }

    @Override
    public List<SpecificationOption> findBySpedId(Integer id) {
        return SpecificationOptionMapper.findBySpedId(id);
    }

    @Override
    public boolean deleteBySpecId(Long id) {
        SpecificationOptionMapper.deleteBySpecId(id);
        return true;
    }
}

