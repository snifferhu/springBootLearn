package com.example.spi;

import java.util.ServiceLoader;
/**
 * Created by Sniff on 2018/6/1.
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<Hello> loader = ServiceLoader.load(Hello.class);

        for (Hello hello:loader){
            System.out.println(hello.greeting());
        }
    }
}
