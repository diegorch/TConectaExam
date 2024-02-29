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

import com.bimbonet.tconecta.model.MessageResponse;
import com.bimbonet.tconecta.model.NewPurchase;
import com.bimbonet.tconecta.model.UserModel;
import com.bimbonet.tconecta.service.PurchaseService;

@RestController
@RequestMapping("/api/pruchase")
public class PurchaseController {
	private static final String JSON_RESPONSE = "application/json";
    
    private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	PurchaseService purchaseService;
	
	@GetMapping(value = "/getAllPurchases", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getAllPurchases(){
		logger.info("[GET] Entering to getAllPurchases()");
    	
        Object response = purchaseService.getAllPurchases();		

        logger.info("[GET] Exiting from getAllPurchases()");
        return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/newPurchase", produces = JSON_RESPONSE)
    public ResponseEntity<Object> newPurchase(
    		@RequestBody(required = false) NewPurchase purchase) {
        logger.info("[GET] Entering to newPurchase()");
    	
    	//Validate that the user object is not empty
    	if(purchase == null || purchase.getUserID() == null || purchase.getProducts().isEmpty()) {
    		MessageResponse response = new MessageResponse(400, "Invalid Input.");  		

            logger.info("[GET] Exiting from newPurchase()");
            return ResponseEntity.ok(response);
    	}
    	
    	Object response = purchaseService.newPurchaseService(purchase);    		

        logger.info("[GET] Exiting from newPurchase()");
        return ResponseEntity.ok(response);
    }
}
