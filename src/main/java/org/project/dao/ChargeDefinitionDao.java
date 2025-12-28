package org.project.dao;

import org.project.dto.ChargeDefinitionDTO;
import org.project.exception.ChargeDefinitionCodeAlreadyExist;

import java.util.List;

public interface ChargeDefinitionDao {

    boolean saveNewRecordToMasterTable(ChargeDefinitionDTO chargeDefinitionDTO) throws ChargeDefinitionCodeAlreadyExist;

    List<ChargeDefinitionDTO> fetchRecordsFromMasterTable();
    boolean isChargeDefinitionCodeExists(String chargeDefinitionCode);

    List<ChargeDefinitionDTO> fetchAllRecordsOfTheMasterTable();

    ChargeDefinitionDTO getChargeDefinitionFromTheMasterTableByCode(String chargeDefinitionCode);

    boolean deleteSavedRecordFromTheMasterTable(ChargeDefinitionDTO chargeDefinitionDTO);
}
