package com.example.spi;

/**
 * Created by Sniff on 2018/6/1.
 */
public class FrankHelloImpl implements Hello {

    @Override
    public String greeting() {
        return "Frank say hello";
    }
}
