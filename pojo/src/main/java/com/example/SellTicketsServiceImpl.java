package com.example;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auth snifferhu
 * @date 2018/6/17 10:10
 */
public class SellTicketsServiceImpl implements SellTicketsService {
    private Map<String, Integer> ticketCollection = new ConcurrentHashMap<String, Integer>() {{
        put("air", 15);
        put("bus", 35);
    }};

    @Override
    public String sell(String type, BigDecimal amount) {
        if (amount.doubleValue() < 0.0D) {
            throw new IllegalArgumentException("amount can not less than zero.");
        }
        Integer count = ticketCollection.get(type);
        if (count == null || count < 0) {
            throw new IllegalStateException("ticket collection is empty");
        }
        count = ticketCollection.computeIfPresent(type, (k,v) ->  v - 1);
        if (count == 0){
            ticketCollection.remove(type);
        }
        return "ok";
    }
}
