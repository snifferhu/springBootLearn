package com.example.model.qo;

/**
 * Created by Sniff on 2018/5/9.
 */
public class Greeting {
    private String name;
    private String context;

    public Greeting() {
    }

    public Greeting(String name, String context) {
        this.name = name;
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
