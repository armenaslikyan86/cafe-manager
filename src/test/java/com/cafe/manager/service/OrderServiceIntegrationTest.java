package com.cafe.manager.service;

import com.cafe.manager.domain.Order;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceIntegrationTest extends CommonIntegrationTestResource {

    @Autowired
    private OrderService orderService;

    @Test
    public void getOrderById() {
        final Order result = orderService.getOrderById(1L);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getId().longValue());
    }

}
