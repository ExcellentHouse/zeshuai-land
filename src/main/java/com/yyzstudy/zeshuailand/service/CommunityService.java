package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.model.Community;

import java.util.List;

public interface CommunityService {
    public List<Community> findAllPageing(int page, int count);
}
