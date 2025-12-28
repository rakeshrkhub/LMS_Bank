package org.project.dao;

import org.project.dto.RescheduleResponseDTO;
import org.project.entity.temporary.RepayScheduleTemp;

import java.util.List;

public interface RescheduleDao {

    String getCustomerNameByLoanAccountNumber(String loanAccountNumber);
    RescheduleResponseDTO getRescheduleResponse(String loanAccountNumber);
    List<RepayScheduleTemp> checkRepaySchedule(String key, String value);
}
