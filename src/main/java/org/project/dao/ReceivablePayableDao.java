package org.project.dao;


import org.project.dto.ReceivablePayableDTO;

import java.util.List;

public interface ReceivablePayableDao {
    boolean insertReceivablePayable(ReceivablePayableDTO receivablePayable);
    boolean updateReceivablePayable(ReceivablePayableDTO receivablePayable);
    boolean deleteReceivablePayable(ReceivablePayableDTO receivablePayable);
    ReceivablePayableDTO getReceivablePayable(Long receivablePayableId);
    List<ReceivablePayableDTO> getAllReceivablePayable();

    List<ReceivablePayableDTO> getReceivablePayableBYLoanAccId(Long loanAccountId);
}
