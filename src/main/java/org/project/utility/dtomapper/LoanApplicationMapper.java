package org.project.utility.dtomapper;


import org.project.entity.permanent.LoanApplication;
import org.project.entity.meta.MetaData;
import org.project.dto.LoanApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationMapper {

    @Autowired
    private LoanProductDTOMapper loanProductDTOMapper;


    public LoanApplicationDTO toDTO(LoanApplication loanApplication){
        if(loanApplication ==null)return null;
        LoanApplicationDTO loanApplicationDTO=new LoanApplicationDTO();

        loanApplicationDTO.setLoanId(loanApplication.getLoanId());
        loanApplicationDTO.setLoanApplicationId(loanApplication.getLoanApplicationId());
        loanApplicationDTO.setApplicationCreationDate(loanApplication.getApplicationCreationDate());
        loanApplicationDTO.setLoanAmount(loanApplication.getLoanAmount());
        loanApplicationDTO.setTenure(loanApplication.getTenure());
        loanApplicationDTO.setLoanAccountNumber(loanApplication.getLoanAccountNumber());
        loanApplicationDTO.setLoanStatus(loanApplication.getLoanStatus());
        loanApplicationDTO.setBranch(loanApplication.getBranch());
        loanApplicationDTO.setTenureIn(loanApplication.getTenureIn());
        loanApplicationDTO.setCustomerDTO(CustomerMapper.toDTO(loanApplication.getCustomer()));

        loanApplicationDTO.setRecordStatus(loanApplication.getMetaData().getRecordStatus());
        loanApplicationDTO.setCreationDate(loanApplication.getMetaData().getCreationDate());
        loanApplicationDTO.setCreatedBy(loanApplication.getMetaData().getCreatedBy());
        loanApplicationDTO.setModifiedBy(loanApplication.getMetaData().getModifiedBy());
        loanApplicationDTO.setModifiedDate(loanApplication.getMetaData().getModifiedDate());
        loanApplicationDTO.setAuthorizedDate(loanApplication.getMetaData().getAuthorizedDate());
        loanApplicationDTO.setAuthorizedBy(loanApplication.getMetaData().getAuthorizedBy());

        loanApplicationDTO.setLoanProductDTO(loanProductDTOMapper.loanProductToDto(loanApplication.getLoanProduct()));

        return loanApplicationDTO;
    }


    public LoanApplication toEntity(LoanApplicationDTO loanApplicationDTO){
        if(loanApplicationDTO==null)return null;
        LoanApplication loanApplication =new LoanApplication();

        loanApplication.setLoanId(loanApplicationDTO.getLoanId());
        loanApplication.setLoanApplicationId(loanApplicationDTO.getLoanApplicationId());
        loanApplication.setApplicationCreationDate(loanApplicationDTO.getApplicationCreationDate());
        loanApplication.setLoanAmount(loanApplicationDTO.getLoanAmount());
        loanApplication.setTenure(loanApplicationDTO.getTenure());
        loanApplication.setLoanAccountNumber(loanApplicationDTO.getLoanAccountNumber());
        loanApplication.setLoanStatus(loanApplicationDTO.getLoanStatus());
        loanApplication.setBranch(loanApplicationDTO.getBranch());
        loanApplication.setLoanStatus(loanApplicationDTO.getLoanStatus());
        loanApplication.setTenureIn(loanApplicationDTO.getTenureIn());
        loanApplication.setCustomer(CustomerMapper.toEntity(loanApplicationDTO.getCustomerDTO()));


        MetaData metaData = new MetaData();
        metaData.setCreationDate(loanApplicationDTO.getCreationDate());
        metaData.setAuthorizedBy(loanApplicationDTO.getAuthorizedBy());
        metaData.setActiveInactiveFlag(loanApplicationDTO.getActiveInactiveFlag());
        metaData.setAuthorizedDate(loanApplicationDTO.getAuthorizedDate());
        metaData.setModifiedBy(loanApplicationDTO.getModifiedBy());
        metaData.setModifiedDate(loanApplicationDTO.getModifiedDate());
        metaData.setRecordStatus(loanApplicationDTO.getRecordStatus());
        metaData.setCreatedBy(loanApplicationDTO.getCreatedBy());

        loanApplication.setMetaData(metaData);


        loanApplication.setLoanProduct(loanProductDTOMapper.dtoToLoanProduct(loanApplicationDTO.getLoanProductDTO()));

        return loanApplication;
    }
}
