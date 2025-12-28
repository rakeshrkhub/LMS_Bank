package org.project.dao;
import org.project.dto.LoanProductDTO;

import java.util.List;

public interface LoanProductTempDAO {

        boolean addLoanProduct(LoanProductDTO loanProductDTO);

        boolean updateLoanProduct(LoanProductDTO loanProductDTO);

        boolean deleteLoanProduct(Long id);

        LoanProductDTO getLoanProductByID(Long id);

        LoanProductDTO getLoanProductByCode(String code);

        List<LoanProductDTO> getAllLoanProducts();

        LoanProductDTO getLoanProductWithSaveFlag();

        List<LoanProductDTO> getAllValidLoanProducts();
}
