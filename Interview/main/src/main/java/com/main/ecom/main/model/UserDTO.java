package com.main.ecom.main.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "User")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ObjId")
    private int ObjId;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Sex")
    private char sex;
    @Column(name = "IsDiable")
    private boolean isDiable;
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "IsAdmin")
    private boolean isAdmin;
    @Column(name = "passcode")
    private String password;
    @Column(name = "UdatedOn")
    @UpdateTimestamp
    private Timestamp updateOn = Timestamp.from(Instant.now());

}

