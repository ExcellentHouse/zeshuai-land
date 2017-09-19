package com.yyzstudy.zeshuailand.model.dto;

public class SecondHandHouseFilterDTO {
    private String city;
    private String district;
    private String street;
    private String price;
    private String area;
    private String room;


    public SecondHandHouseFilterDTO() {
    }


    @Override
    public String toString() {
        return "SecondHandHouseFilterDTO{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", price='" + price + '\'' +
                ", area='" + area + '\'' +
                ", room=" + room +
                '}';
    }

    public SecondHandHouseFilterDTO(String city, String district, String street, String price, String area, String room) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.price = price;
        this.area = area;
        this.room = room;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
