package org.project.dao;


import org.project.dto.ChargePolicyTempDto;
import org.project.exception.PolicyCodeAlreadyExistException;

import java.util.List;

public interface ChargePolicyTempDao {

    boolean saveChargePolicy(ChargePolicyTempDto chargePolicyTempDto) throws PolicyCodeAlreadyExistException;
    boolean updateChargePolicy(ChargePolicyTempDto chargePolicyTempDto);
    ChargePolicyTempDto getChargePolicy(String policyCode);
    boolean deleteChargePolicy(String policyCode);
    List<ChargePolicyTempDto> getAllChargePolicy();
    ChargePolicyTempDto getChargePolicyByEditFlag(Boolean flagForEdit);
//    List<ChargePolicyTempDto> getAllChargePolicyStatusWithoutA();

}
