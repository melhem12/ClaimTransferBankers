package com.claimTransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.claimTransfer.model.CarsDtClaimBodilyInjury;

public interface CarsDtClaimBodilyInjuryRepository extends JpaRepository<CarsDtClaimBodilyInjury, String>{

//	@Query(value = "SELECT *  FROM CARS_DT_CLAIM_BODILY_INJURY WHERE INS_ID = 10 "
//			+ " AND SCRIPT_NAME = 'CFA-200121-01' "
//			+ " AND NOTIFICATION = 1230011319 " ,nativeQuery = true)
//	@Query(value = "SELECT *  FROM CARS_DT_CLAIM_BODILY_INJURY WHERE INS_ID = 10 "
//			+ " AND SCRIPT_NAME = 'SARP-20210104-03' "
//			+ " AND NOTIFICATION = 19073546 " ,nativeQuery = true)
	
//	@Query(value = " from CarsDtClaimBodilyInjury as c WHERE c.insID = 10 "
//			+ " AND c.scriptName = 'CFA-200121-01' "
//			+ " AND c.notification = 1230011319 " ,nativeQuery = false)
	
	@Query(value = " from CarsDtClaimBodilyInjury as c WHERE c.insID = trim(?1) "
			+ " AND c.scriptName = trim(?2) "
			+ " AND c.notification = trim(?3) " ,nativeQuery = false)
	List<CarsDtClaimBodilyInjury> getCarsDtClaimBodilyInjury(String insuranceId ,String scriptName,String notification);
}