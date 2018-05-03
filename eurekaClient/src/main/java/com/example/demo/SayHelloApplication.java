package com.example.demo;

import com.example.demo.dao.CityMapper;
import com.example.demo.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @auth snifferhu
 * @date 2018/3/15 22:04
 */
@RestController
@Transactional
public class SayHelloApplication {
    private static Logger log = LoggerFactory.getLogger(SayHelloApplication.class);

    @Autowired
    private CityMapper cityMapper;

    @RequestMapping(value = "/greeting")
    public String greet() {
        log.info("Access /greeting");

        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

    @RequestMapping(value = "/")
    public String home() {
        City city = cityMapper.selectByPrimaryKey(1);
        city.setState("2");
        cityMapper.updateByPrimaryKey(city);
        if (true){
            throw new RuntimeException();
        }
        city.setState("0");
        cityMapper.updateByPrimaryKey(city);
        log.info("Access /");
        return "Hi!";
    }
}
