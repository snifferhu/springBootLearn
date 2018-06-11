package com.example.demo;

import com.example.demo.mapper.CustomerRepository;
import com.example.model.qo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auth snifferhu
 * @date 2018/3/15 22:13
 */
@RestController
public class UserApplication {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "Artaban") String name) {
        String greeting = this.restTemplate.getForObject("http://simple/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }

    @GetMapping(value = "/add")
    public String add() {
        return restTemplate.getForEntity("http://simple/add?a=10&b=20", String.class).getBody();
    }

    @RequestMapping("/")
    public String hello() {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
//        mongoTemplate.updateFirst();
        return this.restTemplate.getForObject("http://simple/", String.class);
    }
}