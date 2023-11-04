package com.shop.sphere.controllers;

import com.shop.sphere.api.model.BuyerDTO;
import com.shop.sphere.api.model.IdBuyer;
import com.shop.sphere.dao.BuyerRepository;
import com.shop.sphere.mappers.BuyerMapper;
import com.shop.sphere.models.Buyer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TestBuyerController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuyerRepository buyerRepository;

    private BuyerMapper buyerMapper = Mappers.getMapper(BuyerMapper.class);

    private Buyer testBuyer;
    private BuyerDTO testBuyerDTO;

    @BeforeEach
    public void setUp() {
        testBuyer = new Buyer();
        testBuyer.setId(1L);
        testBuyer.setFirstName("Achraf");
        testBuyer.setLastName("ZERHOUNI");
        testBuyer.setEmail("achraf.zerhouni@shopsphere.com");
        testBuyer.setPassword("achrafPassword");
        testBuyer.setAddress("123 Boulevard Achraf");

        testBuyerDTO = buyerMapper.buyerToBuyerDto(testBuyer);
    }

}
