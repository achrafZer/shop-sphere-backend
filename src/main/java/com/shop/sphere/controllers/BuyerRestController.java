package com.shop.sphere.controllers;

import com.shop.sphere.api.BuyersApi;
import com.shop.sphere.api.model.BuyerDTO;
import com.shop.sphere.api.model.IdBuyer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyerRestController implements BuyersApi {
    @Override
    public ResponseEntity<IdBuyer> createBuyer(BuyerDTO buyerDTO) {
        return BuyersApi.super.createBuyer(buyerDTO);
    }

    @Override
    public ResponseEntity<BuyerDTO> getBuyer(Long idBuyer) {
        return BuyersApi.super.getBuyer(idBuyer);
    }

    @Override
    public ResponseEntity<List<BuyerDTO>> getBuyers() {
        return BuyersApi.super.getBuyers();
    }

    @Override
    public ResponseEntity<Void> updateBuyer(BuyerDTO buyerDTO) {
        return BuyersApi.super.updateBuyer(buyerDTO);
    }
}
