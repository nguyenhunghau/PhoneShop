package com.PhoneShop.repository;

import com.PhoneShop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public UserEntity findByUsernameAndPassword(String username, String password);

    public UserEntity findBySessionId(String sessionId);
}
