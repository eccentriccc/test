package com.gu.pinyougou.sellergoods.service;

import com.gu.pinyougou.entity.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {
    public List<Item> findAll();

    public Map<String,Object> partPage(Integer page, Integer rows, Item item);

    boolean save(Item item);

    boolean update(Item item);

    boolean delete(Integer[] ids);
}
