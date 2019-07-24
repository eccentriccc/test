package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.ItemCat;

import java.util.List;
import java.util.Map;

public interface ItemCatService {
    public List<ItemCat> findAll();

    public Map<String,Object> partPage(Integer page, Integer rows, ItemCat itemCat);

    boolean save(ItemCat itemCat);

    boolean update(ItemCat itemCat);

    boolean delete(Integer[] ids);

    List<ItemCat> findByParentId(Integer parentId);
}
