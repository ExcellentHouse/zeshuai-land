package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.PeopleRepository;
import com.yyzstudy.zeshuailand.model.PeopleJwt;
import com.yyzstudy.zeshuailand.model.po.People;
import com.yyzstudy.zeshuailand.model.po.Role;
import com.yyzstudy.zeshuailand.util.JwtTokenUtil;
import com.yyzstudy.zeshuailand.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class AuthServiceImpl implements AuthService{


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${people.register.avatar}")
    public final String DEFAULT_AVATAR_PATH ;


    public AuthServiceImpl() {
        this.DEFAULT_AVATAR_PATH = "";
    }


    @Override
    public People register(People peopleToAdd) {

        //是否重复的用户名
        if( peopleRepository.findByUsername(peopleToAdd.getUsername()) != null){
            return null;
        }
        //设置uuid
        peopleToAdd.setId(UUIDUtil.getUUID());

        //密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = peopleToAdd.getPassword();
        peopleToAdd.setPassword(encoder.encode(rawPassword));

        //设置头像路径
        peopleToAdd.setAvatar(DEFAULT_AVATAR_PATH);

        //设置默认角色
        Role role = new Role(1);
        peopleToAdd.setRoles(new ArrayList<>(Arrays.asList(role)));

        peopleRepository.save(peopleToAdd);
        return peopleToAdd;
    }

    @Override
    public PeopleJwt login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken
                = new UsernamePasswordAuthenticationToken(username,password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);


        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        PeopleJwt peopleJwt = (PeopleJwt)userDetails;
        final String token = jwtTokenUtil.generateToken(userDetails);
        peopleJwt.setToken(token);
        return peopleJwt;

    }


    public PeopleRepository getPeopleRepository() {
        return peopleRepository;
    }

    public void setPeopleRepository(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public String getDEFAULT_AVATAR_PATH() {
        return DEFAULT_AVATAR_PATH;
    }


}
