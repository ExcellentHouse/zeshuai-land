package com.yyzstudy.zeshuailand.controller;


import com.yyzstudy.zeshuailand.model.dto.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/upload")
    public Response upload(@RequestParam("file") MultipartFile file){

        return Response.ok();
    }
}
