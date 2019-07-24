package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.TypeTemplate;
import com.gu.pinyougou.sellergoods.service.TypeTemplateService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("TypeTemplate")
public class TypeTemplateController {
    @Reference
    private TypeTemplateService bs;
    @RequestMapping("findAll")
    public List<TypeTemplate> findAll(){
        System.out.println(bs);
        return bs.findAll();
    }
    @RequestMapping("select2One/{typeId}")
    public Map<Long,String> select2One(@PathVariable("typeId")Integer id){
        return bs.select2One(id);
    }
    @RequestMapping("select2List")
    public List<Map<Long,String>> select2List(){
        return bs.select2List();
    }
    @RequestMapping("partPage/{page}/{rows}")
    public Map<String,Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows,@RequestBody(required = false) TypeTemplate TypeTemplate){
        System.out.println(TypeTemplate);
        System.out.println(page + " === " + rows);
        Map<String,Object> dataMap = bs.partPage(page,rows,TypeTemplate);
        return dataMap;
    }
    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer [] ids){
        bs.delete(ids);
        return true;
    }
    @RequestMapping("saveOrUpdate")
    public boolean save(@RequestBody TypeTemplate TypeTemplate){
        System.out.println(TypeTemplate);
        if(TypeTemplate.getId() != null){
            boolean update = false;
            try {
                update = bs.update(TypeTemplate);
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        boolean save = false;
        try {
            save = bs.save(TypeTemplate);
        } catch (Exception e) {
           return false;
        }
        return save;
    }
    @RequestMapping("findById/{id}")
    public TypeTemplate findById(@PathVariable("id")Integer id){
        return bs.findById(id);
    }
}
