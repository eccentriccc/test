package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.GoodsDesc;
import com.gu.pinyougou.sellergoods.service.GoodsDescService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("GoodsDesc")
public class GoodsDescController {
    @Reference
    private GoodsDescService bs;
    @RequestMapping("findAll")
    public List<GoodsDesc> findAll(){
        System.out.println(bs);
        return bs.findAll();
    }
    @RequestMapping("partPage/{page}/{rows}")
    public Map<String,Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows,@RequestBody(required = false) GoodsDesc GoodsDesc){
        System.out.println(GoodsDesc);
        System.out.println(page + " === " + rows);
        Map<String,Object> dataMap = bs.partPage(page,rows,GoodsDesc);
        return dataMap;
    }
    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer [] ids){
        bs.delete(ids);
        return true;
    }
    @RequestMapping("saveOrUpdate")
    public boolean save(@RequestBody GoodsDesc GoodsDesc){
        System.out.println(GoodsDesc);
        if(GoodsDesc.getGoodsId() != null){
            boolean update = false;
            try {
                update = bs.update(GoodsDesc);
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        boolean save = false;
        try {
            save = bs.save(GoodsDesc);
        } catch (Exception e) {
           return false;
        }
        return save;
    }
}
