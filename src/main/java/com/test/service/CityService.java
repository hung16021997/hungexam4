package com.test.service;

import com.test.model.City;

public interface CityService{
    City findById(Long id);
    void save(City city);
    void remove(Long id);
    Iterable<City> findAll();
}
