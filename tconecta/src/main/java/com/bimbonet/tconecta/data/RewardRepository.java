package com.bimbonet.tconecta.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bimbonet.tconecta.model.RewardModel;

@Repository
public interface RewardRepository extends JpaRepository<RewardModel, Long>{

}
