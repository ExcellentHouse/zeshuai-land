package com.yyzstudy.zeshuailand.model.dto;

public class SecondHandHouseInputDTO {
    private String one;
    private String two;
    private String three;

    public SecondHandHouseInputDTO() {
    }

    public SecondHandHouseInputDTO(String one, String two, String three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Override
    public String toString() {
        return "SecondHandHouseInputDTO{" +
                "one='" + one + '\'' +
                ", two='" + two + '\'' +
                ", three='" + three + '\'' +
                '}';
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }
}
