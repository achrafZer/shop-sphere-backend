package com.shop.sphere.controllers;

import com.shop.sphere.api.OrdersApi;
import com.shop.sphere.api.model.IdBuyer;
import com.shop.sphere.api.model.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestController implements OrdersApi {

    @Override
    public ResponseEntity<IdBuyer> createOrder(OrderDTO orderDTO) {
        return OrdersApi.super.createOrder(orderDTO);
    }

    @Override
    public ResponseEntity<Void> deleteOrder(Integer idOrder) {
        return OrdersApi.super.deleteOrder(idOrder);
    }

    @Override
    public ResponseEntity<OrderDTO> getOrder(Integer idOrder) {
        return OrdersApi.super.getOrder(idOrder);
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getOrders() {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateOrder(OrderDTO orderDTO) {
        return OrdersApi.super.updateOrder(orderDTO);
    }
}
