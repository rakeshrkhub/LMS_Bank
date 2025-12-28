package org.project.service;


import org.project.dto.ChargePolicyDto;
import org.project.dto.ChargePolicyParameterTempDto;
import org.project.dto.ChargePolicyTempDto;
import org.project.exception.PolicyCodeAlreadyExistException;

import java.util.List;


public interface ChargePolicyTempService {

    boolean saveChargePolicy(ChargePolicyTempDto chargePolicyTempDto) throws PolicyCodeAlreadyExistException;

    boolean updateChargePolicy(ChargePolicyTempDto chargePolicyTempDto);

    ChargePolicyTempDto getChargePolicy(String policyCode);

    boolean deleteChargePolicy(String policyCode);

    List<ChargePolicyTempDto> getAllChargePolicy();

    ChargePolicyTempDto getChargePolicyByEditFlag(Boolean flagForEdit);

    List<ChargePolicyDto> filterAndRemoveDuplicates(List<ChargePolicyTempDto> chargePoliciesTempDtoList);


    ChargePolicyTempDto setCreatedDateAndCreatedBy(ChargePolicyTempDto chargePolicyTempDto);
    ChargePolicyTempDto setRecordStatus(ChargePolicyTempDto chargePolicyTempDto);


    String saveCase(ChargePolicyTempDto chargePolicyTempDto);


    String saveAndRequestCase(ChargePolicyTempDto chargePolicyTempDto);

    List<ChargePolicyParameterTempDto> setChargePolicyParameters(List<String> chargeDefinitionCode,List<String> operator,List<String> value);


    boolean deleteCase(String policyCode,String recordStatus);

    ChargePolicyTempDto editCase(String policyCode,String recordStatus);
    List<ChargePolicyTempDto> getAllChargePolicyForChecker();


}
