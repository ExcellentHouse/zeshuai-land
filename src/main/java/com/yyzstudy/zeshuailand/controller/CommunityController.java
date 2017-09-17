package com.yyzstudy.zeshuailand.controller;


import com.yyzstudy.zeshuailand.model.dto.CommunityFilterDTO;
import com.yyzstudy.zeshuailand.model.dto.Response;
import com.yyzstudy.zeshuailand.model.po.Community;
import com.yyzstudy.zeshuailand.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
    public Response search(CommunityFilterDTO communityFilterDTO){
        System.out.println(communityFilterDTO);
        List<Community> list = communityService.filter(communityFilterDTO);
        Map<String, Object> result =
                new HashMap<>();
        result.put( "communityList", list);
        return Response.ok("ok", result);
    }

}
