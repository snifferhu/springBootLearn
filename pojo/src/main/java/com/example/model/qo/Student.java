package com.example.model.qo;

import org.springframework.data.annotation.Id;

/**
 * @auth snifferhu
 * @date 2018/6/12 17:30
 */
public class Student {

    @Id
    public String id;

    public String firstName;
    public String lastName;


    public Student() {
    }

    public Student(Student other) {
        this.id = other.id;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
    }

    public Student(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public Student setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
