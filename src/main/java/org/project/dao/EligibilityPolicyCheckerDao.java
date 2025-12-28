package org.project.dao;

import org.project.dto.EligibilityPolicyTempDTO;
import org.project.entity.permanent.EligibilityPolicy;

import java.util.List;

public interface EligibilityPolicyCheckerDao {
    boolean approveEligibilityPolicy(EligibilityPolicy eligibilityPolicy);
    boolean rejectEligibilityPolicy(EligibilityPolicy eligibilityPolicy);
    boolean deleteEligibilityPolicy(Long eligibilityPolicyId);
    boolean updateEligibilityPolicy(EligibilityPolicy eligibilityPolicy);
    boolean updateEligibilityPolicyByPolicyCode(String policyCode);
    EligibilityPolicyTempDTO getEligibilityPolicy(Long policyId);
    EligibilityPolicyTempDTO getEligibilityPolicyByCode(String policyCode);
    List<EligibilityPolicy> viewAllEligibilityPolicy();
}
