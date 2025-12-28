package org.project.utility.temptoperm;

import org.project.entity.permanent.Country;
import org.project.entity.temporary.CountryTemp;

public interface CountryTempToPerm {
    Country tempToPerm(CountryTemp countryTemp);
}
