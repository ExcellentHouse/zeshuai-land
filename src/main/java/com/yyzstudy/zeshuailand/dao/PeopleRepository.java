package com.yyzstudy.zeshuailand.dao;

import com.yyzstudy.zeshuailand.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, String>{
    People findByUsername(String username);
}
