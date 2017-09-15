package com.yyzstudy.zeshuailand.controller;


import com.yyzstudy.zeshuailand.model.Response;
import com.yyzstudy.zeshuailand.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/area")
public class AreaController {


    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/")
    public Response getAllCity(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("city", areaService.findAllCity());
        return Response.ok("success",result);
    }


    @GetMapping(value = "{city}")
    public Response getAllDistrictByCity(@PathVariable("city") String city){
        HashMap<String,Object> result = new HashMap<>();
        result.put("district", areaService.findAllDistrictByCity(city));
        return Response.ok("ok",result);
    }


    @GetMapping(value = "{city}/{district}")
    public Response getAllStreetByCityAndDistrict(@PathVariable("city") String city,
                                                  @PathVariable("district") String district){
        HashMap<String, Object> result = new HashMap<>();
        result.put("street",areaService.findAllStreetByCityAndDistrict(city,district));
        return Response.ok("ok", result);
    }








}
