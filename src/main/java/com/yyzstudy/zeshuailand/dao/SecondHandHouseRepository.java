package com.yyzstudy.zeshuailand.dao;

import com.yyzstudy.zeshuailand.model.po.SecondHandHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SecondHandHouseRepository extends
        JpaRepository<SecondHandHouse, String>,JpaSpecificationExecutor<SecondHandHouse> {
}
