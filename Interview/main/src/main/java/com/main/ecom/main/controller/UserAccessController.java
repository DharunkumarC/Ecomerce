package com.main.ecom.main.controller;

import com.main.ecom.main.model.UserInfo;
import com.main.ecom.main.service.UserAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserAccessController {
    @Autowired
    private UserAccess userAccess;

    @PostMapping("/createNewUser")
    private ResponseEntity<String> createNewUser(@RequestBody  UserInfo userInfo){
        return ResponseEntity.ok(userAccess.createUser(userInfo));
    }

    @GetMapping("/userLogin")
    private ResponseEntity<String> userLogin(@RequestBody UserInfo userInfo) {
        return ResponseEntity.ok(userAccess.authenticateUser(userInfo));
    }
}
