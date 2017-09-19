package com.yyzstudy.zeshuailand.model.vo;

public class SecondHandHouseItem {

    private String id;
    private Integer room;
    private Integer hall;
    private Integer washroom;
    private Double area;
    private Integer floor;
    private String hasElevator;
    private String city;
    private String district;
    private String street;
    private String community;
    private Integer builtYear;
    private Integer price;
    private Integer average;
    private String path;
    private String remark;

    @Override
    public String toString() {
        return "SecondHandHouseItem{" +
                "id='" + id + '\'' +
                ", room=" + room +
                ", hall=" + hall +
                ", washroom=" + washroom +
                ", area=" + area +
                ", floor=" + floor +
                ", hasElevator='" + hasElevator + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", community='" + community + '\'' +
                ", builtYear=" + builtYear +
                ", price=" + price +
                ", average=" + average +
                ", path='" + path + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getWashroom() {
        return washroom;
    }

    public void setWashroom(Integer washroom) {
        this.washroom = washroom;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(String hasElevator) {
        this.hasElevator = hasElevator;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Integer getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(Integer builtYear) {
        this.builtYear = builtYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SecondHandHouseItem() {
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public SecondHandHouseItem(String id, Integer room, Integer hall, Integer washroom, Double area,Integer floor, String hasElevator, String city, String district, String street, String community, Integer builtYear, Integer price, Integer average, String path, String remark) {
        this.id = id;
        this.room = room;
        this.hall = hall;
        this.washroom = washroom;
        this.area = area;
        this.floor = floor;
        this.hasElevator = hasElevator;
        this.city = city;
        this.district = district;
        this.street = street;
        this.community = community;
        this.builtYear = builtYear;
        this.price = price;
        this.average = average;
        this.path = path;
        this.remark = remark;
    }
}
