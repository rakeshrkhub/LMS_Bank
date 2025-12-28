package org.project.utility.temptoperm;

import org.project.dto.ChargePolicyDto;
import org.project.dto.ChargePolicyParameterDto;
import org.project.dto.ChargePolicyParameterTempDto;
import org.project.dto.ChargePolicyTempDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChargePolicyConvertor {


//    convert ChargePolicyTempDto to ChargePolicyDto
    public ChargePolicyDto chargePolicyConvertor(ChargePolicyTempDto chargePolicyTempDto)
    {
        ChargePolicyDto chargePolicy = new ChargePolicyDto();
        chargePolicy.setPolicyCode(chargePolicyTempDto.getPolicyCode());
        chargePolicy.setPolicyName(chargePolicyTempDto.getPolicyName());

        List<ChargePolicyParameterDto> chargePolicyParameterDtoList = new ArrayList<>();
        for (ChargePolicyParameterTempDto chargePolicyParameterTemp:chargePolicyTempDto.getChargePolicyParameterList())
        {
            ChargePolicyParameterDto chargePolicyParameterDto = new ChargePolicyParameterDto();
            chargePolicyParameterDto.setChargePolicyParameterId(chargePolicyParameterTemp.getChargePolicyParameterId());
            chargePolicyParameterDto.setValue(chargePolicyParameterTemp.getValue());
            chargePolicyParameterDto.setOperator(chargePolicyParameterTemp.getOperator());

            chargePolicyParameterDto.setChargeDefinitionCode(chargePolicyParameterTemp.getChargeDefinitionCode());
            chargePolicyParameterDtoList.add(chargePolicyParameterDto);
        }
        chargePolicy.setChargePolicyParameterList(chargePolicyParameterDtoList);
//        chargePolicy.setSaveFlag(chargePolicyTempDto.getSaveFlag());
        chargePolicy.setAuthorizedBy(chargePolicyTempDto.getAuthorizedBy());
        chargePolicy.setAuthorizedDate(chargePolicyTempDto.getAuthorizedDate());
        chargePolicy.setModifiedBy(chargePolicyTempDto.getModifiedBy());
        chargePolicy.setModifiedDate(chargePolicyTempDto.getModifiedDate());
        chargePolicy.setCreatedBy(chargePolicyTempDto.getCreatedBy());
        chargePolicy.setCreationDate(chargePolicyTempDto.getCreationDate());
        chargePolicy.setRecordStatus(chargePolicyTempDto.getRecordStatus());
//        chargePolicy.setActiveInactiveFlag(chargePolicyTempDto.getActiveInactiveFlag());
        return chargePolicy;
    }

//    convert ChargePolicyDto to ChargePolicyTempDto

    public ChargePolicyTempDto permDtoToTempDto(ChargePolicyDto chargePolicyDto)
    {
        ChargePolicyTempDto chargePolicyTempDto = new ChargePolicyTempDto();
        chargePolicyTempDto.setPolicyCode(chargePolicyDto.getPolicyCode());
        chargePolicyTempDto.setPolicyName(chargePolicyDto.getPolicyName());

        List<ChargePolicyParameterDto> chargePolicyParameterDtoList = chargePolicyDto.getChargePolicyParameterList();
        List<ChargePolicyParameterTempDto> chargePolicyParameterTempDtos = new ArrayList<>();

        for(ChargePolicyParameterDto chargePolicyParameterDto: chargePolicyParameterDtoList)
        {
            ChargePolicyParameterTempDto chargePolicyParameterTempDto = new ChargePolicyParameterTempDto();
            chargePolicyParameterTempDto.setChargePolicyParameterId(chargePolicyParameterDto.getChargePolicyParameterId());
            chargePolicyParameterTempDto.setChargeDefinitionCode(chargePolicyParameterDto.getChargeDefinitionCode());
            chargePolicyParameterTempDto.setOperator(chargePolicyParameterDto.getOperator());
            chargePolicyParameterTempDto.setValue(chargePolicyParameterDto.getValue());
            chargePolicyParameterTempDtos.add(chargePolicyParameterTempDto);
        }

        chargePolicyTempDto.setChargePolicyParameterList(chargePolicyParameterTempDtos);

        chargePolicyTempDto.setModifiedDate(chargePolicyDto.getModifiedDate());
        chargePolicyTempDto.setModifiedBy(chargePolicyDto.getModifiedBy());
        chargePolicyTempDto.setAuthorizedBy(chargePolicyDto.getAuthorizedBy());
        chargePolicyTempDto.setAuthorizedDate(chargePolicyDto.getAuthorizedDate());
        chargePolicyTempDto.setCreatedBy(chargePolicyDto.getCreatedBy());
        chargePolicyTempDto.setCreationDate(chargePolicyDto.getCreationDate());
        chargePolicyTempDto.setRecordStatus(chargePolicyDto.getRecordStatus());
        chargePolicyTempDto.setActiveInactiveFlag(chargePolicyDto.getActiveInactiveFlag());
//        chargePolicyTempDto.setSaveFlag(chargePolicyDto.getSaveFlag());

        return chargePolicyTempDto;
    }
}
