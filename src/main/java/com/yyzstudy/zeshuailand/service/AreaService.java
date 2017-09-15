package com.yyzstudy.zeshuailand.service;


import com.yyzstudy.zeshuailand.model.Area;

import java.util.Collection;
import java.util.List;

public interface AreaService {

    Area save(Area area);

    List<Area> save(Collection<Area> areas);

    List<String> findAllCity();

    List<String> findAllDistrictByCity(String city);

    List<String> findAllStreetByCityAndDistrict(String city, String district);
}
