package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.ItemCat;
import com.gu.pinyougou.sellergoods.service.ItemCatService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ItemCat")
public class ItemCatController {
    @Reference
    private ItemCatService bs;
    @RequestMapping("findAll")
    public List<ItemCat> findAll(){
        System.out.println(bs);
        return bs.findAll();
    }
    @RequestMapping("findByParentId/{parentId}")
    public List<ItemCat> partPage(@PathVariable("parentId") Integer parentId){

        List<ItemCat> dataList =  bs.findByParentId(parentId);
        return dataList;
    }
    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer [] ids){
        bs.delete(ids);
        return true;
    }
    @RequestMapping("saveOrUpdate")
    public boolean save(@RequestBody ItemCat ItemCat){
        System.out.println(ItemCat);
        if(ItemCat.getId() != null){
            boolean update = false;
            try {
                update = bs.update(ItemCat);
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        boolean save = false;
        try {
            save = bs.save(ItemCat);
        } catch (Exception e) {
           return false;
        }
        return save;
    }
}
