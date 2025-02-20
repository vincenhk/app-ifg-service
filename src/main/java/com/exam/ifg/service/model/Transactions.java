package com.exam.ifg.service.model;

import com.exam.ifg.service.common.Constant;
import com.exam.ifg.service.enums.CurrencyType;
import com.exam.ifg.service.enums.TransactionDirection;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "MST_TRANSACTIONS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "code", nullable = false)
    private String trxCode;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private CurrencyType currency;

    @Column(name = "transaction_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FULL_DATE)
    private Timestamp transactionTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_direction", length = 10, nullable = false)
    private TransactionDirection transactionDirection;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionsDtl> transactionDetails;
}
