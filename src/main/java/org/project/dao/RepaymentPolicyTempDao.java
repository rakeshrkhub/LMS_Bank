package org.project.dao;

import org.project.dto.RepaymentPolicyDTO;
import org.project.exception.RepaymentPolicyCodeDuplicationExcaption;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepaymentPolicyTempDao {
     boolean insertRepaymentPolicy(RepaymentPolicyDTO repaymentPolicy) throws RepaymentPolicyCodeDuplicationExcaption;
     boolean updateRepaymentPolicy(RepaymentPolicyDTO repaymentPolicy);
     boolean deleteRepaymentPolicy(String code);
     RepaymentPolicyDTO getRepaymentPolicyById(String id);
     List<RepaymentPolicyDTO> getAllRepaymentPolicy();
     RepaymentPolicyDTO checkSave();
     List<RepaymentPolicyDTO> getAllRepaymentPolicyRejeted();


}
