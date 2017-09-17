package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.CommunityRepository;
import com.yyzstudy.zeshuailand.model.dto.CommunityFilterDTO;
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
import java.time.LocalDate;
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
    public List<Community> filter(CommunityFilterDTO communityFilterDTO) {
        Specification querySpecifi = new Specification<Community>() {
            @Override
            public Predicate toPredicate(Root<Community> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                //小区名字来进行模糊查询
                if( communityFilterDTO.getName() != null){
                    predicates.add(criteriaBuilder.like(root.get("name"),"%"+communityFilterDTO.getName()+"%"));
                }
                //小区的城市来进行准确查询
                if( communityFilterDTO.getCity() != null){
                    predicates.add(criteriaBuilder.equal(root.get("area").get("city"), communityFilterDTO.getCity()));
                }
                //小区的区用来准确查询
                if( communityFilterDTO.getDistrict() != null){
                    predicates.add(criteriaBuilder.equal(root.get("area").get("district"), communityFilterDTO.getDistrict()));
                }
                //小区的街道用来准确查询
                if( communityFilterDTO.getStreet() != null){
                    predicates.add(criteriaBuilder.equal(root.get("area").get("street"), communityFilterDTO.getStreet()));
                }
                //小区的均价范围 getAverage 如果返回2-5 表示范围 如果是5 表示5以上
                if( communityFilterDTO.getAverage() != null){
                    String[] range = communityFilterDTO.getAverage().split("-");
                    if( range.length == 1){
                        predicates.add(criteriaBuilder.ge(root.get("average"), Double.valueOf(range[0])));
                    }else if( range.length == 2){
                        predicates.add(criteriaBuilder.ge(root.get("average"), Double.valueOf(range[0])));
                        predicates.add(criteriaBuilder.le(root.get("average"), Double.valueOf(range[1])));
                    }
                }
                //小区的房龄范围
                if( communityFilterDTO.getHouseAge() != null){
                    LocalDate localDate = LocalDate.now();
                    int year = localDate.getYear();
                    String[] range = communityFilterDTO.getHouseAge().split("-");
                    if( range.length == 2){
                        int lower = year - Integer.valueOf(range[1]);
                        int higher = year - Integer.valueOf(range[0]);
                        predicates.add(criteriaBuilder.ge(root.get("builtYear"), lower));
                        predicates.add(criteriaBuilder.le(root.get("builtYear"), higher));
                    }else if (range.length == 1){
                        int temp = year - Integer.valueOf(range[0]);
                        predicates.add(criteriaBuilder.le(root.get("builtYear"), temp));
                    }
                }
                if( communityFilterDTO.getHouseType() != null){
                    predicates.add(criteriaBuilder.equal(root.get("houseType"), communityFilterDTO.getHouseType()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };


        return communityRepository.findAll(querySpecifi);
    }
}
