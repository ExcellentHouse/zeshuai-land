package com.yyzstudy.zeshuailand.controller;


import com.yyzstudy.zeshuailand.model.dto.Response;
import com.yyzstudy.zeshuailand.model.dto.SecondHandHouseFilterDTO;
import com.yyzstudy.zeshuailand.model.po.SecondHandHouse;
import com.yyzstudy.zeshuailand.service.SecondHandHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/secondHandHouse")
public class SecondHandHouseController {

    @Autowired
    private SecondHandHouseService secondHandHouseService;

    @GetMapping("/")
    public Response index(){
        Map<String, Object> result =
                new HashMap<>();
        result.put("secondHandHouseList",
                secondHandHouseService.convertToSecondHandHouseItem(
                        secondHandHouseService.findAllPaging(0,10)
                ));
        return Response.ok("ok", result);
    }
    @GetMapping("/filter")
    public Response filter(SecondHandHouseFilterDTO secondHandHouseFilterDTO,int index, int count){
        System.out.println(secondHandHouseFilterDTO);
        System.out.println(index);
        System.out.println(count);
        Page<SecondHandHouse> page =
                secondHandHouseService.filter(secondHandHouseFilterDTO, index, count);
        Map<String, Object> result = new HashMap<>();

        result.put("secondHandHouseList",secondHandHouseService.convertToSecondHandHouseItem(page.getContent()));
        result.put("allPage", page.getTotalPages());
        return Response.ok("ok", result);
    }
}
