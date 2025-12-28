package org.project.utility.dtomapper;

import org.project.dto.PenaltyDTO;
import org.project.entity.permanent.Penalty;

public class PenaltyDTOMapper {

    public static Penalty penaltyDTOToPenaltyEntity(PenaltyDTO penaltyDTO){

        Penalty penalty = new Penalty();

        penalty.setDescription(penaltyDTO.getDescription());
        penalty.setPenaltyAmount(penaltyDTO.getPenaltyAmount());
        penalty.setPenaltyId(penaltyDTO.getPenaltyId());

        return penalty;
    }

    public static PenaltyDTO penaltyEntityToPenaltyDTO(Penalty penalty){

        PenaltyDTO penaltyDTO = new PenaltyDTO();

        penaltyDTO.setDescription(penalty.getDescription());
        penaltyDTO.setPenaltyAmount(penalty.getPenaltyAmount());
        penaltyDTO.setPenaltyId(penalty.getPenaltyId());

        return penaltyDTO;
    }

}
