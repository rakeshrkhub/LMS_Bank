package org.project.dao;

import org.project.dto.ChargeDefinitionTempDTO;
import org.project.exception.ChargeDefinitionCodeAlreadyExist;

import java.util.List;

public interface ChargeDefinitionTempDao {
    boolean saveChargeDefinition(ChargeDefinitionTempDTO chargeDefinitionTemp) throws ChargeDefinitionCodeAlreadyExist;
    ChargeDefinitionTempDTO fetchSaveData();
    List<ChargeDefinitionTempDTO> fetchSaveDataByFlag();
    ChargeDefinitionTempDTO fetchChargeDefinitionByCode(String chargeDefinitionCode);

    boolean updateChargeDefinition(ChargeDefinitionTempDTO chargeDefinitionTemp);

    boolean deleteChargeDefinition(String chargeDefinitionCode);
    List<ChargeDefinitionTempDTO> fetchChargeDefinitionFromTemporaryTable();

    ChargeDefinitionTempDTO approveChargeDefinition(String chargeDefinitionCode);

    boolean rejectChargeDefinition(String chargeDefinitionCode);

    boolean saveModifyRequestDetails(ChargeDefinitionTempDTO chargeDefinitionTempDTO);

    boolean saveDeleteRequestDetails(ChargeDefinitionTempDTO chargeDefinitionTempDTO);
}
