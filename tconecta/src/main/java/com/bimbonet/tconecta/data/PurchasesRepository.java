package com.bimbonet.tconecta.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bimbonet.tconecta.model.PurchaseModel;

@Repository
public interface PurchasesRepository extends JpaRepository<PurchaseModel, Long>{

	List<PurchaseModel> getByUserID(Long userID);

}
