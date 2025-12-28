package org.project.service;

import org.project.dto.ChargePolicyDto;

import java.util.List;


public interface ChargePolicyService {

    boolean saveChargePolicy(ChargePolicyDto chargePolicyDto);

    boolean editChargePolicy(ChargePolicyDto chargePolicyTempDto);

    ChargePolicyDto getChargePolicy(String policyCode);

    boolean deleteChargePolicy(String policyCode);

    List<ChargePolicyDto> getAllChargePolicy();
    boolean policyAuthorization(String policyCode);
    boolean policyRejection(String policyCode);

}
