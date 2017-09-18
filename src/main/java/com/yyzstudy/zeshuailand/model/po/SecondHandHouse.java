package com.yyzstudy.zeshuailand.model.po;

import javax.persistence.*;


@Entity(name = "SecondHandHouse")
@Table(name = "secondHandHouse")
public class SecondHandHouse {

    @Id
    private String id;


    @Column(name = "price")
    private Integer price;


    @OneToOne
    @JoinColumn(name = "house_id")
    private House house;


    public SecondHandHouse() {
    }

    public SecondHandHouse(String id, Integer price, House house) {
        this.id = id;
        this.price = price;
        this.house = house;
    }



    @Override
    public String toString() {
        return "SecondHandHouse{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", house=" + house +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
