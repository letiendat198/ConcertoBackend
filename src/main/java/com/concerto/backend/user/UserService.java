package com.concerto.backend.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service is for business logic

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User userDetails) throws Exception{
        String userEmail = userDetails.getUserEmail();
        if(userRepository.existsByUserEmail(userEmail)){
            throw new Exception("User already exists");
        }

        try {
            userRepository.save(userDetails);
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    public boolean checkEmailExists(String email){
        return userRepository.existsByUserEmail(email);
    }
}
