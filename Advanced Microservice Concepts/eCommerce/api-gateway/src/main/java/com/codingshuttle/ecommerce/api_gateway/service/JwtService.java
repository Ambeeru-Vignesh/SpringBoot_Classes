package com.codingshuttle.ecommerce.api_gateway.service;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    private String jwtSecretKey;

    private SecretKey getSecretKey() {
        return null;
    }
}
