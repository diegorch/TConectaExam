package com.bimbonet.tconecta.controller;

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
import com.bimbonet.tconecta.model.ProductsModel;
import com.bimbonet.tconecta.model.RewardModel;
import com.bimbonet.tconecta.service.ProductsService;
import com.bimbonet.tconecta.service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
	private static final String JSON_RESPONSE = "application/json";
    
    private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	RewardService rewardService;
	
	@GetMapping(value = "/getAllRewards", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getAllRewards(){
		logger.info("[GET] Entering to getAllRewards()");
    	
        Object response = rewardService.getAllRewardsService();    		

        logger.info("[GET] Exiting from getAllRewards()");
        return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/getRewardByRewardID", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getProductByProductID(@RequestParam Long rewardID){
		logger.info("[GET] Entering to getRewardByRewardID()");
    	
        Object response = rewardService.getRewardByRewardIDService(rewardID);    		

        logger.info("[GET] Exiting from getRewardByRewardID()");
        return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/createReward", produces = JSON_RESPONSE)
    public ResponseEntity<Object> createReward(
    		@RequestBody(required = false) RewardModel reward) {
        logger.info("[GET] Entering to createReward()");
    	logger.info("[GET] Looking for User: " + reward.getRewardName());
    	
    	//Validate that the user object is not empty
    	if(reward == null || reward.getRewardName().isEmpty() || reward.getPricePoints() <= 0) {
    		MessageResponse response = new MessageResponse(400, "Invalid Input.");  		

            logger.info("[GET] Exiting from createReward()");
            return ResponseEntity.ok(response);
    	}
    	
    	Object newProduct = rewardService.createRewardService(reward);    		

        logger.info("[GET] Exiting from createReward()");
        return ResponseEntity.ok(newProduct);
    }

}
