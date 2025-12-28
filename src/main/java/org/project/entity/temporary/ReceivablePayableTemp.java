package org.project.entity.temporary;

import lombok.Data;
import org.project.entity.meta.TempMetaData;
import org.project.entity.permanent.LoanAccount;
import org.project.utility.enums.Currency;
import org.project.utility.enums.ReceivablePayableStatus;
import org.project.utility.enums.ReceivablePayableType;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "RECEIVABLE_PAYABLE_TEMP_TBL_BATCH_6")
@TableGenerator(name="ID_TEMP_TABLE_GEN_BATCH_6",pkColumnValue = "RECEIVABLE_PAYABLE_TEMP_TBL_BATCH_6",initialValue=100000, allocationSize=1)
public class ReceivablePayableTemp {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="ID_TEMP_TABLE_GEN_BATCH_6")
    private Long receivablePayableId;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private ReceivablePayableType receivablePayableType;

    private Date receivablePayableDueDate;

    @ManyToOne
    @JoinColumn(name = "loanAccountId")
    private LoanAccount loanAccount;

    private Double receivablePayableAmount;
    private Double principalComponent;
    private Double principalComponentReceived;
    private Double interestComponent;
    private Double interestComponentReceived;
    private Date receivablePayableDate;

    @Enumerated(EnumType.STRING)
    private ReceivablePayableStatus receivablePayableStatus;

    private Double penalty;

    @Embedded
    private TempMetaData metaData;
}
