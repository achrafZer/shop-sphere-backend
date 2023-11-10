package com.shop.sphere.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class OrderMapperTest {

    private OrderMapper orderMapper;

    @Test
    @BeforeEach
    void setup() {
        orderMapper = Mappers.getMapper(OrderMapper.class);
    }
}
