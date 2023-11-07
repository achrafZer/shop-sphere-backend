package com.shop.sphere.mappers;

import com.shop.sphere.api.model.OrderDTO;
import com.shop.sphere.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDTO orderDTO);
}
