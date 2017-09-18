package com.yyzstudy.zeshuailand;


import com.yyzstudy.zeshuailand.dao.HouseRepository;
import com.yyzstudy.zeshuailand.dao.SecondHandHouseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseRepositoryTest {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private SecondHandHouseRepository secondHandHouseRepository;

    @Test
    public void testpeopleRepository(){

        System.out.println(secondHandHouseRepository.findOne("06f063b82fc141759fdef2639b0ea9fa"));

    }
}
