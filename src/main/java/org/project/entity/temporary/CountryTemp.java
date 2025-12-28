package org.project.entity.temporary;

import lombok.Data;
import org.project.entity.meta.TempMetaData;

import javax.persistence.*;

@Data
@Entity
@Table(name = "COUNTRY_TEMP_TBL_BATCH_6")
@TableGenerator(name="ID_TEMP_TABLE_GEN_BATCH_6",pkColumnValue = "COUNTRY_TEMP_TBL_BATCH_6",initialValue=100000, allocationSize=1)
public class CountryTemp {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="ID_TEMP_TABLE_GEN_BATCH_6")
    private Integer id;
    private String countryGroup;
    private String countryName;
    private Integer countryIsdCode;
    private String countryIsoCode;
    private String nationality;
    private String region;
    private String status;
    @Embedded
    private TempMetaData metaData;

    public CountryTemp(){
        metaData = new TempMetaData();
    }
}