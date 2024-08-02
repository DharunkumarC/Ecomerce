package com.main.ecom.main.controller;

import com.main.ecom.main.service.TokenBlacklistService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenLogoutController {


    private final TokenBlacklistService tokenBlacklistService;

    public TokenLogoutController(TokenBlacklistService tokenBlacklistService) {
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @PostMapping("/api/logout")
    public String logout(@RequestHeader("Authorization") String token) {
        // Extract token from the Authorization header
        String jwtToken = token.replace("Bearer ", "");
        tokenBlacklistService.addTokenToBlacklist(jwtToken);
        return "Logged out successfully";
    }


}
