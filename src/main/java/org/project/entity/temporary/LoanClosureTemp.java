package org.project.entity.temporary;

import lombok.Data;
import org.project.entity.meta.TempMetaData;
import org.project.entity.permanent.LoanAccount;
import org.project.utility.enums.ClosureStatus;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "LOAN_CLOSURE_TEMP_TBL_BATCH_6")
@TableGenerator(name="ID_TEMP_TABLE_GEN_BATCH_6",pkColumnValue = "LOAN_CLOSURE_TEMP_TBL_BATCH_6",initialValue=100000, allocationSize=1)
public class LoanClosureTemp {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="ID_TEMP_TABLE_GEN_BATCH_6")
    private Long loanClosureId;
    private Date loanClosureDate;
    @Enumerated(EnumType.STRING)
    private ClosureStatus closureStatus;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loanId")
    private LoanAccount loanAccount;
    @Embedded
    private TempMetaData metaData;
}