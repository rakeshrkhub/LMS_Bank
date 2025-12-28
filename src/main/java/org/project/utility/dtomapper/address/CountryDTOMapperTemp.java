package org.project.utility.dtomapper.address;

import org.project.dto.CountryDTO;
import org.project.entity.temporary.CountryTemp;

public interface CountryDTOMapperTemp {

    CountryTemp dtoToCountryTemp(CountryDTO countryDTO);
    CountryDTO countryTempToDto(CountryTemp country);

}