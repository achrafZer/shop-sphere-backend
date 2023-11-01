package com.shop.sphere.controllers;

import com.shop.sphere.api.AdminsApi;
import com.shop.sphere.api.model.AdminDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController implements AdminsApi {
    @Override
    public ResponseEntity<AdminDTO> getAdmin(Long idAdmin) {
        return AdminsApi.super.getAdmin(idAdmin);
    }
}
