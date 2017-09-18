package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.PeopleRepository;
import com.yyzstudy.zeshuailand.model.PeopleJwtFactory;
import com.yyzstudy.zeshuailand.model.po.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class PeopleJwtDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private PeopleRepository peopleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        People people = peopleRepository.findByUsername(username);
        if(people == null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }else{
            return PeopleJwtFactory.create(people);
        }
    }
}
