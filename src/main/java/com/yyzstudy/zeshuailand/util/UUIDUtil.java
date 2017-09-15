package com.yyzstudy.zeshuailand.util;

import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class UUIDUtil {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
