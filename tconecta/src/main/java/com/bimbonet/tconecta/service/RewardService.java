package com.bimbonet.tconecta.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbonet.tconecta.data.RewardRepository;
import com.bimbonet.tconecta.model.MessageResponse;
import com.bimbonet.tconecta.model.ProductsModel;
import com.bimbonet.tconecta.model.RewardModel;

@Service
public class RewardService {
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	RewardRepository rewardRepository;

	public Object getAllRewardsService() {
		logger.info("[GET] Entering to getAllProductsService()");
		
        List<RewardModel> response = rewardRepository.findAll();

        logger.info("[GET] Exiting to getAllProductsService()");
		return response;
	}

	public Object getRewardByRewardIDService(Long rewardID) {
		logger.info("[GET] Entering to getProductByProductIDService()");
		
		RewardModel response = rewardRepository.findById(rewardID).orElse(null);
        
        if(response == null) {
        	MessageResponse message = new MessageResponse(404, "NOT FOUND USER WITH ID: " + rewardID);

            logger.info("[GET] Exiting to getProductByProductIDService() - NOT FOUND USER WITH ID: " + rewardID);
    		return message;        	
        }
        logger.info("[GET] Exiting to getProductByProductIDService()");
		return response;
	}

	public Object createRewardService(RewardModel reward) {
		logger.info("[POST] Entering to createProductService()");
		
		RewardModel newReward = rewardRepository.save(reward);

        logger.info("[POST] Exiting to createProductService()");
        return newReward;
	}

}
