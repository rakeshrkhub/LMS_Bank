package org.project.dao;

import org.project.dto.LoanApplicationDTO;
import org.project.entity.permanent.LoanApplication;
import org.project.entity.temporary.LoanApplicationTemp;

import java.util.List;

public interface LoanApplicationDAO {
    LoanApplication getApplicationByAccountNumber(String loanAccountNumber);
    Long create(LoanApplicationDTO loanApplicationDTO);
    List<LoanApplicationDTO> readingAll();
    LoanApplicationDTO read(Long loanId);
    boolean merge(LoanApplicationDTO loanApplicationDTO);
    boolean merge(LoanApplication loanApplication);
    boolean update(LoanApplicationDTO loanApplicationDTO);
    boolean delete(String longApplicationID);
    LoanApplicationDTO readByLoanApplicationId(String loanApplicationId);
    LoanApplicationDTO readByLoanAccountNumber(String loanAccountNumber);

    LoanApplication getLoanIdAgainstApplication(String loanApplicationId);
    LoanApplicationTemp getLoanApplicationAgainstLoanId(Long loanId);

}

