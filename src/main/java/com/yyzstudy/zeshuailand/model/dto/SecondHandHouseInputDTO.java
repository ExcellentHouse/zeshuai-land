package com.yyzstudy.zeshuailand.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class SecondHandHouseInputDTO {
    private String one;
    List<MultipartFile> files;


    public SecondHandHouseInputDTO() {
    }

    @Override
    public String toString() {
        return "SecondHandHouseInputDTO{" +
                "one='" + one + '\'' +
                ", files=" + files +
                '}';
    }
}
