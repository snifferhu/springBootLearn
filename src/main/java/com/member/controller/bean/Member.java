package com.member.controller.bean;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @auth snifferhu
 * @date 2016/12/18 11:29
 */
public class Member implements Serializable {

    private long id;
    @Size(max=16)
    private String name;
    @Email
    private String email;
    private String phone;
    @Size(max=32)
    private String password;

    public Member() {
    }

    public Member(long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
