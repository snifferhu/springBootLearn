package com.example.adapter;

import com.example.CompanyService;
import com.example.model.qo.Customer;
import com.example.model.qo.Student;

/**
 * @auth snifferhu
 * @date 2018/6/12 17:42
 */
public class CompanyAdapterService extends CompanyService{
    public void addCustomer(Student student){
        getCustomerMap().put(student.firstName,new Customer(student));
    }
}
