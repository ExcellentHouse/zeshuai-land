package com.yyzstudy.zeshuailand.controller;


import com.yyzstudy.zeshuailand.model.dto.Response;
import com.yyzstudy.zeshuailand.model.po.People;
import com.yyzstudy.zeshuailand.service.AdminService;
import com.yyzstudy.zeshuailand.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PeopleService peopleService;



    @PostMapping("add")
    public Response addAdmin(@RequestBody People peopleToAdd){
        System.out.println(peopleToAdd);
        peopleToAdd = adminService.addAdmin(peopleToAdd);
        return Response.ok("ok",peopleToAdd);
    }

    @GetMapping("delete/{username}")
    public Response deleteAdmin(@PathVariable("username") String username){
        Map<String,Object> result = new HashMap<>();
        result.put("people",peopleService.findByUsername(username));
        return Response.ok("ok", result);
    }
}
