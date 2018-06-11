package com.example.spi;

/**
 * Created by Sniff on 2018/6/1.
 */
public class BobsHelloImpl implements Hello {
    @Override
    public String greeting() {
        return "bobs say hello.";
    }
}
