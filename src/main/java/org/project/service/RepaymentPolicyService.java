package org.project.service;

import org.project.dto.RepaymentPolicyDTO;
import org.project.entity.permanent.RepaymentPolicy;

import java.util.List;

public interface RepaymentPolicyService {
    boolean insertRepaymentPolicy(RepaymentPolicyDTO repaymentPolicy);

    boolean updateRepaymentPolicy(RepaymentPolicyDTO repaymentPolicy);

    boolean deleteRepaymentPolicy(String code);

    RepaymentPolicyDTO getRepaymentPolicyById(String id);

    List<RepaymentPolicyDTO> getAllRepaymentPolicy();

    RepaymentPolicy getRepayPolicyByCode(String code);
}
