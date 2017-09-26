package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.PeopleRepository;
import com.yyzstudy.zeshuailand.model.po.People;
import com.yyzstudy.zeshuailand.model.po.Role;
import com.yyzstudy.zeshuailand.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private PeopleRepository peopleRepository;




    @Value("${people.register.avatar}")
    private   String DEFAULT_AVATAR_PATH ;
    @Value("${role.admin.id}")
    private   Integer DEFAULT_ADMIN_ID;


    @Override
    public People addAdmin(People peopleToAdd) {
        peopleToAdd.setId(UUIDUtil.getUUID());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = peopleToAdd.getPassword();
        peopleToAdd.setPassword(encoder.encode(rawPassword));

        ArrayList<Role> arrayList =
                new ArrayList<>();
        arrayList.add(new Role(DEFAULT_ADMIN_ID,null));
        peopleToAdd.setRoles(arrayList);
        peopleToAdd.setAvatar(DEFAULT_AVATAR_PATH);
        return peopleRepository.save(peopleToAdd);

    }


}
