package com.main.ecom.main.service;

import com.main.ecom.main.Dao.UserRepo;
import com.main.ecom.main.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccess {

    @Autowired
    private UserRepo userRepo;



    public String createUser(UserInfo userDTO){
        Optional<UserInfo> userInfo =userRepo.findByEmail(userDTO.geteMail());
       if(userInfo.isEmpty()){
           userRepo.save(userDTO);
           return "User Created ";
       }
       return "This email already taken ";
    }

    public String authenticateUser(UserInfo userDTO){
        Optional<UserInfo> userInfo =userRepo.findByEmailandPassword(userDTO.geteMail(),userDTO.getPassword());
        if(userInfo.isPresent()){
            return "User "+userDTO.geteMail()+" login Successfully";
        }
        return "Invalid Credentials ";
    }


}
