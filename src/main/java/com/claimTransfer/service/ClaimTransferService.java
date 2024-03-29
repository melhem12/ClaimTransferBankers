package com.claimTransfer.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import com.claimTransfer.config.SendingMail;
import com.claimTransfer.model.*;
import com.claimTransfer.repository.*;
import com.claimTransfer.request.*;
import com.claimTransfer.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.claimTransfer.config.Utility;

import ch.qos.logback.classic.pattern.Util;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

@Service
public class ClaimTransferService {

	@Autowired
	CarsDtClaimCRepository carsDtClaimCRepository;

	@Autowired
	CarsDtClaimPersonRepository carsDtClaimPersonRepository;
	@Autowired
	CarsDtClaimsLogsRepository carsDtClaimsLogsRepository;
	@Autowired
	CarsDtClaimBodilyInjuryRepository carsDtClaimBodilyInjuryRepository;

	@Autowired
	CarsDtClaimMaterialDamageRepository carsDtClaimMaterialDamageRepository;

	@Autowired
	CarsDtClaimCCoversRepository carsDtClaimCCoversRepository;
	@Autowired
	CarsInsuranceRepository carsInsuranceRepository;
	@Autowired
	CarsDtClaimSettlsRepository carsDtClaimSettlsRepository;
	private SimpleJdbcCall simpleJdbcCall;
	private SimpleJdbcCall simpleJdbcCall2;
	private String companyName = "";
	/* Calling Stored Procedure using SimpleJdbcCall */
	private String baseUrl = "";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String procedure(String company, Date fromDate, Date toDate, String notification, String batch, String functionName) {
		System.out.println("///////////////////////////////////");
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withFunctionName(functionName)
				.declareParameters(new SqlParameter("u_id", Types.BIGINT));

		String out = simpleJdbcCall.executeFunction(String.class,

				new MapSqlParameterSource("I_COMPANY", company)
						.addValue("I_FROM_DATE", fromDate)
						.addValue("I_TO_DATE", toDate)
						.addValue("I_BATCH", batch)
						.addValue("I_NOTIFICATION", notification));
		return out;


	}


	public ResponseEntity<ClaimsResponse> generateClaimsSurvey(String notification,
															   String insuranceId, String fromDate, String batch, String toDate, String functionName) throws Exception {



		Optional<CarsInsurance> carsInsurance = carsInsuranceRepository.findById(insuranceId);
		carsInsurance.ifPresent(value -> companyName = value.getInsuranceDesc());
		String scriptName = "CTST" + "-" + changeFormatForScript(toDate) + "-" + batch;
		if(TestApi(insuranceId,scriptName,notification,companyName)){

		ClaimsResponse claimsResponse = new ClaimsResponse();
		String out = procedure(insuranceId, new SimpleDateFormat("dd-MMM-yyyy").parse(fromDate), new SimpleDateFormat("dd-MMM-yyyy").parse(toDate), notification, batch, functionName);
		System.out.println("fuction>>>>  " + out);


		List<CarsDtClaimC> carsDtClaimCList = carsDtClaimCRepository.getCarsDtClaimC(insuranceId, scriptName,
				notification);

		List<ClaimTransferRequest> claimTransferRequestList = new ArrayList<ClaimTransferRequest>();

		for (CarsDtClaimC carsDtClaimC : carsDtClaimCList) {
			ClaimTransferRequest claimTransferRequest = new ClaimTransferRequest();
			claimTransferRequest.setClaimTransferId(carsDtClaimC.getDtId());
			if (carsDtClaimC.getStatusDate() != null) {
				claimTransferRequest.setAccidentDate(stringToYear(carsDtClaimC.getAccidentDate()));
			}

			if (carsDtClaimC.getAccidentTime() != null) {
				claimTransferRequest.setAccidentTime(carsDtClaimC.getAccidentTime());
			}

			claimTransferRequest.setClaimTransferNumber(carsDtClaimC.getClaimNum());
			claimTransferRequest.setPolicyId(carsDtClaimC.getPolicyId());

			claimTransferRequest.setPolicyNumber(carsDtClaimC.getPolicySerie());


			claimTransferRequest
					.setVehicleCertificate(String.format("%04d", Integer.parseInt(carsDtClaimC.getVehicleSerie())));
			claimTransferRequest.setClaimTransferNotification(carsDtClaimC.getNotification());
			if (carsDtClaimC.getReportedDate() != null) {
				claimTransferRequest.setReportedDate(stringToYear(carsDtClaimC.getReportedDate()));
			}


			if (carsDtClaimC.getReportedTime() != null) {
				claimTransferRequest.setReportedTime(carsDtClaimC.getReportedTime());
			}

			claimTransferRequest.setStatusCode(carsDtClaimC.getStatusCode());
			claimTransferRequest.setStatusDescription(carsDtClaimC.getStatusDescription());
			if (carsDtClaimC.getStatusDate() != null) {
				claimTransferRequest.setStatusDate(stringToYear(carsDtClaimC.getStatusDate()));
			}
			claimTransferRequest.setAccidentLatitude(carsDtClaimC.getAccidentLatitude());
			claimTransferRequest.setAccidentLongitude(carsDtClaimC.getAccidentLongitude());
			claimTransferRequest.setAccidentLocation_Desc(carsDtClaimC.getAccidentLocation());

			claimTransferRequest.setAccidentLocation_Caza(carsDtClaimC.getAccidentLocationCAZA());

			claimTransferRequest.setAccidentLocation_Mohafaza(carsDtClaimC.getAccidentLocationDistrict());


			claimTransferRequest.setRiskType(carsDtClaimC.getDefaultRiskType());
			claimTransferRequest.setCoverCode(carsDtClaimC.getDefaultCoverCode());
			claimTransferRequest.setClaimReason(carsDtClaimC.getClaimReason());
			claimTransferRequest.setClaimRelatedNotification(carsDtClaimC.getRelatedNotification());
			claimTransferRequest.setTotalReserve(carsDtClaimC.getReserveAmountUsd());
			claimTransferRequest.setTotalPaid(carsDtClaimC.getTotalPaidUsd());
			claimTransferRequest.setExpertCode(carsDtClaimC.getExpertCode());
			claimTransferRequest.setExpertName(carsDtClaimC.getExpertName());
			claimTransferRequest.setReserveCurrency(carsDtClaimC.getCurrency());
			claimTransferRequest.setCertifId(carsDtClaimC.getPolicyCertifId());
			claimTransferRequest.setReserveDifference(carsDtClaimC.getReserveDifference());
			if (!Utility.isEmpty(carsDtClaimC.getReserveAmountUsd())
					&& !Utility.isEmpty(carsDtClaimC.getTotalPaidUsd())) {
				claimTransferRequest.setTotalOS(String.valueOf(Double.valueOf(carsDtClaimC.getReserveAmountUsd())
						- Double.valueOf(carsDtClaimC.getTotalPaidUsd())));
			}
			List<CarsDtClaimPersonResponse> carsDtClaimPersonResponseList = carsDtClaimPersonRepository
					.getCarsDtClaimPerson(insuranceId, scriptName, notification);

			List<ClaimTransferPersonRequest> claimTransferPersonRequestList = new ArrayList<ClaimTransferPersonRequest>();


			if (carsDtClaimPersonResponseList != null) {

				for (CarsDtClaimPersonResponse carsDtClaimPersonResponse : carsDtClaimPersonResponseList) {

					ClaimTransferPersonRequest claimTransferPersonRequest = new ClaimTransferPersonRequest();
					claimTransferPersonRequest.setSequence(carsDtClaimPersonResponse.getDtId());
					claimTransferPersonRequest.setVehicleSequence(carsDtClaimPersonResponse.getVehSeq());
					// claimTransferPersonRequest.setResponsibility(item2.getTpResp());

					ClaimTransferVehicleRequest claimTransferVehicleRequest = new ClaimTransferVehicleRequest();
					claimTransferVehicleRequest.setOwnerFamilyName(carsDtClaimPersonResponse.getOwnerFamilyName());
					claimTransferVehicleRequest.setOwnerMiddleName(carsDtClaimPersonResponse.getOwnerFatherName());
					claimTransferVehicleRequest.setOwnerFirstName(carsDtClaimPersonResponse.getOwnerFirstName());
					claimTransferVehicleRequest.setDriverFirstName(carsDtClaimPersonResponse.getDriverFisrtName());
					claimTransferVehicleRequest.setDriverMiddleName(carsDtClaimPersonResponse.getDriverFatherName());
					claimTransferVehicleRequest.setDriverFamilyName(carsDtClaimPersonResponse.getDriverFamilyName());
					claimTransferVehicleRequest.setDriverPhone(carsDtClaimPersonResponse.getDriverPhone());
					claimTransferVehicleRequest.setDriverGender(carsDtClaimPersonResponse.getGender());
					if (carsDtClaimPersonResponse.getDob() != null) {
						claimTransferVehicleRequest.setDriverDob(stringToYear(carsDtClaimPersonResponse.getDob()));
					}
					claimTransferVehicleRequest.setMakeDescription(carsDtClaimPersonResponse.getMakeDescription());
					claimTransferVehicleRequest.setModelDescription(carsDtClaimPersonResponse.getModelDescription());
					claimTransferVehicleRequest.setVehicleYear(carsDtClaimPersonResponse.getVehicleYear());
					claimTransferVehicleRequest.setPlatePrefix(carsDtClaimPersonResponse.getPlatePrefix());
					claimTransferVehicleRequest.setPlateNumber(carsDtClaimPersonResponse.getPlateNumber());
					claimTransferVehicleRequest.setTpCompanyCode(carsDtClaimPersonResponse.getTpCompanyCode());
					claimTransferVehicleRequest.setTpCompanyName(carsDtClaimPersonResponse.getTpCompanyName());
					claimTransferVehicleRequest.setTpPolicyNumber(carsDtClaimPersonResponse.getTpPolicyNum());
					// claimTransferVehicleRequest.setPolEffective(item2.getPolEffective);
					// claimTransferVehicleRequest.setPolExpiry(item2.getPolExpiry);
					claimTransferVehicleRequest.setDrivingLicenseNumber(carsDtClaimPersonResponse.getLicenseNo());


					if (carsDtClaimPersonResponse.getLicExpiryDate() != null) {
						claimTransferVehicleRequest.setDrivingLicenseExpiryDate(stringToYear(carsDtClaimPersonResponse.getLicExpiryDate()));

					}


					claimTransferVehicleRequest.setDrivingLicenseType(carsDtClaimPersonResponse.getLicenseType());


					if (carsDtClaimPersonResponse.getLicInceptionDate() != null) {
						claimTransferVehicleRequest.setDrivingLicenseInceptionDate(stringToYear(carsDtClaimPersonResponse.getLicInceptionDate()));

					}


					claimTransferPersonRequest.setClaimTransferVehicleRequest(claimTransferVehicleRequest);

					List<CarsDtClaimCCovers> carsDtClaimCCoversList = carsDtClaimCCoversRepository
							.getCarsDtClaimCCovers(insuranceId, scriptName, notification,
									Integer.valueOf(carsDtClaimPersonResponse.getVehSeq()));

					if (carsDtClaimCCoversList != null) {
						List<ClaimTransferCoverRequest> claimTransferCoverRequestList = new ArrayList<ClaimTransferCoverRequest>();

						for (CarsDtClaimCCovers carsDtClaimCCovers : carsDtClaimCCoversList) {

							ClaimTransferCoverRequest claimTransferCoverRequest = new ClaimTransferCoverRequest();


							String sequence = "";

							String profileCode = "";
							if (carsDtClaimCCovers.getPayeeProfileCode() != null) {
								profileCode = carsDtClaimCCovers.getPayeeProfileCode();
							} else {
								profileCode = "PERSON";
							}

							String profileType = "";
							if (carsDtClaimCCovers.getPayeeProfileType() != null) {
								profileType = carsDtClaimCCovers.getPayeeProfileType();
							} else {
								profileType = "PERSON";
							}

							String[] splitCoverCode = carsDtClaimCCovers.getCoverCode().split("\\.", 2);
							if (!Utility.isEmpty(claimTransferRequest.getClaimTransferNotification())) {
								sequence = claimTransferRequest.getClaimTransferNotification();
							}

							if (!Utility.isEmpty(carsDtClaimPersonResponse.getVehSeq()) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + carsDtClaimPersonResponse.getVehSeq();
							} else {
								sequence = carsDtClaimPersonResponse.getVehSeq();

							}


							if (!Utility.isEmpty((splitCoverCode[0])) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + splitCoverCode[0];
								claimTransferCoverRequest.setCoverCode(splitCoverCode[0]);
							} else {
								sequence = splitCoverCode[0];
								claimTransferCoverRequest.setCoverCode(splitCoverCode[0]);
							}


							if (splitCoverCode.length > 1) {
								if (!Utility.isEmpty(splitCoverCode[1])) {
									sequence = sequence + "-" + splitCoverCode[1];
									claimTransferCoverRequest.setSubcoverCode(splitCoverCode[1]);
								}
							}

							if (!Utility.isEmpty(carsDtClaimCCovers.getPayeeAssessmentType()) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + carsDtClaimCCovers.getPayeeAssessmentType();
							} else {
								sequence = carsDtClaimCCovers.getPayeeAssessmentType();

							}


							if (!Utility.isEmpty(profileType) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + profileType;
							} else {
								sequence = profileType;

							}

							if (!Utility.isEmpty(profileCode) && !Utility.isEmpty(sequence)) {

								sequence = sequence + "-" + profileCode;
							} else {
								sequence = profileCode;

							}


							if (!Utility.isEmpty(carsDtClaimCCovers.getCurrency())) {
								sequence = sequence + "-" + carsDtClaimCCovers.getCurrency();
							}


							claimTransferCoverRequest.setSequence(sequence);


							claimTransferCoverRequest.setRiskType(carsDtClaimCCovers.getSetType());
							if (carsDtClaimCCovers.getPayeeProfileType() != null) {
								claimTransferCoverRequest.setProfileType(carsDtClaimCCovers.getPayeeProfileType());

							} else {
								claimTransferCoverRequest.setProfileType("");

							}


							if (carsDtClaimCCovers.getPayeeProfileCode() != null) {
								claimTransferCoverRequest.setProfileCode(carsDtClaimCCovers.getPayeeProfileCode());

							} else {
								claimTransferCoverRequest.setProfileCode("");

							}


							claimTransferCoverRequest.setAssessmentType(carsDtClaimCCovers.getPayeeAssessmentType());

							claimTransferCoverRequest.setReserveAmount(carsDtClaimCCovers.getReserveAmount());

							claimTransferCoverRequest
									.setRecoveryReserveAmount(carsDtClaimCCovers.getRecoveryReserveAmount());
							claimTransferCoverRequest.setReserveCurrency(carsDtClaimCCovers.getCurrency());


							// claimTransferCoverRequest.setRiskType("");
							List<ClaimTransferSettlementRequest> claimTransferSettlementRequestList = new ArrayList<ClaimTransferSettlementRequest>();
							List<CarsDtClaimSettls> carsDtClaimSettlsList = null;


							String transaction ="1";
							if(carsDtClaimCCovers.getRecoveryReserveAmount()!=null&&carsDtClaimCCovers.getReserveAmount()!=null){

								if(Double.parseDouble(carsDtClaimCCovers.getRecoveryReserveAmount())>0){
									transaction="2";
								}
								if(Double.parseDouble(carsDtClaimCCovers.getReserveAmount())>0){
									transaction="1";
								}

							}
							if (Utility.isEmpty(carsDtClaimCCovers.getPayeeProfileCode())) {

								carsDtClaimSettlsList = carsDtClaimSettlsRepository
										.getCarsDtClaimSettlsNullPayeeCode(insuranceId, scriptName, notification,
												carsDtClaimCCovers.getCoverCode(), carsDtClaimCCovers.getSetType(), carsDtClaimCCovers.getNotificationSeq(),carsDtClaimCCovers.getCurrency(),transaction);
							} else {
								carsDtClaimSettlsList = carsDtClaimSettlsRepository
										.getCarsDtClaimSettls(insuranceId, scriptName, notification,
												carsDtClaimCCovers.getCoverCode(), carsDtClaimCCovers.getSetType(), carsDtClaimCCovers.getNotificationSeq(), carsDtClaimCCovers.getPayeeProfileCode(),carsDtClaimCCovers.getCurrency(),transaction);

							}


							if (carsDtClaimSettlsList != null) {

								for (CarsDtClaimSettls carsDtClaimSettls : carsDtClaimSettlsList) {

									ClaimTransferSettlementRequest claimTransferSettlementRequest = new ClaimTransferSettlementRequest();
									claimTransferSettlementRequest.setTransaction(carsDtClaimSettls.getTransaction());
//									claimTransferSettlementRequest
//											.setPaymentSequence(claimTransferRequest.getClaimRelatedNotification());
									claimTransferSettlementRequest.setCurrency(carsDtClaimSettls.getCurrency());
									claimTransferSettlementRequest.setPaidAmount(carsDtClaimSettls.getPaidAmount());
									claimTransferSettlementRequest.setPaymentSequence(carsDtClaimSettls.getPaymentSequence());
									if (carsDtClaimSettls.getPaymentDate() != null) {
										claimTransferSettlementRequest
												.setPaymentDate(stringToYear(carsDtClaimSettls.getPaymentDate()));
									}
									// claimTransferSettlementRequest.setPayeeType(item4.getPayeeType());
									if (carsDtClaimSettls.getPayeeTypeCode() != null) {
										claimTransferSettlementRequest
												.setPayeeTypeCode(carsDtClaimSettls.getPayeeTypeCode());
									} else {
										claimTransferSettlementRequest
												.setPayeeTypeCode("");
									}


									claimTransferSettlementRequest
											.setPayeeTypeDescription(carsDtClaimSettls.getPayeeTypeDescription());
									if (carsDtClaimSettls.getPayeeCode() != null) {
										claimTransferSettlementRequest.setPayeeCode(carsDtClaimSettls.getPayeeCode());

									} else {
										claimTransferSettlementRequest.setPayeeCode("");

									}
									claimTransferSettlementRequest.setPayeeName(carsDtClaimSettls.getPayeeName());
									claimTransferSettlementRequest.setType(carsDtClaimSettls.getSetType());
									claimTransferSettlementRequestList.add(claimTransferSettlementRequest);
								}

								claimTransferCoverRequest
										.setClaimTransferSettlementRequestList(claimTransferSettlementRequestList);

							}

							claimTransferCoverRequestList.add(claimTransferCoverRequest);
						}
						claimTransferPersonRequest.setClaimTransferCoverRequestList(claimTransferCoverRequestList);

					}
					claimTransferPersonRequestList.add(claimTransferPersonRequest);
				}

			}


			List<CarsDtClaimBodilyInjury> carsDtClaimBodilyInjuryList = carsDtClaimBodilyInjuryRepository
					.getCarsDtClaimBodilyInjury(insuranceId, scriptName, notification);

			if (carsDtClaimBodilyInjuryList != null) {

				for (CarsDtClaimBodilyInjury carsDtClaimBodilyInjury : carsDtClaimBodilyInjuryList) {

					ClaimTransferPersonRequest claimTransferPersonRequest = new ClaimTransferPersonRequest();

					ClaimTransferBodilyRequest claimTransferBodilyRequest = new ClaimTransferBodilyRequest();

					claimTransferPersonRequest.setSequence(carsDtClaimBodilyInjury.getDtId());
					claimTransferPersonRequest.setVehicleSequence(carsDtClaimBodilyInjury.getInjuredSeq());
					// claimTransferPersonRequest.setResponsibility(carsDtClaimBodilyInjury.getTpResp());
					if (carsDtClaimBodilyInjury.getBodilyDob() != null) {
						claimTransferBodilyRequest.setBodilyDob(stringToYear(carsDtClaimBodilyInjury.getBodilyDob()));
					}
					claimTransferBodilyRequest.setBodilyVehicleSequenceLink(carsDtClaimBodilyInjury.getVehicleSequenceLink());
					claimTransferBodilyRequest.setBodilyFirstName(carsDtClaimBodilyInjury.getBodilyFirstName());


					claimTransferBodilyRequest.setBodilyMiddleName(carsDtClaimBodilyInjury.getInjuredFather());
					claimTransferBodilyRequest.setBodilyLastName(carsDtClaimBodilyInjury.getBodilyLastName());
					claimTransferBodilyRequest.setBodilyMobileNumber(carsDtClaimBodilyInjury.getBodilyMobileNumber());
					claimTransferBodilyRequest.setBodilyType(carsDtClaimBodilyInjury.getInjuredPlace());
					List<CarsDtClaimCCovers> carsDtClaimCCoversList = carsDtClaimCCoversRepository
							.getCarsDtClaimCCovers(insuranceId, scriptName, notification,
									Integer.valueOf(carsDtClaimBodilyInjury.getInjuredSeq()));


					if (carsDtClaimCCoversList != null) {
						List<ClaimTransferCoverRequest> claimTransferCoverRequestList = new ArrayList<ClaimTransferCoverRequest>();

						for (CarsDtClaimCCovers carsDtClaimCCovers : carsDtClaimCCoversList) {

							ClaimTransferCoverRequest claimTransferCoverRequest = new ClaimTransferCoverRequest();


//
//							String sequence = "";
//							String[] splitCoverCode = carsDtClaimCCovers.getCoverCode().split("\\.", 2);
//							if (!Utility.isEmpty(claimTransferRequest.getClaimTransferNotification())) {
//								sequence = claimTransferRequest.getClaimTransferNotification();
//							}
//							if (!Utility.isEmpty((splitCoverCode[0]))) {
//								sequence = sequence + "-" + splitCoverCode[0];
//								claimTransferCoverRequest.setCoverCode(splitCoverCode[0]);
//							}
//							if (splitCoverCode.length > 1) {
//								if (!Utility.isEmpty(splitCoverCode[1])) {
//									sequence = sequence + "-" + splitCoverCode[1];
//									claimTransferCoverRequest.setSubcoverCode(splitCoverCode[1]);
//								}
//							}
//							if (!Utility.isEmpty(carsDtClaimCCovers.getSetType())) {
//								sequence = sequence + "-" + carsDtClaimCCovers.getSetType();
//							}
//							claimTransferCoverRequest.setSequence(sequence);


							String sequence = "";

							String profileCode = "";
							if (carsDtClaimCCovers.getPayeeProfileCode() != null) {
								profileCode = carsDtClaimCCovers.getPayeeProfileCode();
							} else {
								profileCode = "PERSON";
							}

							String profileType = "";
							if (carsDtClaimCCovers.getPayeeProfileType() != null) {
								profileType = carsDtClaimCCovers.getPayeeProfileType();
							} else {
								profileType = "PERSON";
							}

							String[] splitCoverCode = carsDtClaimCCovers.getCoverCode().split("\\.", 2);
							if (!Utility.isEmpty(claimTransferRequest.getClaimTransferNotification())) {
								sequence = claimTransferRequest.getClaimTransferNotification();
							}

							if (!Utility.isEmpty(carsDtClaimBodilyInjury.getInjuredSeq()) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + carsDtClaimBodilyInjury.getInjuredSeq();
							} else {
								sequence = carsDtClaimBodilyInjury.getInjuredSeq();

							}


							if (!Utility.isEmpty((splitCoverCode[0])) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + splitCoverCode[0];
								claimTransferCoverRequest.setCoverCode(splitCoverCode[0]);
							} else {
								sequence = splitCoverCode[0];
								claimTransferCoverRequest.setCoverCode(splitCoverCode[0]);
							}


							if (splitCoverCode.length > 1) {
								if (!Utility.isEmpty(splitCoverCode[1])) {
									sequence = sequence + "-" + splitCoverCode[1];
									claimTransferCoverRequest.setSubcoverCode(splitCoverCode[1]);
								}
							}

							if (!Utility.isEmpty(carsDtClaimCCovers.getPayeeAssessmentType()) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + carsDtClaimCCovers.getPayeeAssessmentType();
							} else {
								sequence = carsDtClaimCCovers.getPayeeAssessmentType();

							}


							if (!Utility.isEmpty(profileType) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + profileType;
							} else {
								sequence = profileType;

							}

							if (!Utility.isEmpty(profileCode) && !Utility.isEmpty(sequence)) {

								sequence = sequence + "-" + profileCode;
							} else {
								sequence = profileCode;

							}


							if (!Utility.isEmpty(carsDtClaimCCovers.getCurrency())) {
								sequence = sequence + "-" + carsDtClaimCCovers.getCurrency();
							}


							claimTransferCoverRequest.setSequence(sequence);


							claimTransferCoverRequest.setRiskType(carsDtClaimCCovers.getSetType());

							if (carsDtClaimCCovers.getPayeeProfileType() != null) {
								claimTransferCoverRequest.setProfileType(carsDtClaimCCovers.getPayeeProfileType());

							} else {
								claimTransferCoverRequest.setProfileType("");

							}


							if (carsDtClaimCCovers.getPayeeProfileCode() != null) {
								claimTransferCoverRequest.setProfileCode(carsDtClaimCCovers.getPayeeProfileCode());

							} else {
								claimTransferCoverRequest.setProfileCode("");

							}

							claimTransferCoverRequest.setAssessmentType(carsDtClaimCCovers.getPayeeAssessmentType());

							claimTransferCoverRequest.setReserveAmount(carsDtClaimCCovers.getReserveAmount());
							claimTransferCoverRequest
									.setRecoveryReserveAmount(carsDtClaimCCovers.getRecoveryReserveAmount());
							claimTransferCoverRequest.setReserveCurrency(carsDtClaimCCovers.getCurrency());
							List<ClaimTransferSettlementRequest> claimTransferSettlementRequestList = new ArrayList<ClaimTransferSettlementRequest>();
							List<CarsDtClaimSettls> carsDtClaimSettlsList = null;

							String transaction ="1";
							if(carsDtClaimCCovers.getRecoveryReserveAmount()!=null&&carsDtClaimCCovers.getReserveAmount()!=null){

								if(Double.parseDouble(carsDtClaimCCovers.getRecoveryReserveAmount())>0){
									transaction="2";
								}
								if(Double.parseDouble(carsDtClaimCCovers.getReserveAmount())>0){
									transaction="1";
								}

							}


							if (Utility.isEmpty(carsDtClaimCCovers.getPayeeProfileCode())) {
								carsDtClaimSettlsList = carsDtClaimSettlsRepository
										.getCarsDtClaimSettlsNullPayeeCode(insuranceId, scriptName, notification,
												carsDtClaimCCovers.getCoverCode(), carsDtClaimCCovers.getSetType(), carsDtClaimCCovers.getNotificationSeq(),carsDtClaimCCovers.getCurrency(),transaction);
							} else {
								carsDtClaimSettlsList = carsDtClaimSettlsRepository
										.getCarsDtClaimSettls(insuranceId, scriptName, notification,
												carsDtClaimCCovers.getCoverCode(), carsDtClaimCCovers.getSetType(), carsDtClaimCCovers.getNotificationSeq(), carsDtClaimCCovers.getPayeeProfileCode(),carsDtClaimCCovers.getCurrency(),transaction);
							}

							if (carsDtClaimSettlsList != null) {

								for (CarsDtClaimSettls carsDtClaimSettls : carsDtClaimSettlsList) {

									ClaimTransferSettlementRequest claimTransferSettlementRequest = new ClaimTransferSettlementRequest();
									claimTransferSettlementRequest.setTransaction(carsDtClaimSettls.getTransaction());
									claimTransferSettlementRequest
											.setPaymentSequence(carsDtClaimSettls.getPaymentSequence());
									claimTransferSettlementRequest.setCurrency(carsDtClaimSettls.getCurrency());
									claimTransferSettlementRequest.setPaidAmount(carsDtClaimSettls.getPaidAmount());
									if (carsDtClaimSettls.getPaymentDate() != null) {
										claimTransferSettlementRequest
												.setPaymentDate(stringToYear(carsDtClaimSettls.getPaymentDate()));
									}
									// claimTransferSettlementRequest.setPayeeType(item4.getPayeeType());

									if (carsDtClaimSettls.getPayeeTypeCode() != null) {
										claimTransferSettlementRequest
												.setPayeeTypeCode(carsDtClaimSettls.getPayeeTypeCode());
									} else {
										claimTransferSettlementRequest
												.setPayeeTypeCode("");
									}

									claimTransferSettlementRequest
											.setPayeeTypeDescription(carsDtClaimSettls.getPayeeTypeDescription());
									if (carsDtClaimSettls.getPaymentDate() != null) {
										claimTransferSettlementRequest
												.setPaymentDate(stringToYear(carsDtClaimSettls.getPaymentDate()));
									}

									if (carsDtClaimSettls.getPayeeCode() != null) {
										claimTransferSettlementRequest.setPayeeCode(carsDtClaimSettls.getPayeeCode());

									} else {
										claimTransferSettlementRequest.setPayeeCode("");

									}

									claimTransferSettlementRequest.setPayeeName(carsDtClaimSettls.getPayeeName());
									claimTransferSettlementRequest.setType(carsDtClaimSettls.getSetType());
									// claimTransferSettlementRequest.setRiskType(item4.getRiskType());
									claimTransferSettlementRequestList.add(claimTransferSettlementRequest);
								}

								claimTransferCoverRequest
										.setClaimTransferSettlementRequestList(claimTransferSettlementRequestList);

							}

							claimTransferCoverRequestList.add(claimTransferCoverRequest);
						}
						claimTransferPersonRequest.setClaimTransferBodilyRequest(claimTransferBodilyRequest);
						claimTransferPersonRequest.setClaimTransferCoverRequestList(claimTransferCoverRequestList);

					}

					claimTransferPersonRequestList.add(claimTransferPersonRequest);
				}
			}


			List<CarsDtClaimMaterialDamage> carsDtClaimMaterialDamageList = carsDtClaimMaterialDamageRepository
					.getCarsDtClaimMaterialDamage(insuranceId, scriptName, notification);
			if (carsDtClaimMaterialDamageList != null) {
				for (CarsDtClaimMaterialDamage carsDtClaimMaterialDamage : carsDtClaimMaterialDamageList) {

					ClaimTransferPersonRequest claimTransferPersonRequest = new ClaimTransferPersonRequest();

					ClaimTransferMaterialRequest claimTransferMaterialRequest = new ClaimTransferMaterialRequest();
					claimTransferPersonRequest.setSequence(carsDtClaimMaterialDamage.getDtId());


					claimTransferPersonRequest
							.setVehicleSequence(carsDtClaimMaterialDamage.getMaterialDamageSequence());
					claimTransferMaterialRequest
							.setMaterialFullName(carsDtClaimMaterialDamage.getMaterialDamageOwnerName());
					claimTransferMaterialRequest
							.setMaterialMobileNumber(carsDtClaimMaterialDamage.getMaterialDamageOwnerPhone());

					claimTransferMaterialRequest.setMatSequenceLink(carsDtClaimMaterialDamage.getMaterialDamageSequenceLink());

					claimTransferMaterialRequest
							.setMaterialDescription(carsDtClaimMaterialDamage.getMaterialDamageMaterialTypeDesc());
					claimTransferPersonRequest.setClaimTransferMaterialRequest(claimTransferMaterialRequest);

					List<CarsDtClaimCCovers> carsDtClaimCCoversList = carsDtClaimCCoversRepository
							.getCarsDtClaimCCovers(insuranceId, scriptName, notification,
									Integer.valueOf(carsDtClaimMaterialDamage.getMaterialDamageSequence()));

					if (carsDtClaimCCoversList != null) {
						List<ClaimTransferCoverRequest> claimTransferCoverRequestList = new ArrayList<ClaimTransferCoverRequest>();

						for (CarsDtClaimCCovers carsDtClaimCCovers : carsDtClaimCCoversList) {

							ClaimTransferCoverRequest claimTransferCoverRequest = new ClaimTransferCoverRequest();


							String sequence = "";

							String profileCode = "";
							if (carsDtClaimCCovers.getPayeeProfileCode() != null) {
								profileCode = carsDtClaimCCovers.getPayeeProfileCode();
							} else {
								profileCode = "PERSON";
							}

							String profileType = "";
							if (carsDtClaimCCovers.getPayeeProfileType() != null) {
								profileType = carsDtClaimCCovers.getPayeeProfileType();
							} else {
								profileType = "PERSON";
							}

							String[] splitCoverCode = carsDtClaimCCovers.getCoverCode().split("\\.", 2);
							if (!Utility.isEmpty(claimTransferRequest.getClaimTransferNotification())) {
								sequence = claimTransferRequest.getClaimTransferNotification();
							}

							if (!Utility.isEmpty(carsDtClaimMaterialDamage.getMaterialDamageSequence()) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + carsDtClaimMaterialDamage.getMaterialDamageSequence();
							} else {
								sequence = carsDtClaimMaterialDamage.getMaterialDamageSequence();

							}


							if (!Utility.isEmpty((splitCoverCode[0])) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + splitCoverCode[0];
								claimTransferCoverRequest.setCoverCode(splitCoverCode[0]);
							} else {
								sequence = splitCoverCode[0];
								claimTransferCoverRequest.setCoverCode(splitCoverCode[0]);
							}


							if (splitCoverCode.length > 1) {
								if (!Utility.isEmpty(splitCoverCode[1])) {
									sequence = sequence + "-" + splitCoverCode[1];
									claimTransferCoverRequest.setSubcoverCode(splitCoverCode[1]);
								}
							}

							if (!Utility.isEmpty(carsDtClaimCCovers.getPayeeAssessmentType()) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + carsDtClaimCCovers.getPayeeAssessmentType();
							} else {
								sequence = carsDtClaimCCovers.getPayeeAssessmentType();

							}


							if (!Utility.isEmpty(profileType) && !Utility.isEmpty(sequence)) {
								sequence = sequence + "-" + profileType;
							} else {
								sequence = profileType;

							}

							if (!Utility.isEmpty(profileCode) && !Utility.isEmpty(sequence)) {

								sequence = sequence + "-" + profileCode;
							} else {
								sequence = profileCode;

							}


							if (!Utility.isEmpty(carsDtClaimCCovers.getCurrency())) {
								sequence = sequence + "-" + carsDtClaimCCovers.getCurrency();
							}


							claimTransferCoverRequest.setSequence(sequence);


//							String sequence = "";
//							String[] splitCoverCode = carsDtClaimCCovers.getCoverCode().split("\\.", 2);
//							if (!Utility.isEmpty(claimTransferRequest.getClaimTransferNotification())) {
//								sequence = claimTransferRequest.getClaimTransferNotification();
//							}
//							if (!Utility.isEmpty((splitCoverCode[0]))) {
//								sequence = sequence + "-" + splitCoverCode[0];
//								claimTransferCoverRequest.setCoverCode(splitCoverCode[0]);
//							}
//							if (splitCoverCode.length > 1) {
//								if (!Utility.isEmpty(splitCoverCode[1])) {
//									sequence = sequence + "-" + splitCoverCode[1];
//									claimTransferCoverRequest.setSubcoverCode(splitCoverCode[1]);
//								}
//							}
//							if (!Utility.isEmpty(carsDtClaimCCovers.getSetType())) {
//								sequence = sequence + "-" + carsDtClaimCCovers.getSetType();
//							}
//
//							//todo
//							claimTransferCoverRequest.setSequence(sequence);


							claimTransferCoverRequest.setRiskType(carsDtClaimCCovers.getSetType());
							claimTransferCoverRequest.setAssessmentType(carsDtClaimCCovers.getPayeeAssessmentType());
							claimTransferCoverRequest.setReserveCurrency(carsDtClaimCCovers.getCurrency());

							if (carsDtClaimCCovers.getPayeeProfileType() != null) {
								claimTransferCoverRequest.setProfileType(carsDtClaimCCovers.getPayeeProfileType());

							} else {
								claimTransferCoverRequest.setProfileType("");

							}


							if (carsDtClaimCCovers.getPayeeProfileCode() != null) {
								claimTransferCoverRequest.setProfileCode(carsDtClaimCCovers.getPayeeProfileCode());

							} else {
								claimTransferCoverRequest.setProfileCode("");

							}


							claimTransferCoverRequest.setReserveAmount(carsDtClaimCCovers.getReserveAmount());
							claimTransferCoverRequest
									.setRecoveryReserveAmount(carsDtClaimCCovers.getRecoveryReserveAmount());

							List<ClaimTransferSettlementRequest> claimTransferSettlementRequestList = new ArrayList<ClaimTransferSettlementRequest>();
							List<CarsDtClaimSettls> carsDtClaimSettlsList = null;
							String transaction ="1";
							if(carsDtClaimCCovers.getRecoveryReserveAmount()!=null&&carsDtClaimCCovers.getReserveAmount()!=null){

								if(Double.parseDouble(carsDtClaimCCovers.getRecoveryReserveAmount())>0){
									transaction="2";
								}
								if(Double.parseDouble(carsDtClaimCCovers.getReserveAmount())>0){
									transaction="1";
								}

							}
							if (Utility.isEmpty(carsDtClaimCCovers.getPayeeProfileCode())) {
								carsDtClaimSettlsList = carsDtClaimSettlsRepository
										.getCarsDtClaimSettlsNullPayeeCode(insuranceId, scriptName, notification,
												carsDtClaimCCovers.getCoverCode(), carsDtClaimCCovers.getSetType(), carsDtClaimCCovers.getNotificationSeq(),carsDtClaimCCovers.getCurrency(),transaction);
							} else {
								carsDtClaimSettlsList = carsDtClaimSettlsRepository
										.getCarsDtClaimSettls(insuranceId, scriptName, notification,
												carsDtClaimCCovers.getCoverCode(), carsDtClaimCCovers.getSetType(), carsDtClaimCCovers.getNotificationSeq(), carsDtClaimCCovers.getPayeeProfileCode(),carsDtClaimCCovers.getCurrency(),transaction);
							}
							if (carsDtClaimSettlsList != null) {

								for (CarsDtClaimSettls carsDtClaimSettls : carsDtClaimSettlsList) {

									ClaimTransferSettlementRequest claimTransferSettlementRequest = new ClaimTransferSettlementRequest();
									claimTransferSettlementRequest.setTransaction(carsDtClaimSettls.getTransaction());
									claimTransferSettlementRequest
											.setPaymentSequence(carsDtClaimSettls.getPaymentSequence());
									claimTransferSettlementRequest.setCurrency(carsDtClaimSettls.getCurrency());
									claimTransferSettlementRequest.setPaidAmount(carsDtClaimSettls.getPaidAmount());
									if (carsDtClaimSettls.getPaymentDate() != null) {
										claimTransferSettlementRequest
												.setPaymentDate(stringToYear(carsDtClaimSettls.getPaymentDate()));
									}
									// claimTransferSettlementRequest.setPayeeType(item4.getPayeeType());

									if (carsDtClaimSettls.getPayeeTypeCode() != null) {
										claimTransferSettlementRequest
												.setPayeeTypeCode(carsDtClaimSettls.getPayeeTypeCode());
									} else {
										claimTransferSettlementRequest
												.setPayeeTypeCode("");
									}


									claimTransferSettlementRequest
											.setPayeeTypeDescription(carsDtClaimSettls.getPayeeTypeDescription());
									if (carsDtClaimSettls.getPayeeCode() != null) {
										claimTransferSettlementRequest.setPayeeCode(carsDtClaimSettls.getPayeeCode());

									} else {
										claimTransferSettlementRequest.setPayeeCode("");

									}
									claimTransferSettlementRequest.setPayeeName(carsDtClaimSettls.getPayeeName());
									claimTransferSettlementRequest.setType(carsDtClaimSettls.getSetType());
									// claimTransferSettlementRequest.setRiskType(item4.getRiskType());
									claimTransferSettlementRequestList.add(claimTransferSettlementRequest);
								}

								claimTransferCoverRequest
										.setClaimTransferSettlementRequestList(claimTransferSettlementRequestList);

							}

							claimTransferCoverRequestList.add(claimTransferCoverRequest);
						}
						claimTransferPersonRequest.setClaimTransferMaterialRequest(claimTransferMaterialRequest);
						claimTransferPersonRequest.setClaimTransferCoverRequestList(claimTransferCoverRequestList);

					}

					claimTransferPersonRequestList.add(claimTransferPersonRequest);
				}

			}

			claimTransferRequest.setClaimTransferPersonRequestList(claimTransferPersonRequestList);
			claimTransferRequestList.add(claimTransferRequest);
		}
		ClaimTransferRequest claimTransferRequest = new ClaimTransferRequest();
		if (claimTransferRequestList.size() > 0) {
			claimTransferRequest = claimTransferRequestList.get(0);

		}

		// List<ClaimTransferRequest> list =
		// carsDtClaimCRepository.getCarsDtClaimC().stream().map(item ->{

		// List<ClaimTransferPersonRequest> list1 = new
		// ArrayList<ClaimTransferPersonRequest>();
//		
//		list1= carsDtClaimPersonRepository.getCarsDtClaimPerson().stream().map(item2 ->{
//			
//			ClaimTransferPersonRequest claimTransferPersonRequest = new ClaimTransferPersonRequest();
//			claimTransferPersonRequest.setSequence(item2.getDtId());
//			claimTransferPersonRequest.setVehicleSequence(item2.getVehSeq());
//			claimTransferPersonRequest.setResponsibility(item2.getTpResp());
//			
//			//-----
//			ClaimTransferVehicleRequest claimTransferVehicleRequest = new ClaimTransferVehicleRequest();
//			claimTransferVehicleRequest.setOwnerFamilyName(item2.getOwnerFamilyName());
//			claimTransferVehicleRequest.setOwnerFirstName(item2.getOwnerFirstName());
//			claimTransferVehicleRequest.setDriverFirstName(item2.getDriverFisrtName());
//			claimTransferVehicleRequest.setDriverFamilyName(item2.getDriverFamilyName());
//			claimTransferVehicleRequest.setDriverPhone(item2.getDriverPhone());
//			claimTransferVehicleRequest.setDriverGender(item2.getGender());
//			claimTransferVehicleRequest.setDriverDob(stringToYear(item2.getDob()));
//			claimTransferVehicleRequest.setMakeCode(item2.getMakeCode());
//			claimTransferVehicleRequest.setModelCode(item2.getModelCode());
//			claimTransferVehicleRequest.setVehicleYear(item2.getVehicleYear());
//			claimTransferVehicleRequest.setPlatePrefix(item2.getPlatePrefix());
//			claimTransferVehicleRequest.setPlateNumber(item2.getPlateNumber());
//			claimTransferVehicleRequest.setTpCompanyCode(item2.getTpCompanyId());
//			claimTransferVehicleRequest.setTpCompanyName(item2.getTpCompanyName());
//			//claimTransferVehicleRequest.setTpPolicyNumber(item2.getPolicyNumber);
//			//claimTransferVehicleRequest.setPolEffective(item2.getPolEffective);
//			//claimTransferVehicleRequest.setPolExpiry(item2.getPolExpiry);
//			claimTransferPersonRequest.setClaimTransferVehicleRequest(claimTransferVehicleRequest);
//			//-------
//			ClaimTransferBodilyRequest claimTransferBodilyRequest = new ClaimTransferBodilyRequest();
//			
//			CarsDtClaimBodilyInjury  carsDtClaimBodilyInjury = new CarsDtClaimBodilyInjury();
//			
//			carsDtClaimBodilyInjury = carsDtClaimBodilyInjuryRepository.getCarsDtClaimBodilyInjury();
//			try {
//				if(claimTransferBodilyRequest != null) {
//				BeanUtils.copyProperties(claimTransferBodilyRequest, carsDtClaimBodilyInjury);	
//				claimTransferPersonRequest.setClaimTransferBodilyRequest(claimTransferBodilyRequest);
//				}
//			} catch (IllegalAccessException | InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		// ------
//			ClaimTransferMaterialRequest claimTransferMaterialRequest = new ClaimTransferMaterialRequest();
//    		
//	    	CarsDtClaimMaterialDamage carsDtClaimMaterialDamage= new CarsDtClaimMaterialDamage();
//	    	
//	    	carsDtClaimMaterialDamage = carsDtClaimMaterialDamageRepository.getCarsDtClaimMaterialDamage();
//	    		
//	    		if(carsDtClaimMaterialDamage !=null ) {
//	    			claimTransferMaterialRequest.setMaterialFullName(carsDtClaimMaterialDamage.getMaterialDamageOwnerName());
//	    			claimTransferMaterialRequest.setMaterialMobileNumber(carsDtClaimMaterialDamage.getMaterialDamageOwnerPhone());
//	    			claimTransferMaterialRequest.setMaterialDescription(carsDtClaimMaterialDamage.getMaterialDamageMaterialTypeDesc());
//	    			claimTransferPersonRequest.setClaimTransferMaterialRequest(claimTransferMaterialRequest);
//	    		}
//	    		
//			if(carsDtClaimBodilyInjury != null ) {
//      			 claimTransferBodilyRequest.setBodilyFirstName(carsDtClaimBodilyInjury.getBodilyFirstName());
//      			 claimTransferBodilyRequest.setBodilyDob(stringToYear(carsDtClaimBodilyInjury.getBodilyDob()));
//      			 claimTransferBodilyRequest.setBodilyLastName(carsDtClaimBodilyInjury.getBodilyLastName());
//      			 claimTransferBodilyRequest.setBodilyMobileNumber(carsDtClaimBodilyInjury.getBodilyMobileNumber());
//      			 claimTransferPersonRequest.setClaimTransferBodilyRequest(claimTransferBodilyRequest);
//      		 }
//			
//			List<ClaimTransferCoverRequest> list2 = new ArrayList<ClaimTransferCoverRequest>();
//			list2= carsDtClaimCCoversRepository.getCarsDtClaimCCovers().stream().map(item3 ->{
//				ClaimTransferCoverRequest claimTransferCoverRequest= new ClaimTransferCoverRequest();
//				claimTransferCoverRequest.setSequence(item3.getSequence());
//				claimTransferCoverRequest.setCoverCode(item3.getCoverCode());
//				claimTransferCoverRequest.setReserveAmount(item3.getReserveAmount());
//				claimTransferCoverRequest.setRecoveryReserveAmount(item3.getRecoveryReserveAmount());
//				
//				List<ClaimTransferSettlementRequest> list3 = new ArrayList<ClaimTransferSettlementRequest>();
//				list3= carsDtClaimSettlsRepository.getCarsDtClaimSettls(item3.getCoverCode()).stream().map(item4 ->{
//					ClaimTransferSettlementRequest claimTransferSettlementRequest = new ClaimTransferSettlementRequest();
//					claimTransferSettlementRequest.setTransaction(item4.getTransaction());
//					claimTransferSettlementRequest.setSequence(item4.getSequence());
//					claimTransferSettlementRequest.setCurrency(item4.getCurrency());
//					claimTransferSettlementRequest.setPaidAmount(item4.getPaidAmount());
//					claimTransferSettlementRequest.setPaymentDate(stringToYear(item4.getPaymentDate()));
//					claimTransferSettlementRequest.setPayeeType(item4.getPayeeType());
//					claimTransferSettlementRequest.setPayeeCode(item4.getPayeeCode());
//					claimTransferSettlementRequest.setPayeeName(item4.getPayeeName());
//					claimTransferSettlementRequest.setType(item4.getSetType());
//					claimTransferSettlementRequest.setRiskType(item4.getRiskType());
//					return claimTransferSettlementRequest;
//    			}).collect(Collectors.toList());
//				
//				claimTransferCoverRequest.setClaimTransferSettlementRequestList(list3);
//				return claimTransferCoverRequest;
//			}).collect(Collectors.toList());
//			claimTransferPersonRequest.setClaimTransferCoverRequestList(list2);
//			
//			
//			return claimTransferPersonRequest;
//		}).collect(Collectors.toList());
//		
//		claimTransferRequest1.setClaimTransferPersonRequestList(list1);
//		
//		return claimTransferRequest1;
//		}).collect(Collectors.toList());
		System.out.println(claimTransferRequest);


		ClaimsResponseTemplate claimsResponseTemplate = sendData(claimTransferRequest, notification, insuranceId, scriptName);
		claimsResponse.setClaimNO(claimsResponseTemplate.getClaimNo());
		claimsResponse.setResponseDesc(claimsResponseTemplate.getResponseDesc());
		claimsResponse.setClaims(claimTransferRequest);
		claimsResponse.setResponseMessage(claimsResponseTemplate.getResponseMessage());

		return new ResponseEntity<ClaimsResponse>(claimsResponse, HttpStatus.OK);
		// }catch (Exception e) {
		// throw new Exception (e.toString());
		// }
	}
return null;
}
	public String stringToYear(String s) {
		try {

			Date d = new SimpleDateFormat("yyyy/MM/dd").parse(s);
			// Date d = new SimpleDateFormat("dd/MM/yyyy").parse(s);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public String changeFormat(String s) {
		try {

			Date d = new SimpleDateFormat("dd-MMM-yy").parse(s);
			// Date d = new SimpleDateFormat("dd/MM/yyyy").parse(s);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




	public String changeFormatForScript(String s) {
		try {

			Date d = new SimpleDateFormat("dd-MMM-yyyy").parse(s);
			// Date d = new SimpleDateFormat("dd/MM/yyyy").parse(s);
			SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
			return formatter.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public String stringToYear1(String s) {
		try {

			Date d = new SimpleDateFormat("dd-MMM-yyyy").parse(s);
			// Date d = new SimpleDateFormat("DD-MMM-YYYY").parse(s);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			return formatter.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
public boolean TestApi(String companyId,String script,String notfication,String companyName) throws Exception {
	ClaimsResponseTemplate response = new ClaimsResponseTemplate();
	RestTemplate restTemplate = new RestTemplate();
	boolean valid = true;
	baseUrl = carsDtClaimCRepository.findConfigByKey(companyId + ".claim.integration.url");
	System.out.println(" my base url is" + baseUrl);
	URI uri = new URI(baseUrl);
	try {

		ResponseEntity<ClaimsResponseTemplate> result = restTemplate.postForEntity(uri, new ClaimTransferRequest(), ClaimsResponseTemplate.class);
		if (result.getStatusCodeValue() == Response.SC_OK) {
			System.out.println("ok");
		} else {
			System.out.println("not ok");

		}

	} catch (Exception exception) {
		valid = false;
		System.out.println("/// api not found");
		System.out.println(exception.toString());
		String body = "";
		body = exception.getMessage();

		body = body + "\n";
		String value = carsDtClaimCRepository.findConfigByKey(companyId + ".send.JSON.claim");
		writeLogs(notfication, script, companyId, new Date(), new Date(), "anonymous", 0L, "anonymous", exception.getMessage(), exception.getMessage());

		if (value != null) {
			if (value.equals("true")) {
				SendingMail sendingMail = new SendingMail();
				sendingMail.run(  companyName+ script+ " " +notfication+ " api not found", body, companyId);

			}
		}
	}
	return valid;

}

	public ClaimsResponseTemplate sendData(ClaimTransferRequest claimTransferRequest,String notification ,String companyId,String scriptName) throws Exception {
		ClaimsResponseTemplate response = new ClaimsResponseTemplate();
		RestTemplate restTemplate = new RestTemplate();

		 baseUrl=carsDtClaimCRepository.findConfigByKey(companyId+".claim.integration.url");
		System.out.println(" my base url is"+baseUrl);
		URI uri = new URI(baseUrl);


try {
	ResponseEntity<ClaimsResponseTemplate> result = restTemplate.postForEntity(uri, claimTransferRequest, ClaimsResponseTemplate.class);

	System.out.println(result.getBody().getResponseMessage());
	//if(result.getBody().getClaimNo())
	String		 value2=carsDtClaimCRepository.findConfigByKey(companyId+".send.JSON.claim.any");

	if(result.getStatusCodeValue()==Response.SC_OK){
		response=result.getBody();
		if(result.getBody().getResponseCode()==1){
			if(value2!=null){
				if(value2.equals("true")){
					String body="";
						if(response.getResponseMessage()!=null){
							body=response.getResponseMessage();

						}
						if(response.getResponseDesc()!=null){
							body=body+" \n "+response.getResponseDesc();

						}

					ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
					String json = ow.writeValueAsString(claimTransferRequest);
					body=body+"\n"+ json;
					SendingMail sendingMail = new SendingMail();
					sendingMail.run(companyName+" "+ claimTransferRequest.getClaimTransferId(),body,companyId);

				}
			}
			updateInsClaimNumber(companyId,notification,result.getBody().getClaimNo(),null,null,null,null);

		}
		else {
			String body="";
				if(response.getResponseMessage()!=null){
					body=response.getResponseMessage();

				}
				if(response.getResponseDesc()!=null){
					body=body+" \n  "+response.getResponseDesc();

				}

			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(claimTransferRequest);
			body=body+"\n"+ json;
			writeLogs(notification,scriptName,companyId, new Date(),new Date(),"anonymous",0L,"anonymous",response.getResponseMessage(),response.getResponseDesc());
			SendingMail sendingMail = new SendingMail();

			String		 value=carsDtClaimCRepository.findConfigByKey(companyId+".send.JSON.claim");
			System.out.println("my value"+value);
			if(value!=null){
				if(value.equals("true"))
				sendingMail.run(companyName+" "+ claimTransferRequest.getClaimTransferId(),body,companyId);

			}
		}

	}else{
		String		 value=carsDtClaimCRepository.findConfigByKey(companyId+".send.JSON.claim");

		String body="";
		body=result.getBody().toString();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(claimTransferRequest);
		body=body+"\n"+ json;
		System.out.println("Response Code not ok");
		writeLogs(notification,scriptName,companyId, new Date(),new Date(),"anonymous",0L,"anonymous",response.getResponseMessage(),response.getResponseDesc());

		if(value!=null){
			if(value.equals("true")){
				SendingMail sendingMail = new SendingMail();
				sendingMail.run(companyName+" "+ claimTransferRequest.getClaimTransferId(),body,companyId);

			}
		}
	}
}
catch (Exception exception){
	System.out.println(exception.toString());
	String body="";
	body=exception.getMessage();
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	String json = ow.writeValueAsString(claimTransferRequest);
	body=body+"\n"+ json;
	System.out.println("Response Code not ok");
	String		 value=carsDtClaimCRepository.findConfigByKey(companyId+".send.JSON.claim");
	writeLogs(notification,scriptName,companyId, new Date(),new Date(),"anonymous",0L,"anonymous",exception.getMessage(),exception.getMessage());

	if(value!=null){
		if(value.equals("true")){
			SendingMail sendingMail = new SendingMail();
			sendingMail.run(companyName+" "+ claimTransferRequest.getClaimTransferId(),body,companyId);

		}
	}
	System.out.println("testttttttttttttt");
}

//
//Assertions.assertEquals(201, result.getStatusCodeValue());
//		Assertions.assertNotNull(result.getBody().getId());
return  response;
	}


	public String updateInsClaimNumber(String company, String notification,String claimsNumber, String branch,String product,String year ,String serial) {
		System.out.println("claimsNo"+claimsNumber);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withFunctionName("FC_UPDATE_INS_CLAIM_NUMBER")
				.declareParameters(new SqlParameter("u_id", Types.BIGINT));

		String out = simpleJdbcCall.executeFunction(String.class,

				new MapSqlParameterSource("I_COMPANY", company)

						.addValue("I_NOTIFICATION",notification)
						.addValue("I_INS_CLAIM_NUMBER",claimsNumber)
						.addValue("I_BRANCH",branch)
						.addValue("I_PRODUCT",product)
						.addValue("I_YEAR",year)
						.addValue("I_SERIAL",serial)

		);
		System.out.println(out);
		return  out;


	}


	public ResponseEntity<ClaimsListResponse> generateClaimsSurveyList(List<ClaimsRequest> claimsRequestList) {
		ClaimsListResponse claimsListResponse = new ClaimsListResponse();
		List<ClaimsResponseCustom> claimsResponseCustomList= new ArrayList<>();
		if (claimsRequestList.size()<=50){
			claimsRequestList.forEach(claimsRequest -> {
				try {

					ClaimsResponse claimsResponse  = generateClaimsSurvey(claimsRequest.getNotification(),claimsRequest.getInsuranceId(),claimsRequest.getFromDate(),claimsRequest.getBatch(),claimsRequest.getToDate(),claimsRequest.getFunctionName()).getBody();
					ClaimsResponseCustom claimsResponseCustom= new ClaimsResponseCustom();
					claimsResponseCustom.setClaimNO(claimsResponse.getClaimNO());
					claimsResponseCustom.setResponseDesc(claimsResponse.getResponseDesc());
					claimsResponseCustom.setClaimTransferNotification(claimsResponse.getClaims().getClaimTransferNotification());
					claimsResponseCustom.setClaimTransferId(claimsResponse.getClaims().getClaimTransferId());
					claimsResponseCustomList.add(claimsResponseCustom);

				} catch (Exception e) {
					e.printStackTrace();

				}

			});
			claimsListResponse.setClaimsResponseList(claimsResponseCustomList);
			claimsListResponse.setMessage("success");
			return 	new ResponseEntity<ClaimsListResponse>(claimsListResponse, HttpStatus.OK);

		}else{
			claimsListResponse.setMessage("your claims must below 50");
			return 	new ResponseEntity<ClaimsListResponse>(claimsListResponse, HttpStatus.FAILED_DEPENDENCY);

		}
	}




	public void writeLogs(
			String notification,
			String scriptName,
			String insId,
			Date sysUpdatedDate,
			Date sysCreatedDate,
			String sysUpdatedBy,
			Long sysVersionNumber,
			String sysCreatedBy,
			String carsDtClaimsRespMsg,
			String carsDtClaimsRespDesc
	) {
		// Create an entity and set the provided data
		CarsDtClaimsLogsEntity entity = new CarsDtClaimsLogsEntity();
		entity.setNotification(notification);
		entity.setScriptName(scriptName);
		entity.setInsId(insId);
		entity.setSysUpdatedDate(sysUpdatedDate);
		entity.setSysCreatedDate(sysCreatedDate);
		entity.setSysUpdatedBy(sysUpdatedBy);
		entity.setSysVersionNumber(sysVersionNumber);
		entity.setSysCreatedBy(sysCreatedBy);
		entity.setCarsDtClaimsRespMsg(carsDtClaimsRespMsg);
		entity.setCarsDtClaimsRespDesc(carsDtClaimsRespDesc);

		// Save the entity to the database
		carsDtClaimsLogsRepository.save(entity);
	}





}
