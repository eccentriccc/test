package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.Brand;
import com.gu.pinyougou.sellergoods.service.BrandService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Reference
    private BrandService bs;
    @RequestMapping("findAll")
    public List<Brand> findAll(){
        System.out.println(bs);
        return bs.findAll();
    }
    @RequestMapping("partPage/{page}/{rows}")
    public Map<String,Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows,@RequestBody(required = false) Brand brand){
        System.out.println(brand);
        System.out.println(page + " === " + rows);
        Map<String,Object> dataMap = bs.partPage(page,rows,brand);
        return dataMap;
    }
    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer [] ids){
        bs.delete(ids);
        return true;
    }
    @RequestMapping("saveOrUpdate")
    public boolean save(@RequestBody Brand brand){
        System.out.println(brand);
        if(brand.getId() != null){
            boolean update = false;
            try {
                update = bs.update(brand);
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        boolean save = false;
        try {
            save = bs.save(brand);
        } catch (Exception e) {
           return false;
        }
        return save;
    }
    @RequestMapping("findBrandAllForTypeTemplate")
    public List<Map<String,String>> findBrandAllForTypeTemplate(){
        return bs.findBrandAllForTypeTemplate();
    }
}
