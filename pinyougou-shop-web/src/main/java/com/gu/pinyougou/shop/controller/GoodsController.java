package com.gu.pinyougou.shop.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.gu.pinyougou.entity.*;
import com.gu.pinyougou.sellergoods.service.GoodsService;
import com.gu.pinyougou.sellergoods.service.ItemCatService;
import com.gu.pinyougou.sellergoods.service.SpecificationOptionService;
import com.gu.pinyougou.sellergoods.service.TypeTemplateService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Goods")
public class GoodsController {
    @Reference
    private GoodsService bs;
    @Reference
    private ItemCatService ics;
    @Reference
    private TypeTemplateService tts;
    @Reference
    private SpecificationOptionService sos;

    @RequestMapping("findAll")
    public List<Goods> findAll() {
        System.out.println(bs);
        return bs.findAll();
    }

    @RequestMapping("partPage/{page}/{rows}")
    public Map<String, Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows, @RequestBody(required = false) Goods Goods) {
        System.out.println(Goods);
        System.out.println(page + " === " + rows);
        Map<String, Object> dataMap = bs.partPage(page, rows, Goods);
        return dataMap;
    }

    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer[] ids) {
        bs.delete(ids);
        return true;
    }

    @RequestMapping("saveOrUpdate")
    public boolean save(@RequestBody GoodsAndDesc goodsAndDesc, Principal principal) {
        goodsAndDesc.getGoods().setSellerId(principal.getName());
        System.out.println(goodsAndDesc);
        if (goodsAndDesc.getGoods().getId() != null) {
            boolean update = false;
            try {
                update = bs.update(goodsAndDesc);
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        boolean save = false;
        try {
            save = bs.save(goodsAndDesc);
        } catch (Exception e) {
            return false;
        }
        return save;
    }

    @RequestMapping("loadSelect/{id}")
    public List<ItemCat> loadSelect(@PathVariable("id") Integer id) {
        return ics.findByParentId(id);
    }

    @RequestMapping("findTypeById/{id}")
    public Map<String, Object> findTypeById(@PathVariable("id") Integer id) {
        Map<String, Object> dataMap = new HashMap<>();
        TypeTemplate typeTemplate = tts.findById(id);
        List<Map> cust = JSON.parseArray(typeTemplate.getSpecIds(), Map.class);
        typeTemplate.setSpecIds(null);
        dataMap.put("typeTemplate", typeTemplate);
        for (Map map : cust) {
            Integer specId = (Integer) map.get("id");
            List<SpecificationOption> bySpedId = sos.findBySpedId(specId);
            map.put("specOption",bySpedId);
        }
        dataMap.put("specs",cust);
        System.out.println(dataMap);
        return dataMap;
    }
}
