package com.yyzstudy.zeshuailand.model.po;


import com.yyzstudy.zeshuailand.model.po.Area;

import javax.persistence.*;

@Entity
public class Community {

    @Id
    private String id;


    @Column(name = "name")
    private String name;

    @Column(name = "detailedaddress")
    private String detailedAddress;

    @Column(name = "builtyear")
    private Integer builtYear;

    @Column(name = "housetype")
    private String houseType;

    @Column(name = "average")
    private Double average;

    @Column(name = "housenumber")
    private Integer houseNumber;

    @Column(name = "path")
    private String path;


    @OneToOne
    @JoinColumn(name = "area_id")
    private Area area;


    public Community() {
    }




    public Community(String id, String name, String detailedAddress, Integer builtYear, String houseType, Double average, Integer houseNumber, String path, Area area) {
        this.id = id;
        this.name = name;
        this.detailedAddress = detailedAddress;
        this.builtYear = builtYear;
        this.houseType = houseType;
        this.average = average;
        this.houseNumber = houseNumber;
        this.path = path;
        this.area = area;
    }


    @Override
    public String toString() {
        return "Community{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", builtYear=" + builtYear +
                ", houseType='" + houseType + '\'' +
                ", average=" + average +
                ", houseNumber=" + houseNumber +
                ", path='" + path + '\'' +
                ", area=" + area +
                '}';
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Integer getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(Integer builtYear) {
        this.builtYear = builtYear;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
