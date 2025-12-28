package org.project.utility.dtomapper;

import org.project.entity.permanent.Allocation;
import org.project.dto.AllocationDTO;

import java.util.stream.Collectors;

public class DTOToAllocationMapper {


    public static Allocation mapDTOToObject(AllocationDTO allocationDTO){

        Allocation allocation = new Allocation();

        LoanAccountDTOMapper loanAccountDTOMapper = new LoanAccountDTOMapper();

        allocation.setAllocationId(allocationDTO.getAllocationId());

        if(allocationDTO.getLoanAccountDTO()!=null)allocation.setLoanAccount(loanAccountDTOMapper.mapDTOToObject(allocationDTO.getLoanAccount()));
        allocation.setDepositDate(allocationDTO.getDepositDate());
        allocation.setPenaltyList(allocationDTO.getPenaltyDTOS().stream().map(PenaltyDTOMapper::penaltyDTOToPenaltyEntity).collect(Collectors.toList()));
        allocation.setInterestComponentReceived(allocationDTO.getInterestComponentReceived());
        allocation.setPrincipalComponentReceived(allocationDTO.getPrincipalComponentReceived());

        return allocation;

    }

}
