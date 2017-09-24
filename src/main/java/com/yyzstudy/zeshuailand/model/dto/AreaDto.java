package com.yyzstudy.zeshuailand.model.dto;

import java.util.List;

public class AreaDto {
    private String label;
    private String value;
    private List<AreaDto> children;



    public AreaDto() {
    }


    public AreaDto(String label, String value, List<AreaDto> children) {
        this.label = label;
        this.value = value;
        this.children = children;
    }


    @Override
    public String toString() {
        return "AreaDto{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", children=" + children +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<AreaDto> getChildren() {
        return children;
    }

    public void setChildren(List<AreaDto> children) {
        this.children = children;
    }
}
