package org.project.service;

import org.project.dto.EmiParameterDTO;
import org.project.dto.RepayScheduleDTO;
import org.project.entity.permanent.RepaySchedule;

import java.sql.Date;
import java.util.List;

public interface RepayScheduleService {

    List<RepayScheduleDTO> fetchRepaySchedule(String loanId);
    EmiParameterDTO getEmiParams(Long loanId);
    List<RepaySchedule> generateRepayScheduleForApproval(Long loanId);
    Date getNextInstallmentDate(List<RepayScheduleDTO> repayScheduleList);
    Double getPrincipalOutstanding(List<RepayScheduleDTO> repayScheduleList);
    Integer getInstallmentsToBePaid(List<RepayScheduleDTO> repayScheduleList);
    Double getOpeningBalance(List<RepayScheduleDTO> repayScheduleList,Integer installmentsPaid);
}
