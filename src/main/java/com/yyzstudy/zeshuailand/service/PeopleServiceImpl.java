package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.PeopleRepository;
import com.yyzstudy.zeshuailand.model.po.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeopleServiceImpl implements PeopleService{

    @Autowired
    private PeopleRepository peopleRepository;




    @Override
    public People findByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }
}
