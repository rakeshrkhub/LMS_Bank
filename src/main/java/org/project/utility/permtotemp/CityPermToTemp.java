package org.project.utility.permtotemp;

import org.project.entity.permanent.City;
import org.project.entity.temporary.CityTemp;

public interface CityPermToTemp {
    CityTemp permToTemp(City city);
}
