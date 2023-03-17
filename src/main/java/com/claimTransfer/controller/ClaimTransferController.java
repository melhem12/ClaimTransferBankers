package com.claimTransfer.controller;

import java.util.stream.Collectors;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.lang.reflect.InvocationTargetException;
import java.util.*;

//import org.apache.commons.beanutils.BeanUtils;
import com.claimTransfer.request.*;
import com.claimTransfer.response.ClaimsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claimTransfer.repository.CarsDtClaimBodilyInjuryRepository;
import com.claimTransfer.repository.CarsDtClaimCCoversRepository;
import com.claimTransfer.repository.CarsDtClaimCRepository;
import com.claimTransfer.repository.CarsDtClaimMaterialDamageRepository;
import com.claimTransfer.repository.CarsDtClaimPersonRepository;
import com.claimTransfer.repository.CarsDtClaimSettlsRepository;
import com.claimTransfer.model.CarsDtClaimBodilyInjury;
import com.claimTransfer.model.CarsDtClaimC;
import com.claimTransfer.model.CarsDtClaimCCovers;
import com.claimTransfer.model.CarsDtClaimMaterialDamage;
import com.claimTransfer.model.CarsDtClaimSettls;
import com.claimTransfer.response.CarsDtClaimPersonResponse;
import com.claimTransfer.service.ClaimTransferService;

@RestController
@RequestMapping("/api/timer")
public class ClaimTransferController {

	@Autowired
	ClaimTransferService claimTransferService;

	@Autowired
	CarsDtClaimCRepository carsDtClaimCRepository;

	@Autowired
	CarsDtClaimPersonRepository carsDtClaimPersonRepository;

	@Autowired
	CarsDtClaimBodilyInjuryRepository carsDtClaimBodilyInjuryRepository;

	@Autowired
	CarsDtClaimMaterialDamageRepository carsDtClaimMaterialDamageRepository;

	@Autowired
	CarsDtClaimCCoversRepository carsDtClaimCCoversRepository;

	@Autowired
	CarsDtClaimSettlsRepository carsDtClaimSettlsRepository;

//	@GetMapping("/claims")
//	public ResponseEntity<List<ClaimTransferRequest>> generateClaimsSurvey(
//			@RequestParam("scriptName") String scriptName, @RequestParam("notification") String notification)
//			throws Exception {
//
////    	try {
//		List<CarsDtClaimC> carsDtClaimCList = carsDtClaimCRepository.getCarsDtClaimC(scriptName, notification);
//
//		List<ClaimTransferRequest> claimTransferRequestList = new ArrayList<ClaimTransferRequest>();
//
//		for (CarsDtClaimC item : carsDtClaimCList) {
//			ClaimTransferRequest claimTransferRequest = new ClaimTransferRequest();
//			claimTransferRequest.setClaimTransferId(item.getDtId());
//			claimTransferRequest.setAccidentDate(stringtoyear(item.getAccidentDate()));
//			claimTransferRequest.setClaimTransferNumber(item.getClaimNum());
//			claimTransferRequest.setPolicyId(item.getPolicySerie());
//			claimTransferRequest.setVehicleCertificate(String.format("%04d", Integer.parseInt(item.getVehicleSerie())));
//			claimTransferRequest.setClaimTransferNotification(item.getNotification());
//			claimTransferRequest.setReportedDate(stringtoyear(item.getReportedDate()));
//			claimTransferRequest.setStatusCode(item.getStatusCode());
//			claimTransferRequest.setStatusDescription(item.getStatusDescription());
//			claimTransferRequest.setStatusDate(stringtoyear(item.getStatusDate()));
//			claimTransferRequest.setAccidentLatitude(item.getAccidentLatitude());
//			claimTransferRequest.setAccidentLongitude(item.getAccidentLongitude());
//			claimTransferRequest.setAccidentLocation(item.getAccidentLocation());
//			claimTransferRequest.setClaimReason(item.getClaimReason());
//			claimTransferRequest.setClaimRelatedNotification(item.getRelatedNotification());
//			List<CarsDtClaimPersonResponse> carsDtClaimPersonResponseList = carsDtClaimPersonRepository
//					.getCarsDtClaimPerson(scriptName, notification);
//
//			List<ClaimTransferPersonRequest> claimTransferPersonRequestList = new ArrayList<ClaimTransferPersonRequest>();
//
//			if (carsDtClaimPersonResponseList != null) {
//
//				for (CarsDtClaimPersonResponse item2 : carsDtClaimPersonResponseList) {
//
//					ClaimTransferPersonRequest claimTransferPersonRequest = new ClaimTransferPersonRequest();
//					claimTransferPersonRequest.setSequence(item2.getDtId());
//					claimTransferPersonRequest.setVehicleSequence(item2.getVehSeq());
//					// claimTransferPersonRequest.setResponsibility(item2.getTpResp());
//
//					ClaimTransferVehicleRequest claimTransferVehicleRequest = new ClaimTransferVehicleRequest();
//					claimTransferVehicleRequest.setOwnerFamilyName(item2.getOwnerFamilyName());
//					claimTransferVehicleRequest.setOwnerMiddleName(item2.getOwnerFatherName());
//					claimTransferVehicleRequest.setOwnerFirstName(item2.getOwnerFirstName());
//					claimTransferVehicleRequest.setDriverFirstName(item2.getDriverFisrtName());
//					claimTransferVehicleRequest.setDriverMiddleName(item2.getDriverFatherName());
//					claimTransferVehicleRequest.setDriverFamilyName(item2.getDriverFamilyName());
//					claimTransferVehicleRequest.setDriverPhone(item2.getDriverPhone());
//					claimTransferVehicleRequest.setDriverGender(item2.getGender());
//					if (item2.getDob() != null) {
//						claimTransferVehicleRequest.setDriverDob(stringtoyear(item2.getDob()));
//					}
//					claimTransferVehicleRequest.setMakeCode(item2.getMakeCode());
//					claimTransferVehicleRequest.setModelCode(item2.getModelCode());
//					claimTransferVehicleRequest.setVehicleYear(item2.getVehicleYear());
//					claimTransferVehicleRequest.setPlatePrefix(item2.getPlatePrefix());
//					claimTransferVehicleRequest.setPlateNumber(item2.getPlateNumber());
//					claimTransferVehicleRequest.setTpCompanyCode(item2.getTpCompanyId());
//					claimTransferVehicleRequest.setTpCompanyName(item2.getTpCompanyName());
//					// claimTransferVehicleRequest.setTpPolicyNumber(item2.getPolicyNumber);
//					// claimTransferVehicleRequest.setPolEffective(item2.getPolEffective);
//					// claimTransferVehicleRequest.setPolExpiry(item2.getPolExpiry);
//					claimTransferPersonRequest.setClaimTransferVehicleRequest(claimTransferVehicleRequest);
//
//					List<CarsDtClaimCCovers> carsDtClaimCCoversList = carsDtClaimCCoversRepository
//							.getCarsDtClaimCCovers(scriptName, notification, Integer.valueOf(item2.getVehSeq()));
//
//					if (carsDtClaimCCoversList != null) {
//						List<ClaimTransferCoverRequest> claimTransferCoverRequestList = new ArrayList<ClaimTransferCoverRequest>();
//
//						for (CarsDtClaimCCovers item3 : carsDtClaimCCoversList) {
//
//							ClaimTransferCoverRequest claimTransferCoverRequest = new ClaimTransferCoverRequest();
//							claimTransferCoverRequest.setSequence(item3.getSequence());
//							claimTransferCoverRequest.setCoverCode(item3.getCoverCode());
//							claimTransferCoverRequest.setRiskType(item3.getSetType());
//							claimTransferCoverRequest.setReserveAmount(item3.getReserveAmount());
//							claimTransferCoverRequest.setRecoveryReserveAmount(item3.getRecoveryReserveAmount());
//							// claimTransferCoverRequest.setRiskType("");
//							List<ClaimTransferSettlementRequest> claimTransferSettlementRequestList = new ArrayList<ClaimTransferSettlementRequest>();
//
//							List<CarsDtClaimSettls> carsDtClaimSettlsList = carsDtClaimSettlsRepository
//									.getCarsDtClaimSettls(scriptName, notification, item3.getCoverCode(),
//											item3.getSetType());
//
//							if (carsDtClaimSettlsList != null) {
//
//								for (CarsDtClaimSettls item4 : carsDtClaimSettlsList) {
//
//									ClaimTransferSettlementRequest claimTransferSettlementRequest = new ClaimTransferSettlementRequest();
//									claimTransferSettlementRequest.setTransaction(item4.getTransaction());
//									claimTransferSettlementRequest.setPaymentSequence(item4.getPaymentSequence());
//									claimTransferSettlementRequest.setCurrency(item4.getCurrency());
//									claimTransferSettlementRequest.setPaidAmount(item4.getPaidAmount());
//									claimTransferSettlementRequest.setPaymentDate(stringtoyear(item4.getPaymentDate()));
//									// claimTransferSettlementRequest.setPayeeType(item4.getPayeeType());
//									claimTransferSettlementRequest.setPayeeTypeCode(item4.getPayeeTypeCode());
//									claimTransferSettlementRequest
//											.setPayeeTypeDescription(item4.getPayeeTypeDescription());
//									claimTransferSettlementRequest.setPayeeCode(item4.getPayeeCode());
//									claimTransferSettlementRequest.setPayeeName(item4.getPayeeName());
//									claimTransferSettlementRequest.setType(item4.getSetType());
//									claimTransferSettlementRequestList.add(claimTransferSettlementRequest);
//								}
//
//								claimTransferCoverRequest
//										.setClaimTransferSettlementRequestList(claimTransferSettlementRequestList);
//
//							}
//
//							claimTransferCoverRequestList.add(claimTransferCoverRequest);
//						}
//						claimTransferPersonRequest.setClaimTransferCoverRequestList(claimTransferCoverRequestList);
//
//					}
//					claimTransferPersonRequestList.add(claimTransferPersonRequest);
//				}
//
//			}
//
//			List<CarsDtClaimBodilyInjury> carsDtClaimBodilyInjuryList = carsDtClaimBodilyInjuryRepository
//					.getCarsDtClaimBodilyInjury(scriptName, notification);
//
//			if (carsDtClaimBodilyInjuryList != null) {
//
//				for (CarsDtClaimBodilyInjury carsDtClaimBodilyInjury : carsDtClaimBodilyInjuryList) {
//
//					ClaimTransferPersonRequest claimTransferPersonRequest = new ClaimTransferPersonRequest();
//
//					ClaimTransferBodilyRequest claimTransferBodilyRequest = new ClaimTransferBodilyRequest();
//
//					claimTransferPersonRequest.setSequence(carsDtClaimBodilyInjury.getDtId());
//					claimTransferPersonRequest.setVehicleSequence(carsDtClaimBodilyInjury.getInjuredSeq());
//					// claimTransferPersonRequest.setResponsibility(carsDtClaimBodilyInjury.getTpResp());
//
//					claimTransferBodilyRequest.setBodilyDob(stringtoyear(carsDtClaimBodilyInjury.getBodilyDob()));
//					claimTransferBodilyRequest.setBodilyFirstName(carsDtClaimBodilyInjury.getBodilyFirstName());
//					claimTransferBodilyRequest.setBodilyLastName(carsDtClaimBodilyInjury.getBodilyLastName());
//					claimTransferBodilyRequest.setBodilyMobileNumber(carsDtClaimBodilyInjury.getBodilyMobileNumber());
//					claimTransferBodilyRequest.setBodilyType(carsDtClaimBodilyInjury.getInjuredPlace());
//					List<CarsDtClaimCCovers> carsDtClaimCCoversList = carsDtClaimCCoversRepository
//							.getCarsDtClaimCCovers(scriptName, notification,
//									Integer.valueOf(carsDtClaimBodilyInjury.getInjuredSeq()));
//
//					if (carsDtClaimCCoversList != null) {
//						List<ClaimTransferCoverRequest> claimTransferCoverRequestList = new ArrayList<ClaimTransferCoverRequest>();
//
//						for (CarsDtClaimCCovers item3 : carsDtClaimCCoversList) {
//
//							ClaimTransferCoverRequest claimTransferCoverRequest = new ClaimTransferCoverRequest();
//							claimTransferCoverRequest.setSequence(item3.getSequence());
//							claimTransferCoverRequest.setCoverCode(item3.getCoverCode());
//							claimTransferCoverRequest.setRiskType(item3.getSetType());
//							claimTransferCoverRequest.setReserveAmount(item3.getReserveAmount());
//							claimTransferCoverRequest.setRecoveryReserveAmount(item3.getRecoveryReserveAmount());
//
//							List<ClaimTransferSettlementRequest> claimTransferSettlementRequestList = new ArrayList<ClaimTransferSettlementRequest>();
//
//							List<CarsDtClaimSettls> carsDtClaimSettlsList = carsDtClaimSettlsRepository
//									.getCarsDtClaimSettls(scriptName, notification, item3.getCoverCode(),
//											item3.getSetType());
//
//							if (carsDtClaimSettlsList != null) {
//
//								for (CarsDtClaimSettls item4 : carsDtClaimSettlsList) {
//
//									ClaimTransferSettlementRequest claimTransferSettlementRequest = new ClaimTransferSettlementRequest();
//									claimTransferSettlementRequest.setTransaction(item4.getTransaction());
//									claimTransferSettlementRequest.setPaymentSequence(item4.getPaymentSequence());
//									claimTransferSettlementRequest.setCurrency(item4.getCurrency());
//									claimTransferSettlementRequest.setPaidAmount(item4.getPaidAmount());
//									claimTransferSettlementRequest.setPaymentDate(stringtoyear(item4.getPaymentDate()));
//									// claimTransferSettlementRequest.setPayeeType(item4.getPayeeType());
//									claimTransferSettlementRequest.setPayeeTypeCode(item4.getPayeeTypeCode());
//									claimTransferSettlementRequest
//											.setPayeeTypeDescription(item4.getPayeeTypeDescription());
//
//									claimTransferSettlementRequest.setPaymentDate(stringtoyear(item4.getPaymentDate()));
//									claimTransferSettlementRequest.setPayeeCode(item4.getPayeeCode());
//									claimTransferSettlementRequest.setPayeeName(item4.getPayeeName());
//									claimTransferSettlementRequest.setType(item4.getSetType());
//									// claimTransferSettlementRequest.setRiskType(item4.getRiskType());
//									claimTransferSettlementRequestList.add(claimTransferSettlementRequest);
//								}
//
//								claimTransferCoverRequest
//										.setClaimTransferSettlementRequestList(claimTransferSettlementRequestList);
//
//							}
//
//							claimTransferCoverRequestList.add(claimTransferCoverRequest);
//						}
//						claimTransferPersonRequest.setClaimTransferBodilyRequest(claimTransferBodilyRequest);
//						claimTransferPersonRequest.setClaimTransferCoverRequestList(claimTransferCoverRequestList);
//
//					}
//
//					claimTransferPersonRequestList.add(claimTransferPersonRequest);
//				}
//			}
//
//			List<CarsDtClaimMaterialDamage> carsDtClaimMaterialDamageList = carsDtClaimMaterialDamageRepository
//					.getCarsDtClaimMaterialDamage(scriptName, notification);
//			if (carsDtClaimMaterialDamageList != null) {
//				for (CarsDtClaimMaterialDamage carsDtClaimMaterialDamage : carsDtClaimMaterialDamageList) {
//
//					ClaimTransferPersonRequest claimTransferPersonRequest = new ClaimTransferPersonRequest();
//
//					ClaimTransferMaterialRequest claimTransferMaterialRequest = new ClaimTransferMaterialRequest();
//					claimTransferPersonRequest.setSequence(carsDtClaimMaterialDamage.getDtId());
//					claimTransferPersonRequest
//							.setVehicleSequence(carsDtClaimMaterialDamage.getMaterialDamageSequence());
//					claimTransferMaterialRequest
//							.setMaterialFullName(carsDtClaimMaterialDamage.getMaterialDamageOwnerName());
//					claimTransferMaterialRequest
//							.setMaterialMobileNumber(carsDtClaimMaterialDamage.getMaterialDamageOwnerPhone());
//					claimTransferMaterialRequest
//							.setMaterialDescription(carsDtClaimMaterialDamage.getMaterialDamageMaterialTypeDesc());
//					claimTransferPersonRequest.setClaimTransferMaterialRequest(claimTransferMaterialRequest);
//
//					List<CarsDtClaimCCovers> carsDtClaimCCoversList = carsDtClaimCCoversRepository
//							.getCarsDtClaimCCovers(scriptName, notification,
//									Integer.valueOf(carsDtClaimMaterialDamage.getMaterialDamageSequence()));
//
//					if (carsDtClaimCCoversList != null) {
//						List<ClaimTransferCoverRequest> claimTransferCoverRequestList = new ArrayList<ClaimTransferCoverRequest>();
//
//						for (CarsDtClaimCCovers item3 : carsDtClaimCCoversList) {
//
//							ClaimTransferCoverRequest claimTransferCoverRequest = new ClaimTransferCoverRequest();
//							claimTransferCoverRequest.setSequence(item3.getSequence());
//							claimTransferCoverRequest.setCoverCode(item3.getCoverCode());
//							claimTransferCoverRequest.setRiskType(item3.getSetType());
//							claimTransferCoverRequest.setReserveAmount(item3.getReserveAmount());
//							claimTransferCoverRequest.setRecoveryReserveAmount(item3.getRecoveryReserveAmount());
//
//							List<ClaimTransferSettlementRequest> claimTransferSettlementRequestList = new ArrayList<ClaimTransferSettlementRequest>();
//
//							List<CarsDtClaimSettls> carsDtClaimSettlsList = carsDtClaimSettlsRepository
//									.getCarsDtClaimSettls(scriptName, notification, item3.getCoverCode(),
//											item3.getSetType());
//
//							if (carsDtClaimSettlsList != null) {
//
//								for (CarsDtClaimSettls item4 : carsDtClaimSettlsList) {
//
//									ClaimTransferSettlementRequest claimTransferSettlementRequest = new ClaimTransferSettlementRequest();
//									claimTransferSettlementRequest.setTransaction(item4.getTransaction());
//									claimTransferSettlementRequest.setPaymentSequence(item4.getPaymentSequence());
//									claimTransferSettlementRequest.setCurrency(item4.getCurrency());
//									claimTransferSettlementRequest.setPaidAmount(item4.getPaidAmount());
//									claimTransferSettlementRequest.setPaymentDate(stringtoyear(item4.getPaymentDate()));
//									// claimTransferSettlementRequest.setPayeeType(item4.getPayeeType());
//									claimTransferSettlementRequest.setPayeeTypeCode(item4.getPayeeTypeCode());
//									claimTransferSettlementRequest
//											.setPayeeTypeDescription(item4.getPayeeTypeDescription());
//									claimTransferSettlementRequest.setPayeeCode(item4.getPayeeCode());
//									claimTransferSettlementRequest.setPayeeName(item4.getPayeeName());
//									claimTransferSettlementRequest.setType(item4.getSetType());
//									// claimTransferSettlementRequest.setRiskType(item4.getRiskType());
//									claimTransferSettlementRequestList.add(claimTransferSettlementRequest);
//								}
//
//								claimTransferCoverRequest
//										.setClaimTransferSettlementRequestList(claimTransferSettlementRequestList);
//
//							}
//
//							claimTransferCoverRequestList.add(claimTransferCoverRequest);
//						}
//						claimTransferPersonRequest.setClaimTransferMaterialRequest(claimTransferMaterialRequest);
//						claimTransferPersonRequest.setClaimTransferCoverRequestList(claimTransferCoverRequestList);
//
//					}
//
//					claimTransferPersonRequestList.add(claimTransferPersonRequest);
//				}
//
//			}
//
//			claimTransferRequest.setClaimTransferPersonRequestList(claimTransferPersonRequestList);
//			claimTransferRequestList.add(claimTransferRequest);
//		}
//
//		// List<ClaimTransferRequest> list =
//		// carsDtClaimCRepository.getCarsDtClaimC().stream().map(item ->{
//
//		// List<ClaimTransferPersonRequest> list1 = new
//		// ArrayList<ClaimTransferPersonRequest>();
////    		
////    		list1= carsDtClaimPersonRepository.getCarsDtClaimPerson().stream().map(item2 ->{
////    			
////    			ClaimTransferPersonRequest claimTransferPersonRequest = new ClaimTransferPersonRequest();
////    			claimTransferPersonRequest.setSequence(item2.getDtId());
////    			claimTransferPersonRequest.setVehicleSequence(item2.getVehSeq());
////    			claimTransferPersonRequest.setResponsibility(item2.getTpResp());
////    			
////    			//-----
////    			ClaimTransferVehicleRequest claimTransferVehicleRequest = new ClaimTransferVehicleRequest();
////    			claimTransferVehicleRequest.setOwnerFamilyName(item2.getOwnerFamilyName());
////    			claimTransferVehicleRequest.setOwnerFirstName(item2.getOwnerFirstName());
////    			claimTransferVehicleRequest.setDriverFirstName(item2.getDriverFisrtName());
////    			claimTransferVehicleRequest.setDriverFamilyName(item2.getDriverFamilyName());
////    			claimTransferVehicleRequest.setDriverPhone(item2.getDriverPhone());
////    			claimTransferVehicleRequest.setDriverGender(item2.getGender());
////    			claimTransferVehicleRequest.setDriverDob(stringtoyear(item2.getDob()));
////    			claimTransferVehicleRequest.setMakeCode(item2.getMakeCode());
////    			claimTransferVehicleRequest.setModelCode(item2.getModelCode());
////    			claimTransferVehicleRequest.setVehicleYear(item2.getVehicleYear());
////    			claimTransferVehicleRequest.setPlatePrefix(item2.getPlatePrefix());
////    			claimTransferVehicleRequest.setPlateNumber(item2.getPlateNumber());
////    			claimTransferVehicleRequest.setTpCompanyCode(item2.getTpCompanyId());
////    			claimTransferVehicleRequest.setTpCompanyName(item2.getTpCompanyName());
////    			//claimTransferVehicleRequest.setTpPolicyNumber(item2.getPolicyNumber);
////    			//claimTransferVehicleRequest.setPolEffective(item2.getPolEffective);
////    			//claimTransferVehicleRequest.setPolExpiry(item2.getPolExpiry);
////    			claimTransferPersonRequest.setClaimTransferVehicleRequest(claimTransferVehicleRequest);
////    			//-------
////    			ClaimTransferBodilyRequest claimTransferBodilyRequest = new ClaimTransferBodilyRequest();
////    			
////    			CarsDtClaimBodilyInjury  carsDtClaimBodilyInjury = new CarsDtClaimBodilyInjury();
////    			
////    			carsDtClaimBodilyInjury = carsDtClaimBodilyInjuryRepository.getCarsDtClaimBodilyInjury();
////    			try {
////    				if(claimTransferBodilyRequest != null) {
////    				BeanUtils.copyProperties(claimTransferBodilyRequest, carsDtClaimBodilyInjury);	
////    				claimTransferPersonRequest.setClaimTransferBodilyRequest(claimTransferBodilyRequest);
////    				}
////    			} catch (IllegalAccessException | InvocationTargetException e) {
////    				// TODO Auto-generated catch block
////    				e.printStackTrace();
////    			}
//		// ------
////    			ClaimTransferMaterialRequest claimTransferMaterialRequest = new ClaimTransferMaterialRequest();
////        		
////    	    	CarsDtClaimMaterialDamage carsDtClaimMaterialDamage= new CarsDtClaimMaterialDamage();
////    	    	
////    	    	carsDtClaimMaterialDamage = carsDtClaimMaterialDamageRepository.getCarsDtClaimMaterialDamage();
////    	    		
////    	    		if(carsDtClaimMaterialDamage !=null ) {
////    	    			claimTransferMaterialRequest.setMaterialFullName(carsDtClaimMaterialDamage.getMaterialDamageOwnerName());
////    	    			claimTransferMaterialRequest.setMaterialMobileNumber(carsDtClaimMaterialDamage.getMaterialDamageOwnerPhone());
////    	    			claimTransferMaterialRequest.setMaterialDescription(carsDtClaimMaterialDamage.getMaterialDamageMaterialTypeDesc());
////    	    			claimTransferPersonRequest.setClaimTransferMaterialRequest(claimTransferMaterialRequest);
////    	    		}
////    	    		
////    			if(carsDtClaimBodilyInjury != null ) {
////          			 claimTransferBodilyRequest.setBodilyFirstName(carsDtClaimBodilyInjury.getBodilyFirstName());
////          			 claimTransferBodilyRequest.setBodilyDob(stringtoyear(carsDtClaimBodilyInjury.getBodilyDob()));
////          			 claimTransferBodilyRequest.setBodilyLastName(carsDtClaimBodilyInjury.getBodilyLastName());
////          			 claimTransferBodilyRequest.setBodilyMobileNumber(carsDtClaimBodilyInjury.getBodilyMobileNumber());
////          			 claimTransferPersonRequest.setClaimTransferBodilyRequest(claimTransferBodilyRequest);
////          		 }
////    			
////    			List<ClaimTransferCoverRequest> list2 = new ArrayList<ClaimTransferCoverRequest>();
////    			list2= carsDtClaimCCoversRepository.getCarsDtClaimCCovers().stream().map(item3 ->{
////    				ClaimTransferCoverRequest claimTransferCoverRequest= new ClaimTransferCoverRequest();
////    				claimTransferCoverRequest.setSequence(item3.getSequence());
////    				claimTransferCoverRequest.setCoverCode(item3.getCoverCode());
////    				claimTransferCoverRequest.setReserveAmount(item3.getReserveAmount());
////    				claimTransferCoverRequest.setRecoveryReserveAmount(item3.getRecoveryReserveAmount());
////    				
////    				List<ClaimTransferSettlementRequest> list3 = new ArrayList<ClaimTransferSettlementRequest>();
////    				list3= carsDtClaimSettlsRepository.getCarsDtClaimSettls(item3.getCoverCode()).stream().map(item4 ->{
////    					ClaimTransferSettlementRequest claimTransferSettlementRequest = new ClaimTransferSettlementRequest();
////    					claimTransferSettlementRequest.setTransaction(item4.getTransaction());
////    					claimTransferSettlementRequest.setSequence(item4.getSequence());
////    					claimTransferSettlementRequest.setCurrency(item4.getCurrency());
////    					claimTransferSettlementRequest.setPaidAmount(item4.getPaidAmount());
////    					claimTransferSettlementRequest.setPaymentDate(stringtoyear(item4.getPaymentDate()));
////    					claimTransferSettlementRequest.setPayeeType(item4.getPayeeType());
////    					claimTransferSettlementRequest.setPayeeCode(item4.getPayeeCode());
////    					claimTransferSettlementRequest.setPayeeName(item4.getPayeeName());
////    					claimTransferSettlementRequest.setType(item4.getSetType());
////    					claimTransferSettlementRequest.setRiskType(item4.getRiskType());
////    					return claimTransferSettlementRequest;
////        			}).collect(Collectors.toList());
////    				
////    				claimTransferCoverRequest.setClaimTransferSettlementRequestList(list3);
////    				return claimTransferCoverRequest;
////    			}).collect(Collectors.toList());
////    			claimTransferPersonRequest.setClaimTransferCoverRequestList(list2);
////    			
////    			
////    			return claimTransferPersonRequest;
////    		}).collect(Collectors.toList());
////    		
////    		claimTransferRequest1.setClaimTransferPersonRequestList(list1);
////    		
////    		return claimTransferRequest1;
////    		}).collect(Collectors.toList());
//
//		return new ResponseEntity<List<ClaimTransferRequest>>(claimTransferRequestList, HttpStatus.OK);
//		// }catch (Exception e) {
//		// throw new Exception (e.toString());
//		// }
//	}

	@GetMapping("/claims1")
	public ResponseEntity<ClaimsResponse> generateClaimsSurvey1(
			@RequestParam("notification") String notification,@RequestParam("insuranceId") String insuranceId   ,@RequestParam("fromDate") String  fromDate,@RequestParam("batch") String  batch,@RequestParam("toDate") String   toDate)
			throws Exception {
		try {
			return claimTransferService.generateClaimsSurvey( notification,insuranceId, fromDate, batch,  toDate);

		} catch (

		Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			return new ResponseEntity(sStackTrace, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public String stringtoyear(String s) {
		try {

			Date d = new SimpleDateFormat("yyyy/MM/dd").parse(s);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
