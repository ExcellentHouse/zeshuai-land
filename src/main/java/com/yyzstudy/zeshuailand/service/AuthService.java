package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.model.po.People;

public interface AuthService {

    public People register(People people);

    public String login(People people);

}
