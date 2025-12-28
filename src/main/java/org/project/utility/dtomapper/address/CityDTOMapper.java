package org.project.utility.dtomapper.address;

import org.project.dto.CityDTO;
import org.project.entity.permanent.City;
import org.springframework.stereotype.Component;

@Component
public interface CityDTOMapper {
    City dtoToCity(CityDTO cityDTO);
    CityDTO cityToDto(City city);
}
