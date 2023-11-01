package com.shop.sphere.controllers;

import com.shop.sphere.api.ProductsApi;
import com.shop.sphere.api.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController implements ProductsApi {

    @Override
    public ResponseEntity<ProductDTO> getProduct(Long idProduct) {
        return ProductsApi.super.getProduct(idProduct);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ProductsApi.super.getProducts();
    }

    @Override
    public ResponseEntity<Void> updateProduct(ProductDTO productDTO) {
        return ProductsApi.super.updateProduct(productDTO);
    }
}
