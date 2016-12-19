package com.demo.controller.bean;

public class UserBuilder {
    private Long id;
    private String name;
    private Integer age;

    public UserBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public User createUser() {
        return new User(id, name, age);
    }
}