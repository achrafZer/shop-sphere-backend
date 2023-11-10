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
        // Create and set up a test Order instance
        testOrder = new Order();
        // ... Initialize the fields of testOrder ...

        // Create and set up a test OrderDTO instance
        testOrderDTO = new OrderDTO();
        // ... Initialize the fields of testOrderDTO ...

        // Initialize the mapper
        orderMapper = Mappers.getMapper(OrderMapper.class);
    }

    @Test
    void orderToOrderDtoMapping() {
        // Map Order to OrderDTO
        OrderDTO mappedOrderDTO = orderMapper.orderToOrderDto(testOrder);

        // Assert that the fields are mapped correctly
        assertEquals(testOrder.getId(), mappedOrderDTO.getId());
        // ... More assertEquals for other fields ...
    }

    @Test
    void orderDtoToOrderMapping() {
        // Map OrderDTO to Order
        Order mappedOrder = orderMapper.orderDtoToOrder(testOrderDTO);

        // Assert that the fields are mapped correctly
        assertEquals(testOrderDTO.getId(), mappedOrder.getId());
        // ... More assertEquals for other fields ...
    }
}
