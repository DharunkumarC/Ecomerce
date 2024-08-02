package com.main.ecom.main.service;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenBlacklistService {

    // Using a thread-safe set for blacklisted tokens
    private final Set<String> blacklist = ConcurrentHashMap.newKeySet();

    // Add a token to the blacklist
    public void addTokenToBlacklist(String token) {
        blacklist.add(token);
    }

    // Check if a token is blacklisted
    public boolean isTokenBlacklisted(String token) {
        return blacklist.contains(token);
    }
}
