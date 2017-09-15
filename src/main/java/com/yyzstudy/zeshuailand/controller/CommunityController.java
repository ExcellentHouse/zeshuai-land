package com.yyzstudy.zeshuailand.controller;


import com.yyzstudy.zeshuailand.model.dto.Response;
import com.yyzstudy.zeshuailand.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping("/")
    public Response index(){
        Map<String, Object> result =
                new HashMap<>();
        result.put("communityList", communityService.findAllPageing(0,10));
        return Response.ok("ok", result);
    }

    @GetMapping("/filter")
    public Response search(String city,
                           String district,
                           String street,
                           String average,
                           String houseAge){
        System.out.println(city);
        System.out.println(district);
        System.out.println(street);
        System.out.println(average);
        System.out.println(houseAge);
        Map<String, Object> result =
                new HashMap<>();
        return Response.ok("ok", "asfasdf");
    }

}
