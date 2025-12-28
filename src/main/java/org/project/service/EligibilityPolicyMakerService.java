package org.project.service;
import org.project.dto.EligibilityPolicyTempDTO;
import org.project.entity.temporary.EligibilityPolicyTemp;

import java.util.List;

public interface EligibilityPolicyMakerService {
    boolean insertEligibilityPolicy(EligibilityPolicyTempDTO eligibilityPoliciesDTO);
    boolean deleteEligibilityPolicy(Long policyId,String flag);
    boolean deleteEligibilityPolicy(EligibilityPolicyTempDTO eligibilityPolicyTempDTO);
    boolean deleteEligibilityPolicyById(Long policyId);
    boolean updateEligibilityPolicy(EligibilityPolicyTempDTO eligibilityPolicies);
    EligibilityPolicyTempDTO getEligibilityPolicy(Long policyId);
    List<EligibilityPolicyTemp> viewAllEligibilityPolicy();
}
