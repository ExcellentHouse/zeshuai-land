package com.yyzstudy.zeshuailand.controller;


import com.yyzstudy.zeshuailand.model.dto.Response;
import com.yyzstudy.zeshuailand.model.dto.SecondHandHouseFilterDTO;
import com.yyzstudy.zeshuailand.model.po.SecondHandHouse;
import com.yyzstudy.zeshuailand.service.SecondHandHouseService;
import com.yyzstudy.zeshuailand.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

    @PostMapping("upload")
    public Response upSecondHandHouse(@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        return Response.ok();
    }
    @PostMapping("batchupload")
    public Response batchupload(@RequestBody()SecondHandHouseFilterDTO secondHandHouseFilterDTO, HttpServletRequest request){
        System.out.println(secondHandHouseFilterDTO);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files[]");
        files.forEach(file -> {
            try(BufferedOutputStream stream  =
                        new BufferedOutputStream(
                                new FileOutputStream(new File(this.getClass().getClassLoader().getResource("").getPath()+"static/image/"+UUIDUtil.getUUID()+".jpg")))) {
                stream.write(file.getBytes());
                stream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(files.size());
        return Response.ok();
    }
}
