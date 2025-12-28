package org.project.utility.temptoperm;

import org.project.entity.permanent.City;
import org.project.entity.temporary.CityTemp;

public interface CityTempToPerm {
    City tempToPerm(CityTemp cityTemp);
}
