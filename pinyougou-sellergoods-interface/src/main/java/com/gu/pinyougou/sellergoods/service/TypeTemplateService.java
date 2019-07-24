package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.TypeTemplate;

import java.util.List;
import java.util.Map;

public interface TypeTemplateService {
    public List<TypeTemplate> findAll();

    public Map<String,Object> partPage(Integer page, Integer rows, TypeTemplate typeTemplate);

    boolean save(TypeTemplate typeTemplate);

    boolean update(TypeTemplate typeTemplate);

    boolean delete(Integer[] ids);

    TypeTemplate findById(Integer id);

    List<Map<Long, String>> select2List();

    Map<Long, String> select2One(Integer id);
}
