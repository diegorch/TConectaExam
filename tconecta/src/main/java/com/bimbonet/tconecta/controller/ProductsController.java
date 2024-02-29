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
import com.bimbonet.tconecta.service.ProductsService;

@RestController
@RequestMapping("/api/product")
public class ProductsController {
	private static final String JSON_RESPONSE = "application/json";
    
    private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	ProductsService productService;
	
	@GetMapping(value = "/getAllProducts", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getAllProducts(){
		logger.info("[GET] Entering to getAllProducts()");
    	
        Object response = productService.getAllProductsService();    		

        logger.info("[GET] Exiting from getAllProducts()");
        return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/getProductByProductID", produces = JSON_RESPONSE)
	public ResponseEntity<Object> getProductByProductID(@RequestParam Long productID){
		logger.info("[GET] Entering to getProductByProductID()");
    	
        Object response = productService.getProductByProductIDService(productID);    		

        logger.info("[GET] Exiting from getProductByProductID()");
        return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/createProduct", produces = JSON_RESPONSE)
    public ResponseEntity<Object> createProduct(
    		@RequestBody(required = false) ProductsModel product) {
        logger.info("[GET] Entering to getInput()");
    	logger.info("[GET] Looking for User: " + product.getProductName());
    	
    	//Validate that the user object is not empty
    	if(product == null || product.getProductName().isEmpty() || product.getPrice() < 0.00) {
    		MessageResponse response = new MessageResponse(400, "Invalid Input.");  		

            logger.info("[GET] Exiting from getInput()");
            return ResponseEntity.ok(response);
    	}
    	
    	ProductsModel newProduct = productService.createProductService(product);    		

        logger.info("[GET] Exiting from getInput()");
        return ResponseEntity.ok(newProduct);
    }
}
