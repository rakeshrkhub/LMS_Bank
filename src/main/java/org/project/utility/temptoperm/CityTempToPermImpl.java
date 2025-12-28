package org.project.utility.temptoperm;

import org.project.entity.permanent.City;
import org.project.entity.temporary.CityTemp;
import org.project.utility.dtomapper.MetaDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityTempToPermImpl implements CityTempToPerm {

    @Autowired
    private StateTempToPerm stateTempToPerm;

    @Override
    public City tempToPerm(CityTemp cityTemp) {
        City city = new City();
        city.setCityCode(cityTemp.getCityCode());
        city.setCityName(cityTemp.getCityName());
        city.setCityMICRCode(cityTemp.getCityMICRCode());
        city.setId(cityTemp.getCityId());
        city.setLocationType(cityTemp.getLocationType());
        city.setMetaData(MetaDataMapper.tempToMetaData(cityTemp.getMetaData()));
        city.setStdCode(cityTemp.getStdCode());
        city.setStdCode(cityTemp.getStdCode());
        /*city.setState(stateTempToPerm.stateTempToStatePerm(cityTemp.getState()));*/
        return city;
    }
}
