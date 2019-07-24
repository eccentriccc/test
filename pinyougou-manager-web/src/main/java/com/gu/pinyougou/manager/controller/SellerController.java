package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.Seller;
import com.gu.pinyougou.sellergoods.service.SellerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Seller")
public class SellerController {
    @Reference
    private SellerService bs;
    @RequestMapping("findAll")
    public List<Seller> findAll(){
        System.out.println(bs);
        return bs.findAll();
    }
    @RequestMapping("partPage/{page}/{rows}")
    public Map<String,Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows,@RequestBody(required = false) Seller Seller){
        System.out.println(Seller);
        System.out.println(page + " === " + rows);
        Map<String,Object> dataMap = bs.partPage(page,rows,Seller);
        return dataMap;
    }
    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer [] ids){
        bs.delete(ids);
        return true;
    }
    @RequestMapping("saveOrUpdate")
    public boolean save(@RequestBody Seller Seller){
        System.out.println(Seller);
        if(Seller.getSellerId() != null){
            boolean update = false;
            try {
                update = bs.update(Seller);
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        boolean save = false;
        try {
            save = bs.save(Seller);
        } catch (Exception e) {
           return false;
        }
        return save;
    }
}
