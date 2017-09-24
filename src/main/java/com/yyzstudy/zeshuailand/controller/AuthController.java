package com.yyzstudy.zeshuailand.controller;

import com.yyzstudy.zeshuailand.model.PeopleJwt;
import com.yyzstudy.zeshuailand.model.dto.Response;
import com.yyzstudy.zeshuailand.model.po.People;
import com.yyzstudy.zeshuailand.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;






    @PostMapping("/login")
    public Response login(@RequestBody People people){
        HashMap<String, Object> result = new HashMap<>();
        PeopleJwt peopleJwt = authService.login(people.getUsername(), people.getPassword());
        result.put("token",peopleJwt.getToken());
        result.put("people_id", peopleJwt.getId());
        result.put("nickname",peopleJwt.getNickname());
        result.put("username", peopleJwt.getUsername());
        return Response.ok("ok", result);
    }





    @PostMapping("/register")
    public Response register(@RequestBody  People peopleToAdd, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie);
            }
        }
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Set-Cookie","name_test111123=value_test111123; Path=/");
//
//        Cookie cookie = new Cookie("name_test111123","value_test111123");//创建新cookie
//        cookie.setPath("/");//设置作用域
////        cookie.setDomain("localhost");
//        response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端

        System.out.println(peopleToAdd);
        return Response.ok("ok", authService.register(peopleToAdd));
    }
}
