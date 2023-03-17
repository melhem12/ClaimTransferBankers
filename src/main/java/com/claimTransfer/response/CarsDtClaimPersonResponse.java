package com.claimTransfer.response;

import org.springframework.beans.factory.annotation.Value;


public interface CarsDtClaimPersonResponse {
	
	
	@Value("#{target.DT_ID}")
	String getDtId();

	@Value("#{target.VEH_SEQ}")
	String getVehSeq();

	@Value("#{target.TP_RESP}")
	String getTpResp();
	
	@Value("#{target.OWNER_FAMILY_NAME}")
	String getOwnerFamilyName();
	
	@Value("#{target.OWNER_FATHER_NAME}")
	String getOwnerFatherName();
	
	@Value("#{target.OWNER_FISRT_NAME}")
	String getOwnerFirstName();
	
	@Value("#{target.DRIVER_FAMILY_NAME}")
	String getDriverFamilyName();
	
	@Value("#{target.DRIVER_FATHER_NAME}")
	String getDriverFatherName();
	
	@Value("#{target.DRIVER_FISRT_NAME}")
	String getDriverFisrtName();
	
	@Value("#{target.DRIVER_PHONE}")
	String getDriverPhone();
	
	@Value("#{target.GENDER}")
	String getGender();
	
	@Value("#{target.DOB}")
	String getDob();
	
	@Value("#{target.MAKE_CODE}")
	String getMakeDescription();
	
	@Value("#{target.MODEL_CODE}")
	String getModelDescription();
	
	@Value("#{target.VEHICLE_YEAR}")
	String getVehicleYear();
	
	@Value("#{target.PLATE_PREFIX}")
	String getPlatePrefix();
	
	@Value("#{target.PLATE_NUMBER}")
	String getPlateNumber();
	
	@Value("#{target.TP_COMPANY_ID}")
	String getTpCompanyId();
	
	@Value("#{target.TP_COMPANY_NAME}")
	String getTpCompanyName();
	
	@Value("#{target.SCRIPT_NAME}")
	String getScriptName();
	
	@Value("#{target.NOTIFICATION}")
	String getNotification();
	
	@Value("#{target.LICENSE_NO}")
	String getLicenseNo();
	
	@Value("#{target.LIC_EXPIRY_DATE}")
	String getLicExpiryDate();
	
	@Value("#{target.LICENSE_TYPE}")
	String getLicenseType();
	
	@Value("#{target.LIC_INCEPTION_DATE}")
	String getLicInceptionDate();


	@Value("#{target.TP_COMPANY_CODE}")
	String getTpCompanyCode();

	@Value("#{target.TP_POLICY_NUM}")
	String getTpPolicyNum();









}