package com.bimbonet.tconecta.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbonet.tconecta.data.UserRepository;
import com.bimbonet.tconecta.model.MessageResponse;
import com.bimbonet.tconecta.model.UserModel;

@Service
public class UserService{
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserModel> getAllUsersService() {
		logger.info("[GET] Entering to getAllUsersService()");
		
        List<UserModel> users = userRepository.findAll();

        logger.info("[GET] Exiting to getAllUsersService()");
        return users;
	}

	public UserModel createUserService(UserModel newUser) {
		logger.info("[GET] Entering to createUserService()");
		
        UserModel user = userRepository.save(newUser);

        logger.info("[GET] Exiting to createUserService()");
        return user;
	}

	public Object getUserByUsernameService(String username) {
		logger.info("[GET] Entering to getUserByUsernameService()");
		
        UserModel response = userRepository.findByUserName(username);

    	MessageResponse message = new MessageResponse(200, "USER SUCCESFULY CREATED - WITH ID: " + response.getUserID());
        
        logger.info("[GET] Exiting to getUserByUsernameService()");
		return message;
	}

	public Object getUserByUserID(Long userID) {
		logger.info("[GET] Entering to getUserByUserID()");
		
        UserModel response = userRepository.findById(userID).orElse(null);
        
        if(response == null) {
        	MessageResponse message = new MessageResponse(404, "NOT FOUND USER WITH ID: " + userID);

            logger.info("[GET] Exiting to getUserByUserID() - NOT FOUND USER WITH ID: " + userID);
    		return message;        	
        }
        logger.info("[GET] Exiting to getUserByUserID()");
		return response;
	}
}
