package org.project.service;

import org.project.dao.ChargeDefinitionDao;
import org.project.dto.ChargeDefinitionDTO;
import org.project.exception.ChargeDefinitionCodeAlreadyExist;
import org.project.utility.dtomapper.ChargeDefinitionDTOToChargeDefinitionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeDefinitionServiceImpl implements ChargeDefinitionService {

    @Autowired
    ChargeDefinitionDao chargeDefinitionDao;
    @Autowired
    ChargeDefinitionDTOToChargeDefinitionMapper chargeDefinitionDTOMapping;

    @Override
    public boolean saveNewRecordToMasterTable(ChargeDefinitionDTO chargeDefinitionDTO) throws ChargeDefinitionCodeAlreadyExist {
   //     ChargeDefinition chargeDefinition = chargeDefinitionDTOMapping.dtoToEntityConvertor(chargeDefinitionDTO);
        return chargeDefinitionDao.saveNewRecordToMasterTable(chargeDefinitionDTO);
    }

    @Override
    public List<ChargeDefinitionDTO> fetchDetails() {
        return chargeDefinitionDao.fetchRecordsFromMasterTable();
    }

    @Override
    public boolean isChargeDefinitionCodeExists(String chargeDefinitionCode) {
        return chargeDefinitionDao.isChargeDefinitionCodeExists(chargeDefinitionCode);
    }

    @Override
    public List<ChargeDefinitionDTO> fetchDetailsFromTheMasterTable() {
        return chargeDefinitionDao.fetchAllRecordsOfTheMasterTable();
    }

    @Override
    public ChargeDefinitionDTO getChargeDefinitionFromTheMasterTableByCode(String chargeDefinitionCode) {
        return chargeDefinitionDao.getChargeDefinitionFromTheMasterTableByCode(chargeDefinitionCode);
    }

    @Override
    public boolean deleteSavedRecordFromTheMasterTable(ChargeDefinitionDTO chargeDefinitionDTO) {
        return chargeDefinitionDao.deleteSavedRecordFromTheMasterTable(chargeDefinitionDTO);
    }


}
