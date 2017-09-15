package com.yyzstudy.zeshuailand.controller;


import com.yyzstudy.zeshuailand.model.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouteController {


    @GetMapping(value = "/")
    public ModelAndView test(){
        return new ModelAndView("/view/index.html");
    }
}
