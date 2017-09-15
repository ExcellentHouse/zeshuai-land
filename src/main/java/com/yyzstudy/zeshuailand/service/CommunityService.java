package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.model.po.Community;

import java.util.List;

public interface CommunityService {
    public List<Community> findAllPageing(int page, int count);

    public List<Community> filter(String city,
                                  String district,
                                  String street,
                                  String average,
                                  String houseAge);
}
