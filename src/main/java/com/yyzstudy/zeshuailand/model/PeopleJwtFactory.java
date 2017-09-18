package com.yyzstudy.zeshuailand.model;

import com.yyzstudy.zeshuailand.model.po.People;
import com.yyzstudy.zeshuailand.model.po.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class PeopleJwtFactory {

    private PeopleJwtFactory() {
    }


    public static PeopleJwt create (People people){
        return new PeopleJwt(
                people.getId(),
                people.getUsername(),
                people.getPassword(),
                people.getNickname(),
                people.getEmail(),
                people.getName(),
                people.getIdNumber(),
                people.getSex(),
                people.getAvatar(),
                mapToGrantedAuthorities(people.getRoles())
                );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {

        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());


    }

}
