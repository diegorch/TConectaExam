package com.bimbonet.tconecta.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbonet.tconecta.data.ClaimRewardRepository;
import com.bimbonet.tconecta.data.RewardRepository;
import com.bimbonet.tconecta.data.UserRepository;
import com.bimbonet.tconecta.model.ClaimReward;
import com.bimbonet.tconecta.model.ClaimRewardModel;
import com.bimbonet.tconecta.model.MessageResponse;
import com.bimbonet.tconecta.model.RewardModel;
import com.bimbonet.tconecta.model.UserModel;

@Service
public class ClaimRewardService {
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	RewardRepository rewardRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ClaimRewardRepository claimRewardRepository;

	public Object getAllClaimedRewardsService() {
		logger.info("[GET] Entering to getAllProductsService()");

        List<ClaimReward> response = new ArrayList<ClaimReward>();		
        List<ClaimRewardModel> rewards = claimRewardRepository.findAll();
        
        rewards.forEach(reward -> {
        	UserModel user = userRepository.findById(reward.getUserID()).orElse(null);
        	RewardModel rewardModel = rewardRepository.findById(reward.getRewardID()).orElse(null);
        	
        	if(user != null && rewardModel != null) {
        		ClaimReward claimReward = new ClaimReward(reward.getClaimID(), user.getUserName(), rewardModel.getRewardName(), reward.getQty());
        		
        		response.add(claimReward);
        	}
        });
        
        logger.info("[GET] Exiting to getAllProductsService()");
		return response;
	}

	public Object claimRewardService(ClaimRewardModel reward) {
		logger.info("[POST] Entering to claimRewardService()");
		
		ClaimRewardModel newReward = new ClaimRewardModel();
    	UserModel user = userRepository.findById(reward.getUserID()).orElse(null);
    	RewardModel rewardModel = rewardRepository.findById(reward.getRewardID()).orElse(null);
    	MessageResponse response = new MessageResponse();
    	
    	if(user != null && rewardModel != null) {
    		newReward = claimRewardRepository.save(reward);
    		
    		rewardModel.setQty(rewardModel.getQty() - reward.getQty());
    		user.setLoyaltyPoints(user.getLoyaltyPoints() - (reward.getQty() * rewardModel.getPricePoints()));
    		rewardRepository.save(rewardModel);
    		userRepository.save(user);
    		
    		response = new MessageResponse(200, "DATA Succesfuly Stored With ID ::: " + newReward.getClaimID());
    	}else {
    		response = new MessageResponse(400, "NOT FOUND ERROR. ");
    	}

        logger.info("[POST] Exiting to claimRewardService()");
        return response;
	}

}
