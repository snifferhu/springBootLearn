package com.demo.controller.bean;

/**
 * @auth snifferhu
 * @date 2016/12/18 14:16
 */
public class User {
    private Long id;
    private String name;
    private Integer age;

    /**
     * 在controller中,利用ModelAttribute作为接收参数注解的情况下
     * 没有默认构造方法,页面报错
     * No default constructor found; nested exception is java.lang.NoSuchMethodException
     */
    public User(){}

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}