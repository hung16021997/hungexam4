package com.test.service.impl;

import com.test.model.City;
import com.test.model.Country;
import com.test.repository.CityRepository;
import com.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }


    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        cityRepository.delete(id);
    }
}
