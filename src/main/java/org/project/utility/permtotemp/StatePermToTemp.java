package org.project.utility.permtotemp;

import org.project.entity.permanent.State;
import org.project.entity.temporary.StateTemp;

public interface StatePermToTemp {
    StateTemp statePermToStateTemp(State state);
}
