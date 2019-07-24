package com.gu.pinyougou.manager.controller;

import com.gu.pinyougou.entity.SpecAndOpti;
import com.gu.pinyougou.entity.Specification;
import com.gu.pinyougou.entity.SpecificationOption;
import com.gu.pinyougou.sellergoods.service.SpecificationOptionService;
import com.gu.pinyougou.sellergoods.service.SpecificationService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Specification")
public class SpecificationController {
    @Reference
    private SpecificationService bs;
    @Reference
    private SpecificationOptionService sos;

    private List<Integer> ids = new ArrayList<>();

    @RequestMapping("findAll")
    public List<Specification> findAll() {
        System.out.println(bs);
        return bs.findAll();
    }

    @RequestMapping("partPage/{page}/{rows}")
    public Map<String, Object> partPage(@PathVariable("page") Integer page, @PathVariable("rows") Integer rows, @RequestBody(required = false) Specification Specification) {
        System.out.println(Specification);
        System.out.println(page + " === " + rows);
        Map<String, Object> dataMap = bs.partPage(page, rows, Specification);
        return dataMap;
    }

    @RequestMapping("delete")
    public boolean delete(@RequestBody Integer[] ids) {
        for (Integer id : ids) {
            sos.deleteBySpecId(Long.valueOf(id));
        }
        bs.delete(ids);
        return true;
    }

    @RequestMapping("saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody SpecAndOpti specAndOpti) {
        System.out.println(specAndOpti);
        int successCount = 0;
        int total = 0;
        if (specAndOpti.getSpecification().getId() != null) {
            boolean update = false;
            try {
                update = bs.update(specAndOpti.getSpecification());
                if(sos.deleteBySpecId(specAndOpti.getSpecification().getId())){
                    List<SpecificationOption> specificationOption = specAndOpti.getSpecificationOption();
                    total = specificationOption.size();
                    for (SpecificationOption option : specificationOption) {
                        option.setSpecId(specAndOpti.getSpecification().getId());
                        update = sos.save(option);
                        if(update){
                            successCount++;
                        }
                    }
                    if(successCount == total){
                        return true;
                    }else{
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }

            return update;
        }
        try {
            Long id = bs.save(specAndOpti.getSpecification());
            System.out.println(id);
            for (SpecificationOption specificationOption : specAndOpti.getSpecificationOption()) {
                specificationOption.setSpecId(id);
                sos.save(specificationOption);
            }
            return id != 0 ? true : false;
        } catch (Exception e) {
            return false;
        }
    }
    @RequestMapping("doUpdate/{id}")
    public List<SpecificationOption> doUpdate(@PathVariable("id") Integer id){
        return sos.findBySpedId(id);
    }
    @RequestMapping("findSpecAllForTypeTemplate")
    public List<Map<String,String>> findSpecAllForTypeTemplate(){
        return bs.findSpecAllForTypeTemplate();
    }
}
