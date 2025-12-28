package org.project.utility.dtomapper.address;

import org.project.dto.CountryDTO;
import org.project.entity.permanent.Country;

public interface CountryDTOMapper {
    Country dtoToCountry(CountryDTO countryDTO);
    CountryDTO countryToDto(Country country);
}
