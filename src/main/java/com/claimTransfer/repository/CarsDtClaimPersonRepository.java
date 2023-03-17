package com.claimTransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.claimTransfer.model.CarsDtClaimPerson;
import com.claimTransfer.response.CarsDtClaimPersonResponse;

public interface CarsDtClaimPersonRepository extends JpaRepository<CarsDtClaimPerson, String>{
	
//	@Query(value=" SELECT "
//			+ " DT_ID  ,VEH_SEQ   ,TP_RESP  ,OWNER_FAMILY_NAME  ,OWNER_FISRT_NAME  ,DRIVER_FAMILY_NAME  ,DRIVER_FISRT_NAME ,DRIVER_PHONE, "
//			+ " GENDER ,DOB ,MAKE_CODE ,MODEL_CODE ,VEHICLE_YEAR ,RTRIM(LTRIM(TRANSLATE(UPPER(PLATE),'0123456789/-*',' '),' '),' ')  PLATE_PREFIX,LTRIM(RTRIM(LTRIM(REPLACE(REPLACE(REPLACE(REPLACE(UPPER(PLATE),RTRIM(LTRIM(TRANSLATE(UPPER(PLATE),'0123456789/-*',' '),' '),' '),' '),'/',' '),'*',' '),'-',' '),' '),' '),'0')  PLATE_NUMBER,TP_COMPANY_ID  , "
//			+ " TP_COMPANY_NAME  , SCRIPT_NAME,NOTIFICATION FROM CARS_DT_CLAIM_PERSON WHERE INS_ID = 10 "
//			+ " AND SCRIPT_NAME='CFA-200121-01' "
//			+ "AND NOTIFICATION = 1230011319 " ,nativeQuery =true )
//	@Query(value=" SELECT "
//			+ " DT_ID  ,VEH_SEQ   ,TP_RESP  ,OWNER_FAMILY_NAME  ,OWNER_FISRT_NAME  ,DRIVER_FAMILY_NAME  ,DRIVER_FISRT_NAME ,DRIVER_PHONE, "
//			+ " GENDER ,DOB ,MAKE_CODE ,MODEL_CODE ,VEHICLE_YEAR ,RTRIM(LTRIM(TRANSLATE(UPPER(PLATE),'0123456789/-*',' '),' '),' ')  PLATE_PREFIX,LTRIM(RTRIM(LTRIM(REPLACE(REPLACE(REPLACE(REPLACE(UPPER(PLATE),RTRIM(LTRIM(TRANSLATE(UPPER(PLATE),'0123456789/-*',' '),' '),' '),' '),'/',' '),'*',' '),'-',' '),' '),' '),'0')  PLATE_NUMBER,TP_COMPANY_ID  , "
//			+ " TP_COMPANY_NAME  , SCRIPT_NAME,NOTIFICATION FROM CARS_DT_CLAIM_PERSON WHERE INS_ID = 10 "
//			+ " AND SCRIPT_NAME='SARP-20210104-03' "
//			+ "AND NOTIFICATION = 19073546 " ,nativeQuery =true )
	
	@Query(value=" SELECT "
	+ " DT_ID  ,VEH_SEQ   ,OWNER_FATHER_NAME,OWNER_FAMILY_NAME  ,OWNER_FISRT_NAME  ,DRIVER_FAMILY_NAME  ,DRIVER_FATHER_NAME,DRIVER_FISRT_NAME ,DRIVER_PHONE, "
	+ " GENDER ,DOB ,MAKE_CODE ,MODEL_CODE ,VEHICLE_YEAR ,RTRIM(LTRIM(TRANSLATE(UPPER(PLATE),'0123456789/-*',' '),' '),' ')  PLATE_PREFIX,LTRIM(RTRIM(LTRIM(REPLACE(REPLACE(REPLACE(REPLACE(UPPER(PLATE),RTRIM(LTRIM(TRANSLATE(UPPER(PLATE),'0123456789/-*',' '),' '),' '),' '),'/',' '),'*',' '),'-',' '),' '),' '),'0')  PLATE_NUMBER,TP_COMPANY_ID  , "
	+ " TP_COMPANY_NAME  , SCRIPT_NAME,NOTIFICATION,LICENSE_NO,LIC_EXPIRY_DATE,LICENSE_TYPE,LIC_INCEPTION_DATE ,TP_COMPANY_CODE ,TP_POLICY_NUM FROM CARS_DT_CLAIM_PERSON WHERE INS_ID = trim(?1) "
	+ " AND SCRIPT_NAME= trim(?2) "
	+ "AND NOTIFICATION = trim(?3) order by  VEH_SEQ ASC  " ,nativeQuery =true )
	List<CarsDtClaimPersonResponse> getCarsDtClaimPerson(String insuranceId ,String scriptName,String notification);
}
