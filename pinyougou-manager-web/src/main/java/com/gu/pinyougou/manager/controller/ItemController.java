package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.Item;
import com.gu.pinyougou.sellergoods.service.ItemService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Item")
public class ItemController {
    @Reference
    private ItemService bs;
    @RequestMapping("findAll")
    public List<Item> findAll(){
        System.out.println(bs);
        return bs.findAll();
    }
    @RequestMapping("partPage/{page}/{rows}")
    public Map<String,Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows,@RequestBody(required = false) Item Item){
        System.out.println(Item);
        System.out.println(page + " === " + rows);
        Map<String,Object> dataMap = bs.partPage(page,rows,Item);
        return dataMap;
    }
    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer [] ids){
        bs.delete(ids);
        return true;
    }
    @RequestMapping("saveOrUpdate")
    public boolean save(@RequestBody Item Item){
        System.out.println(Item);
        if(Item.getId() != null){
            boolean update = false;
            try {
                update = bs.update(Item);
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        boolean save = false;
        try {
            save = bs.save(Item);
        } catch (Exception e) {
           return false;
        }
        return save;
    }
}
