package com.example.demo.service;

import com.example.demo.ComputeController;
import com.example.demo.dao.CityMapper;
import com.example.demo.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auth snifferhu
 * @date 2018/7/8 22:35
 */
@Service
public class CityService {
    private final static Logger logger = LoggerFactory.getLogger(ComputeController.class);
    @Autowired
    private CityMapper cityMapper;

    public City home() throws Exception {
        City city = queryById(1);
        System.out.println(city);
        city.setState("0");
        updateByPrimaryKey(city);
        City city2 = cityMapper.selectByPrimaryKey(1);
        System.out.println(city2);
        if (true){
            throw new RuntimeException();
        }
        city.setState("0");
        cityMapper.updateByPrimaryKey(city);
        logger.info("Access /");
        return city;
    }

    public City queryById(Integer id){
        return cityMapper.selectByPrimaryKey(id);
    }

    public Integer updateByPrimaryKey(City city){
        return cityMapper.updateByPrimaryKey(city);
    }

    public City trans2() throws Exception {
        City city = queryById(1);
        System.out.println(city);
        city.setState("0");
        cityMapper.updateByPrimaryKey(city);
        City city2 = cityMapper.selectByPrimaryKey(1);
        System.out.println(city2);
        if (true){
            throw new Exception();
        }
        return city;
    }
}
