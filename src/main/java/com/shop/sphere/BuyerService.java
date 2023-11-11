package com.shop.sphere;

import com.shop.sphere.dao.BuyerRepository;
import com.shop.sphere.models.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Buyer saveBuyer(Buyer buyer) {
        String encodedPassword = passwordEncoder.encode(buyer.getPassword());
        buyer.setPassword(encodedPassword);
        return buyerRepository.save(buyer);
    }
}
