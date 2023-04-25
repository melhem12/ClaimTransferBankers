package com.claimTransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.claimTransfer.model.CarsDtClaimC;

public interface CarsDtClaimCRepository extends JpaRepository<CarsDtClaimC, String>{
	
//	@Query(value=" select * FROM CARS_DT_CLAIM_C WHERE INS_ID = 10 "
//			+ " AND SCRIPT_NAME='CFA-200121-01' "
//			+ " AND NOTIFICATION = 1230011319  AND NVL(ELABORATED,'N') = 'N' ORDER BY NOTIFICATION ",nativeQuery =true )
//	@Query(value=" select *  FROM CARS_DT_CLAIM_C WHERE INS_ID = 10 "
//			+ " AND SCRIPT_NAME='SARP-20210104-03' "
//			+ " AND NOTIFICATION = 19073546   ORDER BY NOTIFICATION "
	//	,nativeQuery =true )
//AND NVL(ELABORATED,'N') = 'N'
	
	@Query(value=" select *  FROM CARS_DT_CLAIM_C WHERE INS_ID = trim(?1) "
	+ " AND SCRIPT_NAME=trim(?2) "
	+ " AND NOTIFICATION = trim(?3)   ORDER BY NOTIFICATION "
	,nativeQuery =true )
	List<CarsDtClaimC> getCarsDtClaimC(String insuranceId ,String scriptName,String notification);



	@Query(value = " SELECT CONFIG_VALUE FROM CORE_CONFIGURATION WHERE ID = ?1 ", nativeQuery = true)
	String findConfigByKey(String key);
	
}