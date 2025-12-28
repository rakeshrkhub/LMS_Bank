package org.project.service;

import org.project.dto.ChargeDefinitionTempDTO;
import org.project.exception.ChargeDefinitionCodeAlreadyExist;

import java.util.List;

public interface ChargeDefinitionTempService {
    boolean saveChargeDefinition(ChargeDefinitionTempDTO chargeDefinition) throws ChargeDefinitionCodeAlreadyExist;
    ChargeDefinitionTempDTO fetchSave();
    List<ChargeDefinitionTempDTO> fetchDetailsByFlag();
    ChargeDefinitionTempDTO getChargeDefinitionByCode(String chargeDefinitionCode);

    boolean updateChargeDefinition(ChargeDefinitionTempDTO chargeDefinitionTempDTO);

    boolean deleteChargeDefinition(String chargeDefinitionCode);
    List<ChargeDefinitionTempDTO> fetchChargeDefinitionFromTemporaryTable();

    ChargeDefinitionTempDTO approveChargeDefinition(String chargeDefinitionCode);

    boolean rejectChargeDefinition(String chargeDefinitionCode);

    boolean saveModifyRequestDetails(ChargeDefinitionTempDTO chargeDefinitionTempDTO);

    boolean saveDeleteRequestDetails(ChargeDefinitionTempDTO chargeDefinitionTempDTO);


//    ChargeDefinitionTempDTO rejectChargeDefinition(String chargeDefinitionCode);
}
