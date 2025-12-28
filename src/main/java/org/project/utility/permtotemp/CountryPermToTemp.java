package org.project.utility.permtotemp;

import org.project.entity.permanent.Country;
import org.project.entity.temporary.CountryTemp;

public interface CountryPermToTemp {
    CountryTemp permToTemp(Country country);
}
