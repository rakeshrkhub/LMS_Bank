package org.project.dao;

import org.project.dto.EligibilityPolicyParameterDefinitionDTO;

import java.util.List;

public interface EligibilityPolicyParameterDefinitionDAO {

    boolean updatePerEligibilityParameter(EligibilityPolicyParameterDefinitionDTO eligibilityParameterDTO);

    boolean deletePerEligibilityParameter(EligibilityPolicyParameterDefinitionDTO eligibilityParameterDTO);
    boolean deletePerEligibilityParameterByCode(String code);

    EligibilityPolicyParameterDefinitionDTO getEligibilityParameterById(Long eligibilityParametersId);

    boolean deleteEligibilityParameterPerById( Long id);

    EligibilityPolicyParameterDefinitionDTO searchEligibilityParameterPerByCode(String code);


    boolean insertPerEligibilityParameter(EligibilityPolicyParameterDefinitionDTO eligibilityParameterDTO);

    List<EligibilityPolicyParameterDefinitionDTO> getAllPerEligibilityParameter();



}
