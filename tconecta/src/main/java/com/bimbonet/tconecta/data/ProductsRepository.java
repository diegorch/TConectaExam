package com.bimbonet.tconecta.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bimbonet.tconecta.model.ProductsModel;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel, Long>{

}
