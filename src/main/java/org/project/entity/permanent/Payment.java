package org.project.entity.permanent;

import lombok.Data;
import org.project.entity.meta.MetaData;
import org.project.utility.enums.Currency;
import org.project.utility.enums.PaymentMode;
import org.project.utility.enums.ReceiptStatus;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "PAYMENT_TBL_BATCH_6")
@TableGenerator(name="ID_TABLE_GEN_BATCH_6",pkColumnValue = "PAYMENT_TBL_BATCH_6",initialValue=100000, allocationSize=1)
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator="ID_TABLE_GEN_BATCH_6")
    private Long receiptId;

    private String payeeName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "receivablePayableId")
    private ReceivablePayable receivablePayable;

    private double paymentAmount;

    @Enumerated(EnumType.STRING)
    private Currency paymentCurrency;

    private String loanAccountNumber;
    private Date paymentDate;
    private String payoutBankAccount;

    @Enumerated(EnumType.STRING)
    private ReceiptStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Embedded
    private MetaData metaData;
    private String paidTo;
}
