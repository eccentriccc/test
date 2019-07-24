package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.Goods;
import com.gu.pinyougou.sellergoods.service.GoodsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Goods")
public class GoodsController {
    @Reference
    private GoodsService bs;
    @RequestMapping("findAll")
    public List<Goods> findAll(){
        System.out.println(bs);
        return bs.findAll();
    }
    @RequestMapping("partPage/{page}/{rows}")
    public Map<String,Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows,@RequestBody(required = false) Goods Goods){
        System.out.println(Goods);
        System.out.println(page + " === " + rows);
        Map<String,Object> dataMap = bs.partPage(page,rows,Goods);
        return dataMap;
    }
    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer [] ids){
        bs.delete(ids);
        return true;
    }
}
