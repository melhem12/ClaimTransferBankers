package com.claimTransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.claimTransfer.model.CarsDtClaimCCovers;

public interface CarsDtClaimCCoversRepository extends JpaRepository<CarsDtClaimCCovers, String> {
//	@Query(value = "SELECT *  FROM CARS_DT_CLAIM_C_COVERS WHERE INS_ID = 10 "
//	+ "AND SCRIPT_NAME = 'CFA-200121-01' "
//	+ "AND NOTIFICATION = 1230011319 "
//	+" AND SEQ=?1 "
//	, nativeQuery = true)
//@Query(value = "SELECT * FROM CARS_DT_CLAIM_C_COVERS WHERE INS_ID = 10 "
//	+ "AND SCRIPT_NAME = 'SARP-20210104-03' "	
//	+ "AND NOTIFICATION = 19073546 "
//	+" AND SEQ=?1 "
//	, nativeQuery = true)

@Query(value = "SELECT *  FROM CARS_DT_CLAIM_C_COVERS WHERE INS_ID = trim(?1) "
+ "AND SCRIPT_NAME = trim(?2) "
+ "AND NOTIFICATION = trim(?3) "
+" AND SEQ=trim(?4) ", nativeQuery = true)
	List<CarsDtClaimCCovers> getCarsDtClaimCCovers(String insuranceId ,String scriptName,String notification,Integer seq);
}
