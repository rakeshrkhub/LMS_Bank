package org.project.service;

import org.project.dto.EligibilityPolicyTempDTO;
import org.project.entity.permanent.EligibilityPolicy;
import org.project.entity.temporary.EligibilityPolicyTemp;

import java.util.List;

public interface EligibilityPolicyCheckerService {
    boolean approveEligibilityPolicy(EligibilityPolicyTemp eligibilityPoliciesTemp);
    boolean rejectEligibilityPolicy(EligibilityPolicyTemp eligibilityPoliciesTemp);
    boolean updateEligibilityPolicy(EligibilityPolicyTemp eligibilityPoliciesTemp);
    EligibilityPolicyTempDTO getEligibilityPolicy(Long policyId);
    EligibilityPolicyTempDTO getEligibilityPolicyByCode(String policyCode);

    List<EligibilityPolicy> viewAllEligibilityPolicyFiltered();
    List<EligibilityPolicy> viewAllEligibilityPolicy();

}
