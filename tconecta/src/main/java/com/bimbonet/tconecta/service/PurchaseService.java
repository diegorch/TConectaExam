package com.bimbonet.tconecta.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bimbonet.tconecta.data.ProductsRepository;
import com.bimbonet.tconecta.data.PurchasesRepository;
import com.bimbonet.tconecta.data.UserRepository;
import com.bimbonet.tconecta.model.Purchase;
import com.bimbonet.tconecta.model.MessageResponse;
import com.bimbonet.tconecta.model.NewPurchase;
import com.bimbonet.tconecta.model.Products;
import com.bimbonet.tconecta.model.ProductsModel;
import com.bimbonet.tconecta.model.PurchaseModel;
import com.bimbonet.tconecta.model.UserModel;

@Service
public class PurchaseService {
	private static final Logger logger = LogManager.getLogger(UserService.class);
	private Long purchaseNumber = 0L;
	
	@Autowired
	ProductsRepository productRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PurchasesRepository purchaseRepository;
	
	public Object getAllPurchases() {
		logger.info("[GET] Entering to getAllPurchases()");

		List<PurchaseModel> purchases = purchaseRepository.findAll();
		List<Purchase> purchaseList = new ArrayList<Purchase>();
    	Purchase purchaseModel = new Purchase();
    	List<Products> products = new ArrayList<Products>();
        
        for(int x = 0; x < purchases.size(); x++) { 	
        	if(purchaseNumber == 0) {
            	UserModel userModel = userRepository.findById((long) purchases.get(x).getUserID()).orElse(null);
            	
        		purchaseModel.setPurchaseID(purchases.get(x).getPurchaseNumber());
            	purchaseModel.setUserName(userModel.getUserName());
            	purchaseModel.setUserID(userModel.getUserID());
            	purchaseNumber = purchases.get(x).getPurchaseNumber();
            	
        	}
        	
        	if(purchases.get(x).getPurchaseNumber() == purchaseNumber && purchases.get(x).getUserID() == purchaseModel.getUserID()) {
        		ProductsModel productModel = productRepository.findById((long) purchases.get(x).getProductID()).orElse(null);
            	
            	if( productModel != null) {
                	Products product = new Products();

                	product.setProductID((long) purchases.get(x).getProductID());
                	product.setProductName(productModel.getProductName());
                	product.setQty(purchases.get(x).getQty());
                	product.setLoyaltyPoints(purchases.get(x).getLoyaltyPoints());
                	
                	products.add(product);
            	}
        	}
        	
        	if(purchases.get(x).getPurchaseNumber() != purchaseNumber || purchases.get(x).getUserID() != purchaseModel.getUserID()){
        		purchaseModel.setProducts(products);
        		purchaseList.add(purchaseModel);
        		
        		purchaseModel = new Purchase();            	
            	products = new ArrayList<Products>();
        		
            	UserModel userModel = userRepository.findById((long) purchases.get(x).getUserID()).orElse(null);
            	
        		purchaseModel.setPurchaseID(purchases.get(x).getPurchaseNumber());
            	purchaseModel.setUserName(userModel.getUserName());
            	purchaseModel.setUserID(userModel.getUserID());
            	
            	ProductsModel productModel = productRepository.findById((long) purchases.get(x).getProductID()).orElse(null);
            	
            	if( productModel != null) {
                	Products product = new Products();

                	product.setProductID((long) purchases.get(x).getProductID());
                	product.setProductName(productModel.getProductName());
                	product.setQty(purchases.get(x).getQty());
                	product.setLoyaltyPoints(purchases.get(x).getLoyaltyPoints());
                	
                	products.add(product);
            	}
            	purchaseNumber = purchases.get(x).getPurchaseNumber();
        	}else if(x == purchases.size()-1) {
        		purchaseModel.setProducts(products);
        		purchaseList.add(purchaseModel);
            	purchaseNumber = purchases.get(x).getPurchaseNumber();
        		
        	}
        }

        purchaseNumber = 0L;
        
        logger.info("[GET] Exiting to getAllPurchases()");
        return purchaseList;
	}

	public Object newPurchaseService(NewPurchase purchase) {
        logger.info("[GET] Entering to newPurchaseService()");
    	UserModel userModel = userRepository.findById(purchase.getUserID()).orElse(null);
    	
    	if(userModel!=null) {
    		List<PurchaseModel> purchases = purchaseRepository.getByUserID(purchase.getUserID());
    		if(purchases.isEmpty()) {
    			purchase.getProducts().forEach(product -> {
            		ProductsModel productModel = productRepository.findById(product.getProductID()).orElse(null);
            		if(productModel!=null) {
        				PurchaseModel newPurchase = new PurchaseModel();
        				
        				newPurchase.setPurchaseNumber(1L);
        				newPurchase.setUserID(purchase.getUserID());
        				newPurchase.setProductID(product.getProductID());
        				newPurchase.setQty(product.getQty());
        				newPurchase.setLoyaltyPoints(product.getQty() * productModel.getLoyaltyPoints()); 
        				
        				purchaseRepository.save(newPurchase);
                        logger.info("New Purchase Succesfully created for UserID ::: " + newPurchase.getUserID()); 
                        
                        //Actualizar los Puntos del Cliente
                        userModel.setLoyaltyPoints(userModel.getLoyaltyPoints() + (productModel.getLoyaltyPoints() * product.getQty()));
                        userRepository.save(userModel);
                        
                        //Actualizar los productos Restantes
                        productModel.setQty(productModel.getQty() - product.getQty());
                        productRepository.save(productModel);
            		}
    			});
                logger.info("New Purchase Succesfully created");    			
    		}else {
    			purchase.getProducts().forEach(product -> {
            		ProductsModel productModel = productRepository.findById(product.getProductID()).orElse(null);
            		if(productModel!=null) {
        				PurchaseModel newPurchase = new PurchaseModel();
        				
        				newPurchase.setPurchaseNumber(purchases.get(purchases.size() - 1).getPurchaseNumber() + 1);
        				newPurchase.setUserID(purchase.getUserID());
        				newPurchase.setProductID(product.getProductID());
        				newPurchase.setQty(product.getQty());
        				newPurchase.setLoyaltyPoints(product.getQty() * productModel.getLoyaltyPoints()); 

        				purchaseRepository.save(newPurchase);
                        logger.info("New Purchase Succesfully created for UserID ::: " + newPurchase.getUserID());  	
                        
                        //Actualizar los Puntos del Cliente
                        userModel.setLoyaltyPoints(userModel.getLoyaltyPoints() + (productModel.getLoyaltyPoints() * product.getQty()));
                        userRepository.save(userModel);
                        
                        //Actualizar los productos Restantes
                        productModel.setQty(productModel.getQty() - product.getQty());
                        productRepository.save(productModel);
            		}
    			});		
    		}
    	}
    	
    	MessageResponse response = new MessageResponse(200, "New PURCHASE Succesfully Created.");
        logger.info("[GET] Exiting to newPurchaseService()");
		return response;
	}

}
