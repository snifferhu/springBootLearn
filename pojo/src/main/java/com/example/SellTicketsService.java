package com.example;

import java.math.BigDecimal;

/**
 * @auth snifferhu
 * @date 2018/6/17 10:09
 */
public interface SellTicketsService {
    String sell(String type, BigDecimal amount);
}
