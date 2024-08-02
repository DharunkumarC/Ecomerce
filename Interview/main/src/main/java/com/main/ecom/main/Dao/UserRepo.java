package com.main.ecom.main.Dao;

import com.main.ecom.main.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Integer> {

@Query(value = "Select * from dupe_ecommerce.usersinfo where Email = :input",nativeQuery = true)
    Optional<UserInfo> findByEmail(@Param("input") String email);

    @Query(value = "Select * from dupe_ecommerce.usersinfo where Email = :input and password =:password",nativeQuery = true)
    Optional<UserInfo> findByEmailandPassword(@Param("input") String email, @Param("password") String password);
}
