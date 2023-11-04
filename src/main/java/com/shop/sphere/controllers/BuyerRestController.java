package com.shop.sphere.controllers;

import com.shop.sphere.api.BuyersApi;
import com.shop.sphere.api.model.BuyerDTO;
import com.shop.sphere.api.model.IdBuyer;
import com.shop.sphere.dao.BuyerRepository;
import com.shop.sphere.mappers.AdminMapper;
import com.shop.sphere.mappers.BuyerMapper;
import com.shop.sphere.models.Buyer;
import io.swagger.annotations.Authorization;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BuyerRestController implements BuyersApi {

    @Autowired
    private BuyerRepository buyerRepository;

    private BuyerMapper buyerMapper = Mappers.getMapper(BuyerMapper.class);

    @Override
    public ResponseEntity<IdBuyer> createBuyer(@Valid @RequestBody BuyerDTO buyerDTO) {
        Buyer buyer = buyerMapper.buyerDtotoBuyer(buyerDTO);
        Buyer savedBuyer = buyerRepository.save(buyer);
        IdBuyer idBuyer = new IdBuyer();
        idBuyer.setIdBuyer(savedBuyer.getId());
        return new ResponseEntity<>(idBuyer, HttpStatus.CREATED);
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
