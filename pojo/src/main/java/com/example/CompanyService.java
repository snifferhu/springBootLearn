package com.example;

import com.example.model.qo.Customer;

import java.util.HashMap;
import java.util.Map;

/**
 * @auth snifferhu
 * @date 2018/6/12 17:44
 */
public class CompanyService {

    private Map<String,Customer> customerMap = new HashMap<>();

    protected Map<String, Customer> getCustomerMap() {
        return customerMap;
    }

    protected CompanyService setCustomerMap(Map<String, Customer> customerMap) {
        this.customerMap = customerMap;
        return this;
    }

    public void addCustomer(Customer customer){
        customerMap.put(customer.firstName,customer);
    }
}
