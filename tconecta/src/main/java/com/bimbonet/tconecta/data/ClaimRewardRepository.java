package com.bimbonet.tconecta.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bimbonet.tconecta.model.ClaimRewardModel;

@Repository
public interface ClaimRewardRepository extends JpaRepository<ClaimRewardModel, Long>{

}
