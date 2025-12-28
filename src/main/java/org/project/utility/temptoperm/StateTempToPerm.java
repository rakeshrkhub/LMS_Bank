package org.project.utility.temptoperm;

import org.project.entity.permanent.State;
import org.project.entity.temporary.StateTemp;

public interface StateTempToPerm{
    State stateTempToStatePerm(StateTemp stateTemp);
}
