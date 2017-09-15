package com.yyzstudy.zeshuailand.service;

import com.yyzstudy.zeshuailand.dao.AreaRepository;
import com.yyzstudy.zeshuailand.model.po.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaRepository areaRepository;


    @Override
    public Area save(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public List<Area> save(Collection<Area> areas) {
        return areaRepository.save(areas);
    }

    @Override
    public List<String> findAllCity() {
        return areaRepository.findAllCity();
    }

    @Override
    public List<String> findAllDistrictByCity(String city) {
        return areaRepository.findAllDistrictByCity(city);
    }

    @Override
    public List<String> findAllStreetByCityAndDistrict(String city, String district) {
        return areaRepository.findAllStreetByCityAndDistrict(city, district);
    }


}
