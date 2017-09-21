package com.yyzstudy.zeshuailand.controller;

import com.yyzstudy.zeshuailand.model.dto.Response;
import com.yyzstudy.zeshuailand.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
@RestController
@RequestMapping("check")
public class JwtCheckController {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping( value = "/jwt/{token:.+}")
    public Response checkJwt(@PathVariable("token") String jwt, HttpServletRequest request){
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(jwt);
        HashMap<String, Object> result =
                new HashMap<>();
        result.put("isExpired", jwtTokenUtil.isTokenExpired(jwt));
        result.put("result",jwt);
        return Response.ok("ok", result);
    }

















    public JwtTokenUtil getJwtTokenUtil() {
        return jwtTokenUtil;
    }

    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
}
