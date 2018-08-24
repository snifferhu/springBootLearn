package com.example.demo;

import com.example.demo.model.City;
import com.example.demo.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @auth snifferhu
 * @date 2018/3/8 01:39
 */
@RestController
public class ComputeController {
    private final static Logger logger = LoggerFactory.getLogger(ComputeController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/eureka/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping(value = "/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer r = a + b;
        return r;
    }


    @Autowired
    private CityService cityMapper;

    @GetMapping(value = "/infoQ")
    public String home() {
        City city = cityMapper.queryById(1);
        System.out.println(city);

        city.setState("0");
        cityMapper.updateByPrimaryKey(city);
        City city2 = cityMapper.queryById(1);
        System.out.println(city2);

        city.setState("2");
        cityMapper.updateByPrimaryKey(city);
        City city3 = cityMapper.queryById(1);
        System.out.println(city3);
        logger.info("Access /");
        return "Hi!";
    }

    @GetMapping(value = "/trans")
    public City trans() throws Exception {
        return cityMapper.home();
    }


    @Transactional(rollbackFor = Exception.class)
    @GetMapping(value = "/trans2")
    public City trans2() throws Exception {
        return cityMapper.trans2();
    }
}
