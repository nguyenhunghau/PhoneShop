package com.PhoneShop.service;

import com.PhoneShop.component.EmailUtils;
import com.PhoneShop.entity.UserEntity;
import com.PhoneShop.model.User;
import com.PhoneShop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailUtils emailUtils;

    public String createAccount(User user) {
        UserEntity userEntity = new ModelMapper().map(user, UserEntity.class);
        userRepository.save(userEntity);
        emailUtils.sendMailRegister(user);
        return "success";
    }

    public String login(User user) {
        UserEntity userEntity = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(userEntity != null) {
            //Generate sesionId
            String sessionId = UUID.randomUUID().toString();
            userEntity.setSessionId(sessionId);
            userRepository.save(userEntity);
            return sessionId;
        }
        return "fail";
    }

    public User findBySessionId(String sessionId) {
        UserEntity userEntity = userRepository.findBySessionId(sessionId);
        return new ModelMapper().map(userEntity, User.class);
    }
}
