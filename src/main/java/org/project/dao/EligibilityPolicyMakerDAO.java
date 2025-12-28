package org.project.dao;

import org.project.dto.EligibilityPolicyTempDTO;
import org.project.entity.temporary.EligibilityPolicyTemp;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface EligibilityPolicyMakerDAO {
    boolean insertEligibilityPolicy(EligibilityPolicyTempDTO eligibilityPolicies);
    boolean deleteEligibilityPolicy(Long policyId);
    boolean deleteEligibilityPolicy(EligibilityPolicyTempDTO eligibilityPolicyTempDTO);
    boolean deleteEligibilityPolicyById(Long policyId);

    boolean updateEligibilityPolicy(EligibilityPolicyTempDTO eligibilityPolicies);
    EligibilityPolicyTempDTO getEligibilityPolicyDTO(Long policyId);
    EligibilityPolicyTemp getEligibilityPolicy(Long policyId);
    List<EligibilityPolicyTemp> viewAllEligibilityPolicy();
}
