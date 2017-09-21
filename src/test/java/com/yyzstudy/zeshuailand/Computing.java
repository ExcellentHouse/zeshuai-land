package com.yyzstudy.zeshuailand;


import com.yyzstudy.zeshuailand.dao.AreaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Computing {

    @Autowired
    private AreaRepository areaRepository;


    @Test
    public void test(){
        areaRepository.findAll().stream().collect(Collectors.groupingBy(x -> x.getCity()));

        System.out.println(areaRepository.findAll().stream().collect(Collectors.groupingBy(x -> x.getCity())));
    }

}
