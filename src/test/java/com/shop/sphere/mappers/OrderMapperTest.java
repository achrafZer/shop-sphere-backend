package com.shop.sphere.mappers;

import com.shop.sphere.api.model.OrderDTO;
import com.shop.sphere.models.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderMapperTest {

    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    private Order testOrder;
    private OrderDTO testOrderDTO;

    @BeforeEach
    void setUp() {
        testOrder = new Order();
        testOrderDTO = new OrderDTO();
    }

    @Test
    void orderToOrderDtoMapping() {
        OrderDTO mappedOrderDTO = orderMapper.orderToOrderDto(testOrder);
        assertEquals(testOrder.getId(), mappedOrderDTO.getId());
    }

    @Test
    void orderDtoToOrderMapping() {
        Order mappedOrder = orderMapper.orderDtoToOrder(testOrderDTO);
        assertEquals(testOrderDTO.getId(), mappedOrder.getId());
    }
}
