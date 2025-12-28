package org.project.service;

import org.project.dto.LoanAccountDTO;
import org.project.dto.LoanAccountRequiredFieldDTO;

import java.util.List;

public interface LoanAccountService {
    boolean insertLoanAccount(LoanAccountDTO loanAccountDTO);
    LoanAccountDTO getByLoanAccountId(Long loanAccountId);
    LoanAccountDTO getByAccountNumber(String accountNumber);
    boolean updateLoanAccount(LoanAccountDTO loanAccount);
    boolean delete(String accountNumber);
    List<LoanAccountDTO> getAllLoanAccounts();

    boolean isLoanAccountPresent(String accountNumber);

    LoanAccountRequiredFieldDTO getAllFields(String accountNumber);
    Long getRowCount();
    List<LoanAccountDTO> getLoanAccountsInBatch(int offset, int batchSize);
}
