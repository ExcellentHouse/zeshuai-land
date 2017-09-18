package com.yyzstudy.zeshuailand.dao;

import com.yyzstudy.zeshuailand.model.po.Community;
import com.yyzstudy.zeshuailand.model.po.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HouseRepository extends JpaRepository<House, String>,JpaSpecificationExecutor<House> {
}
