package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.model.PeopleJwt;
import com.yyzstudy.zeshuailand.model.po.People;

public interface AuthService {

    public People register(People people);

    public PeopleJwt login(String people, String password);

}
