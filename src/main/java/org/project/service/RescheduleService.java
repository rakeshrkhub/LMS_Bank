package org.project.service;

import org.project.dto.RepayScheduleDTO;
import org.project.dto.RescheduleResponseDTO;

import java.util.List;

public interface RescheduleService {
    String getCustomerNameByLoanAccountNumber(String loanAccountNumber);
    RescheduleResponseDTO getRescheduleResponseDTOByLoanAccountNumber(String loanAccountNumber);
    List<RepayScheduleDTO> rescheduleByDueDate(String loanAccountNumber, Integer dueDate);
    List<RepayScheduleDTO> rescheduleByTenure(String loanAccountNumber, Integer tenure, String tenureIn);
    List<RepayScheduleDTO> rescheduleByInstallmentAmount(String loanAccountNumber, Double installmentAmount);
    boolean saveUpdatedRepaySchedule();
    String getLastStatus();
}
