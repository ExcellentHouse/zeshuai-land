package com.yyzstudy.zeshuailand.dao;

import com.yyzstudy.zeshuailand.model.po.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, String> {

    List<Area> findByCity(String city);


    @Query("select distinct a.city from Area a")
    List<String> findAllCity();

    @Query("select distinct a.district from Area a where a.city = ?1")
    List<String> findAllDistrictByCity(String city);

    @Query("select distinct a.street from Area a where a.city = ?1 and a.district = ?2")
    List<String> findAllStreetByCityAndDistrict(String city, String district);
}
