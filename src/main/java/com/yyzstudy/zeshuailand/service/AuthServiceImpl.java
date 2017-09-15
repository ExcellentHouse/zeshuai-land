package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.PeopleRepository;
import com.yyzstudy.zeshuailand.model.po.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService{



    @Autowired
    private PeopleRepository peopleRepository;



    @Override
    public People register(People peopleToAdd) {
        People people = peopleRepository.findByUsername(peopleToAdd.getUsername());
        if( people != null){
            return null;
        }
        String rawPassword = peopleToAdd.getPassword();
        return null;
    }

    @Override
    public String login(People people) {
        return null;
    }
}
