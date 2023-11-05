package com.shop.sphere.service;

import com.shop.sphere.api.model.UserConnectedDTO;
import com.shop.sphere.dao.AdminRepository;
import com.shop.sphere.dao.BuyerRepository;
import com.shop.sphere.mappers.UserConnectedMapper;
import com.shop.sphere.models.Admin;
import com.shop.sphere.models.Buyer;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserConnectedMapper userConnectedMapper = Mappers.getMapper(UserConnectedMapper.class);

    @Autowired
    private AdminRepository adminRepository;

    @Value("${app.domain.name}")
    private String domainName;

    @Autowired
    private BuyerRepository buyerRepository;

    protected Admin findAdminByEmailAndPassword(String email, String password){
        return adminRepository.findAdminByEmailAndPassword(email,password);
    }

    protected Buyer findBuyerByEmailAndPassword(String email, String password){
        return buyerRepository.findBuyerByEmailAndPassword(email,password);
    }

    public ResponseEntity<UserConnectedDTO> login(String email, String password){
        if(email.contains(domainName)){
            Admin admin = findAdminByEmailAndPassword(email,password);
            if(admin != null)
                return ResponseEntity.ok().body(userConnectedMapper.adminToUserConnectedDto(admin));
        }
        Buyer buyer = findBuyerByEmailAndPassword(email,password);
        if(buyer != null)
            return ResponseEntity.ok().body(userConnectedMapper.buyerToUserConnectedDto(buyer));
        return ResponseEntity.badRequest().build();
    }

}
