package org.project.utility.dtomapper.address;


import org.project.dto.CityDTO;
import org.project.entity.temporary.CityTemp;

import java.util.List;

public interface CityMapper {
    CityTemp cityDtoToCityEntity(CityDTO cityDTO);
    CityDTO cityEntityToCityDto(CityTemp city);
    List<CityDTO> convertCityListToDTOList(List<CityTemp> cityTemp);

}
