package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @auth snifferhu
 * @date 2018/6/17 10:47
 */
public class ProxySellTicketsServiceImpl implements SellTicketsService {

    private static final Logger logger = LoggerFactory.getLogger(ProxySellTicketsServiceImpl.class);
    private SellTicketsService service = new SellTicketsServiceImpl();

    @Override
    public String sell(String type, BigDecimal amount) {
        logger.info("sell type:{} amount:{}",type,amount);
        return service.sell(type,amount);
    }

    public static void main(String[] args) {
        System.out.println(new ProxySellTicketsServiceImpl().sell("bus",BigDecimal.ONE));
    }
}
