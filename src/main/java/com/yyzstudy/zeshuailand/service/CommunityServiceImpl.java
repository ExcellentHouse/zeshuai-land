package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.CommunityRepository;
import com.yyzstudy.zeshuailand.model.po.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public List<Community> findAllPageing(int index, int count) {
        Pageable pageable = new PageRequest(index, count);
        Page<Community> page =  communityRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public List<Community> filter(String city, String district, String street, String average, String houseAge) {
        Specification querySpecifi = new Specification<Community>() {
            @Override
            public Predicate toPredicate(Root<Community> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if( city != null){
                    predicates.add(criteriaBuilder.equal(root.get("area").get("city"), city));
                }
                if( district != null){
                    predicates.add(criteriaBuilder.equal(root.get("area").get("district"), district));
                }
                if( street != null){
                    predicates.add(criteriaBuilder.equal(root.get("area").get("street"), street));
                }
                if( average != null){
                    predicates.add(criteriaBuilder.equal(root.get("average"), average));
                }
                if( houseAge != null){
                    predicates.add(criteriaBuilder.equal(root.get("houseAge"), houseAge));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };


        return communityRepository.findAll(querySpecifi);
    }
}
