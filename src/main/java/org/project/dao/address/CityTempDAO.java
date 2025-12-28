package org.project.dao.address;


import org.project.dto.CityDTO;

import java.util.List;

public interface CityTempDAO {
    boolean saveCity(CityDTO city);
    boolean updateCity(CityDTO cityDTO);
    boolean deleteCity(Integer id);
    CityDTO getCityById(Integer id);
    List<CityDTO> getAllCities();
    List<CityDTO> getPendingCities();
    CityDTO getCityWithSaveFlag();
    CityDTO getCityByName(String cityName);

}
