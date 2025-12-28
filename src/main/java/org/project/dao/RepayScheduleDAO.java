package org.project.dao;


import org.project.dto.RepayScheduleDTO;

import java.util.List;

public interface RepayScheduleDAO {
    List<RepayScheduleDTO> fetchRepaySchedule(Long loanId);
}
