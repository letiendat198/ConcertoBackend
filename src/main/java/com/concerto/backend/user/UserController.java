package com.concerto.backend.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// Control request-response

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    UserService userService;

    public UserController(@Autowired UserService userService){
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "From the other sideeeeee";
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User userDetails) {
        logger.debug(userDetails.getUserName());
        try{
            userService.createUser(userDetails);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("New user created", HttpStatus.OK);
    }

    @GetMapping("/user/email/{email}")
    public Map<String, Boolean> checkEmailExists(@PathVariable  String email){
        logger.debug("User email: {}", email);
        HashMap<String, Boolean> statusResponse = new HashMap<>();
        statusResponse.put("exists", userService.checkEmailExists(email));
        return statusResponse;
    }
}
