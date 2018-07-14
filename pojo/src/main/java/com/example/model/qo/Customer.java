package com.example.model.qo;

import org.springframework.data.annotation.Id;

/**
 * Created by Sniff on 2018/6/8.
 */
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer() {}

    public Customer(Student other) {
        this.id = other.id;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}