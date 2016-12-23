package com.member.controller.bean;

public class MemberBuilder {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public MemberBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public MemberBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public MemberBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Member createMember() {
        return new Member(id, name, email, phone, password);
    }
}