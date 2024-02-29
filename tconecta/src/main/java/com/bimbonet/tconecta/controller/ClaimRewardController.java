package com.bimbonet.tconecta.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bimbonet.tconecta.model.ClaimRewardModel;
import com.bimbonet.tconecta.model.MessageResponse;
import com.bimbonet.tconecta.model.NewPurchase;
import com.bimbonet.tconecta.service.ClaimRewardService;
import com.bimbonet.tconecta.service.PurchaseService;

@RestController
@RequestMapping("/api/claimReward")
public class ClaimRewardController {
	private static final String JSON_RESPONSE = "application/json";
    
    private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	ClaimRewardService claimRewardService;
	
	@GetMapping(value = "/getAllClaimedRewards", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getAllClaimedRewards(){
		logger.info("[GET] Entering to getAllClaimedRewards()");
    	
        Object response = claimRewardService.getAllClaimedRewardsService();		

        logger.info("[GET] Exiting from getAllClaimedRewards()");
        return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/claimReward", produces = JSON_RESPONSE)
    public ResponseEntity<Object> claimReward(
    		@RequestBody(required = false) ClaimRewardModel reward) {
        logger.info("[GET] Entering to claimReward()");
    	
    	//Validate that the user object is not empty
    	if(reward == null || reward.getUserID() == null || reward.getRewardID() == null) {
    		MessageResponse response = new MessageResponse(400, "Invalid Input.");  		

            logger.info("[GET] Exiting from claimReward()");
            return ResponseEntity.ok(response);
    	}
    	
    	Object response = claimRewardService.claimRewardService(reward);    		

        logger.info("[GET] Exiting from claimReward()");
        return ResponseEntity.ok(response);
    }
}
