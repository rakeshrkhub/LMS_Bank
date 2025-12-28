package org.project.entity.temporary;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.project.entity.meta.TempMetaData;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ELIGIBILITY_POLICY_TEMP_TBL_BATCH_6")
@TableGenerator(name="ID_TEMP_TABLE_GEN_BATCH_6",pkColumnValue = "ELIGIBILITY_POLICY_TEMP_TBL_BATCH_6",initialValue=100000, allocationSize=1)
public class EligibilityPolicyTemp {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="ID_TEMP_TABLE_GEN_BATCH_6")
    private Long eligibilityPolicyId;
//    @Column(unique = true)
    private String eligibilityPolicyCode;
    private String eligibilityPolicyName;
    private String eligibilityCriteria;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "eligibilityPolicyId")
    private List<EligibilityPolicyParameterTemp> eligibilityParameterMappingList;
    @Embedded
    private TempMetaData metaData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EligibilityPolicyTemp that = (EligibilityPolicyTemp) o;
        return eligibilityPolicyCode.equalsIgnoreCase(that.eligibilityPolicyCode);
    }
}