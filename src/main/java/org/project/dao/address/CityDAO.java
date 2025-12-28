package org.project.dao.address;

import org.project.dto.CityDTO;

import java.util.List;

public interface CityDAO {
    boolean saveCity(CityDTO cityDTO);
    boolean updateCity(CityDTO cityDTO);
    boolean deleteCity(Integer id);
    CityDTO getCityById(Integer id);
    List<CityDTO> getAllCities();

    List<CityDTO> getCityWithApprovedStatus();

    List<CityDTO> getCityByStateName(String stateName);

    CityDTO getCityByCityName(String cityName);
}
