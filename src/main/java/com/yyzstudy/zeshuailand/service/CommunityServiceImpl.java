package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.CommunityRepository;
import com.yyzstudy.zeshuailand.model.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public List<Community> findAllPageing(int index, int count) {
        Pageable pageable = new PageRequest(index, count);
        Page<Community> page =  communityRepository.findAll(pageable);
        return page.getContent();
    }
}
