package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.SpecificationOption;
import com.gu.pinyougou.sellergoods.service.SpecificationOptionService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("SpecificationOption")
public class SpecificationOptionController {
    @Reference
    private SpecificationOptionService bs;
    @RequestMapping("findAll")
    public List<SpecificationOption> findAll(){
        System.out.println(bs);
        return bs.findAll();
    }
    @RequestMapping("partPage/{page}/{rows}")
    public Map<String,Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows,@RequestBody(required = false) SpecificationOption SpecificationOption){
        System.out.println(SpecificationOption);
        System.out.println(page + " === " + rows);
        Map<String,Object> dataMap = bs.partPage(page,rows,SpecificationOption);
        return dataMap;
    }
    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer [] ids){
        bs.delete(ids);
        return true;
    }
    @RequestMapping("saveOrUpdate")
    public boolean save(@RequestBody SpecificationOption SpecificationOption){
        System.out.println(SpecificationOption);
        if(SpecificationOption.getId() != null){
            boolean update = false;
            try {
                update = bs.update(SpecificationOption);
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        boolean save = false;
        try {
            save = bs.save(SpecificationOption);
        } catch (Exception e) {
           return false;
        }
        return save;
    }
}
