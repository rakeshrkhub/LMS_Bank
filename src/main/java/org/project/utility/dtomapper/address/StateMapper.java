package org.project.utility.dtomapper.address;

import org.project.dto.StateDTO;
import org.project.entity.permanent.State;
import org.project.entity.temporary.StateTemp;

import java.util.List;

public interface StateMapper {

    StateTemp stateDtoToStateEntity(StateDTO stateDTO);
    StateDTO stateEntityToStateDto(StateTemp state);

    State stateDtoToStatePermanent(StateDTO stateDTO);
    StateDTO statePermanentToStateDto(State state);
    List<StateDTO> convertStateTempListToDTOList(List<StateTemp> stateTempList);

    List<StateDTO> convertStateListToDTOList(List<State> stateAllList);
    List<StateDTO> convertTempStateListToDTOList(List<StateTemp> stateAllList);
}
