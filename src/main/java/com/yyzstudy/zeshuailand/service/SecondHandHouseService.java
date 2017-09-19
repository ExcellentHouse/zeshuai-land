package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.model.dto.SecondHandHouseFilterDTO;
import com.yyzstudy.zeshuailand.model.po.SecondHandHouse;
import com.yyzstudy.zeshuailand.model.vo.SecondHandHouseItem;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SecondHandHouseService {
    List<SecondHandHouse> findAllPaging(int index, int count);
    Page<SecondHandHouse> filter(SecondHandHouseFilterDTO secondHandHouseFilterDTO, int index, int count);


    List<SecondHandHouseItem> convertToSecondHandHouseItem(List<SecondHandHouse> secondHandHouseList);
}
