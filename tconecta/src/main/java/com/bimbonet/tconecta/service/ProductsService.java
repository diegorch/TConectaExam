package com.bimbonet.tconecta.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbonet.tconecta.data.ProductsRepository;
import com.bimbonet.tconecta.model.MessageResponse;
import com.bimbonet.tconecta.model.ProductsModel;

@Service
public class ProductsService {
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	ProductsRepository productRepository;

	public Object getAllProductsService() {
		logger.info("[GET] Entering to getAllProductsService()");
		
        List<ProductsModel> products = productRepository.findAll();

        logger.info("[GET] Exiting to getAllProductsService()");
        return products;
	}

	public Object getProductByProductIDService(Long productID) {
		logger.info("[GET] Entering to getProductByProductIDService()");
		
		ProductsModel response = productRepository.findById(productID).orElse(null);
        
        if(response == null) {
        	MessageResponse message = new MessageResponse(404, "NOT FOUND USER WITH ID: " + productID);

            logger.info("[GET] Exiting to getProductByProductIDService() - NOT FOUND USER WITH ID: " + productID);
    		return message;        	
        }
        logger.info("[GET] Exiting to getProductByProductIDService()");
		return response;
	}

	public ProductsModel createProductService(ProductsModel product) {
		logger.info("[GET] Entering to createProductService()");
		
        ProductsModel newProduct = productRepository.save(product);

        logger.info("[GET] Exiting to createProductService()");
        return newProduct;
	}

}
