package com.yyzstudy.zeshuailand.dao;

import com.yyzstudy.zeshuailand.model.po.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommunityRepository extends JpaRepository<Community, String>,JpaSpecificationExecutor<Community> {

}
