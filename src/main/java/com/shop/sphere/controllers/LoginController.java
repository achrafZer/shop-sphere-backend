package com.shop.sphere.controllers;

import com.shop.sphere.api.LoginApi;
import com.shop.sphere.api.model.LoginDTO;
import com.shop.sphere.api.model.UserConnectedDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi {
    @Override
    public ResponseEntity<UserConnectedDTO> login(LoginDTO loginDTO) {
        return LoginApi.super.login(loginDTO);
    }
}
