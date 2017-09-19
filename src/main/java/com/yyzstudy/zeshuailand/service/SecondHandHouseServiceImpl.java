package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.SecondHandHouseRepository;
import com.yyzstudy.zeshuailand.model.dto.SecondHandHouseFilterDTO;
import com.yyzstudy.zeshuailand.model.po.Community;
import com.yyzstudy.zeshuailand.model.po.SecondHandHouse;
import com.yyzstudy.zeshuailand.model.vo.SecondHandHouseItem;
import com.yyzstudy.zeshuailand.util.StringUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecondHandHouseServiceImpl implements SecondHandHouseService{

    @Autowired
    private SecondHandHouseRepository secondHandHouseRepository;

    @Override
    public List<SecondHandHouse> findAllPaging(int index, int count) {
        Pageable pageable = new PageRequest(index, count);
        Page<SecondHandHouse> page =  secondHandHouseRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public Page<SecondHandHouse> filter(SecondHandHouseFilterDTO secondHandHouseFilterDTO, int index, int count) {
        Specification querySpecifi = new Specification<SecondHandHouse>() {
            @Override
            public Predicate toPredicate(Root<SecondHandHouse> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtil.notNull(secondHandHouseFilterDTO.getCity()) ){
                    predicates.add(criteriaBuilder.equal(
                            root.get("house").get("community").get("area").get("city"),secondHandHouseFilterDTO.getCity()));
                }
                if( StringUtil.notNull(secondHandHouseFilterDTO.getDistrict())){
                    predicates.add(criteriaBuilder.equal(
                            root.get("house").get("community").get("area").get("district"),secondHandHouseFilterDTO.getDistrict()));
                }
                if(  StringUtil.notNull(secondHandHouseFilterDTO.getStreet()) ){
                    predicates.add(criteriaBuilder.equal(
                            root.get("house").get("community").get("area").get("street"),secondHandHouseFilterDTO.getStreet()));
                }
                if( StringUtil.notNull(secondHandHouseFilterDTO.getPrice()) ){
                    String[] range = secondHandHouseFilterDTO.getPrice().split("-");
                    if(range.length == 2){
                        predicates.add(criteriaBuilder.ge(
                                root.get("price"),Integer.valueOf(range[0])));
                        predicates.add(criteriaBuilder.le(
                                root.get("price"),Integer.valueOf(range[1])));
                    }else if(range.length == 1){
                        predicates.add(criteriaBuilder.ge(
                                root.get("price"),Integer.valueOf(range[0])));
                    }
                }
                if( StringUtil.notNull(secondHandHouseFilterDTO.getArea()) ){
                    String[] range = secondHandHouseFilterDTO.getArea().split("-");
                    if(range.length == 2){
                        predicates.add(criteriaBuilder.ge(
                                root.get("house").get("area"),Integer.valueOf(range[0])));
                        predicates.add(criteriaBuilder.le(
                                root.get("house").get("area"),Integer.valueOf(range[1])));
                    }else if(range.length == 1){
                        predicates.add(criteriaBuilder.ge(
                                root.get("house").get("area"),Integer.valueOf(range[0])));
                    }
                }
                if( StringUtil.notNull(secondHandHouseFilterDTO.getRoom()) ){
                    String room = secondHandHouseFilterDTO.getRoom();
                    if( (room.charAt(room.length() - 1) +"").equals("+")){
                        predicates.add(criteriaBuilder.gt(
                                root.get("house").get("room"),Integer.valueOf(room.substring(0,room.length() - 1) +"")));
                    }else{
                        predicates.add(criteriaBuilder.equal(
                                root.get("house").get("room"),Integer.valueOf(room)));
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Pageable pageable = new PageRequest(index,count);
        Page<SecondHandHouse> page = secondHandHouseRepository.findAll(querySpecifi,pageable);

        return page;
    }

    @Override
    public List<SecondHandHouseItem> convertToSecondHandHouseItem(List<SecondHandHouse> secondHandHouseList) {
        return secondHandHouseList.
                stream().
                map(x -> new SecondHandHouseItem(
                        x.getId(),
                        x.getHouse().getRoom(),
                        x.getHouse().getHall(),
                        x.getHouse().getWashroom(),
                        x.getHouse().getArea(),
                        x.getHouse().getFloor(),
                        x.getHouse().getHasElevator(),
                        x.getHouse().getCommunity().getArea().getCity(),
                        x.getHouse().getCommunity().getArea().getDistrict(),
                        x.getHouse().getCommunity().getArea().getStreet(),
                        x.getHouse().getCommunity().getName(),
                        x.getHouse().getBuiltYear(),
                        x.getPrice(),
                        Double.valueOf(x.getPrice() * 10000 / x.getHouse().getArea()).intValue(),
                        x.getHouse().getPath(),
                        x.getHouse().getRemark()

                        )).collect(Collectors.toList());
    }


}
