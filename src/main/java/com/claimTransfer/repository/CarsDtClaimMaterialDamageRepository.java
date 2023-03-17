package com.claimTransfer.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.claimTransfer.model.CarsDtClaimMaterialDamage;

public interface CarsDtClaimMaterialDamageRepository extends JpaRepository<CarsDtClaimMaterialDamage, String>{
	
//	@Query(value = "SELECT *  FROM CARS_DT_CLAIM_MATERIAL_DAMAGE WHERE INS_ID = 10 "
//			+ "AND SCRIPT_NAME = 'CFA-200121-01' "
//			+ "AND NOTIFICATION = 1230011319 " , nativeQuery = true)
//	@Query(value = "SELECT * FROM CARS_DT_CLAIM_MATERIAL_DAMAGE WHERE INS_ID = 10 "
//			+ "AND SCRIPT_NAME = 'SARP-20210104-03' "
//			+ "AND NOTIFICATION = 19073546 " , nativeQuery = true)
	
	@Query(value = "SELECT *  FROM CARS_DT_CLAIM_MATERIAL_DAMAGE WHERE INS_ID = trim(?1) "
			+ "AND SCRIPT_NAME = trim(?2) "
			+ "AND NOTIFICATION = trim(?3) order by MAT_DAMAGE_SEQUENCE ASC " , nativeQuery = true)
	List<CarsDtClaimMaterialDamage> getCarsDtClaimMaterialDamage(String insuranceId ,String scriptName,String notification);
}
