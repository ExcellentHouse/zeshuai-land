package com.yyzstudy.zeshuailand.controller;

import com.yyzstudy.zeshuailand.model.dto.Response;
import com.yyzstudy.zeshuailand.service.PeopleService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("people")
public class PersonalPageController {


    @Autowired
    private PeopleService peopleService;


    @GetMapping("profile/{username}")
    public Response personalData( @PathVariable("username") String username){
        Map<String, Object> result = new HashMap<>();
        result.put("personalInformation", peopleService.findByUsername(username));
        return Response.ok("ok", result);
    }

    @PostMapping("profile/change/password")
    public Response changePassword( String username, String password){
        return Response.ok();
    }




}
