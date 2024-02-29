package com.bimbonet.tconecta.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bimbonet.tconecta.model.MessageResponse;
import com.bimbonet.tconecta.model.UserModel;
import com.bimbonet.tconecta.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private static final String JSON_RESPONSE = "application/json";
    
    private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/getAllUsers", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getAllUsers(){
		logger.info("[GET] Entering to getAllUsers()");
    	
        Object response = userService.getAllUsersService();    		

        logger.info("[GET] Exiting from getAllUsers()");
        return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/getUserByUsername", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getUserByUsername(@RequestParam String username){
		logger.info("[GET] Entering to getUserByUsername()");
    	
        Object response = userService.getUserByUsernameService(username);    		

        logger.info("[GET] Exiting from getUserByUsername()");
        return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/getUserByUserID", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getUserByUserID(@RequestParam Long userID){
		logger.info("[GET] Entering to getUserByUsername()");
    	
        Object response = userService.getUserByUserID(userID);    		

        logger.info("[GET] Exiting from getUserByUserID()");
        return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/createUser", produces = JSON_RESPONSE)
    public ResponseEntity<Object> createUser(
    		@RequestBody(required = false) UserModel user) {
        logger.info("[GET] Entering to createUser()");
    	logger.info("[GET] Looking for User: " + user.getUserName());
    	
    	//Validate that the user object is not empty
    	if(user == null || user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
    		MessageResponse response = new MessageResponse(400, "Invalid Input.");  		

            logger.info("[GET] Exiting from createUser()");
            return ResponseEntity.ok(response);
    	}
    	
        UserModel newUser = userService.createUserService(user);    		

        logger.info("[GET] Exiting from createUser()");
        return ResponseEntity.ok(newUser);
    }
}
