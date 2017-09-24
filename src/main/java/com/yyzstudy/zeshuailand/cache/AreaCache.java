package com.yyzstudy.zeshuailand.cache;

import com.yyzstudy.zeshuailand.dao.AreaRepository;
import com.yyzstudy.zeshuailand.model.dto.AreaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AreaCache {
    @Autowired
    private AreaRepository areaRepository;

    private List<AreaDto> areaDtoList;



    public AreaCache() {
        areaDtoList = areaRepository.
                findAllCity().
                stream().map(x -> new AreaDto(x,x,new ArrayList<>()))
                .collect(Collectors.toList());
        areaDtoList.forEach(x -> areaRepository.
                findAllDistrictByCity(x.getValue()).forEach(y -> x.getChildren().add(new AreaDto(y,y, new ArrayList<>()))));

    }
}
