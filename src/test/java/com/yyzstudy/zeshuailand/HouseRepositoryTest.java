package com.yyzstudy.zeshuailand;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.yyzstudy.zeshuailand.dao.HouseRepository;
import com.yyzstudy.zeshuailand.dao.SecondHandHouseRepository;
import com.yyzstudy.zeshuailand.model.dto.SecondHandHouseFilterDTO;
import com.yyzstudy.zeshuailand.model.po.SecondHandHouse;
import com.yyzstudy.zeshuailand.service.SecondHandHouseService;
import com.yyzstudy.zeshuailand.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseRepositoryTest {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private SecondHandHouseRepository secondHandHouseRepository;

    @Autowired
    private SecondHandHouseService secondHandHouseService;

    @Test
    public void testpeopleRepository(){
        System.out.println(secondHandHouseService.findAllPaging(0,10));

    }

    @Test
    public void testStringSplit(){
        SecondHandHouseFilterDTO secondHandHouseFilterDTO =
                new SecondHandHouseFilterDTO("抚顺市","","","","","");
        List<SecondHandHouse> list  = secondHandHouseService.filter(secondHandHouseFilterDTO,0,1).getContent();
        SecondHandHouse secondHandHouse = list.get(0);
        IntStream.rangeClosed(0, 103)
                .forEach(i -> {
                    secondHandHouse.setId(UUIDUtil.getUUID());
                    secondHandHouseRepository.save(secondHandHouse);
                });

////        Arrays.stream("asdfasdfsaf;asdfasdf;".split(";")).forEach(x -> System.out.println(x));
//        String test = "1+";
//        System.out.println(test.charAt(test.length() - 1));
//
//        System.out.println(test.substring(0,test.length() - 1));
    }
}
