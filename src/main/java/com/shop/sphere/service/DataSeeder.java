package com.shop.sphere.service;

import com.shop.sphere.dao.AdminRepository;
import com.shop.sphere.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class DataSeeder {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void initData(){

    }

}
