package com.gu.pinyougou.entity;

import java.io.Serializable;
import java.util.List;

public class SpecAndOpti implements Serializable {
    private Specification specification;
    private List<SpecificationOption> specificationOption;

    @Override
    public String toString() {
        return "SpecAndOpti{" +
                "specification=" + specification +
                ", specificationOption=" + specificationOption +
                '}';
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<SpecificationOption> getSpecificationOption() {
        return specificationOption;
    }

    public void setSpecificationOption(List<SpecificationOption> specificationOption) {
        this.specificationOption = specificationOption;
    }
}
