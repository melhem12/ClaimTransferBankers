package com.claimTransfer.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.claimTransfer.model.CarsDtClaimSettls;

public interface CarsDtClaimSettlsRepository extends JpaRepository<CarsDtClaimSettls, String>{
	
//	@Query(value = "SELECT *  FROM CARS_DT_CLAIM_SETTLS WHERE INS_ID = 10 "
//			+ "AND SCRIPT_NAME = 'CFA-200121-01' "
//			+ "AND NOTIFICATION = 1230011319 "
//			+ "AND COVER_CODE = trim(?1)"
//			+"AND SET_TYPE=trim(?2) "
		//	, nativeQuery = true)
//	@Query(value = " SELECT * FROM CARS_DT_CLAIM_SETTLS WHERE INS_ID = 10 "
//			+ " AND SCRIPT_NAME = 'SARP-20210104-03' "
//			+ " AND NOTIFICATION = 19073546 "
//			+ " AND COVER_CODE = trim(?1) " , nativeQuery = true)
@Query(value = "SELECT *  FROM CARS_DT_CLAIM_SETTLS WHERE INS_ID = trim(?1) "
		+ " AND SCRIPT_NAME = trim(?2) "
		+ " AND NOTIFICATION = trim(?3) "
		+ " AND COVER_CODE = trim(?4) "
		+" AND SET_TYPE=trim(?5) " +
		" AND  NOTIFICATION_SEQ=trim(?6) "
		+" AND PAYEE_CODE = trim(?7)  AND  CURRENCY =trim(?8)  AND TRANSACTION =trim(?9)  " , nativeQuery = true)
	List<CarsDtClaimSettls> getCarsDtClaimSettls(String insuranceId , String scriptName, String notification, String coverCode, String riskType , String notificationSequence, String payeeCode,String currency,String transaction);

	@Query(value = "SELECT *  FROM CARS_DT_CLAIM_SETTLS WHERE INS_ID = trim(?1) "
			+ " AND SCRIPT_NAME = trim(?2) "
			+ " AND NOTIFICATION = trim(?3) "
			+ " AND COVER_CODE = trim(?4) "
			+" AND SET_TYPE=trim(?5) " +
			" AND  NOTIFICATION_SEQ=trim(?6) "
			+" AND PAYEE_CODE IS NULL  AND  CURRENCY =trim(?7)  AND TRANSACTION = trim(?8) " , nativeQuery = true)
	List<CarsDtClaimSettls> getCarsDtClaimSettlsNullPayeeCode(String insuranceId , String scriptName, String notification, String coverCode, String riskType , String notificationSequence, String currenc,String transaction);
}


