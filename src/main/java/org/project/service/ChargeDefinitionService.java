package org.project.service;

import org.project.dto.ChargeDefinitionDTO;
import org.project.exception.ChargeDefinitionCodeAlreadyExist;

import java.util.List;



public interface ChargeDefinitionService {


    boolean saveNewRecordToMasterTable(ChargeDefinitionDTO chargeDefinitionDTO) throws ChargeDefinitionCodeAlreadyExist;

    List<ChargeDefinitionDTO> fetchDetails();
    boolean isChargeDefinitionCodeExists(String chargeDefinitionCode);


    List<ChargeDefinitionDTO> fetchDetailsFromTheMasterTable();

    ChargeDefinitionDTO getChargeDefinitionFromTheMasterTableByCode(String chargeDefinitionCode);

    boolean deleteSavedRecordFromTheMasterTable(ChargeDefinitionDTO chargeDefinitionDTO);
}
