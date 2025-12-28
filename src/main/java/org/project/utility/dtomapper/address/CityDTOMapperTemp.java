package org.project.utility.dtomapper.address;

import org.project.dto.CityDTO;
import org.project.entity.temporary.CityTemp;

public interface CityDTOMapperTemp {
    CityTemp dtoToCityTemp(CityDTO cityDTO);
    CityDTO cityTempToCityDto(CityTemp cityTemp);
}
