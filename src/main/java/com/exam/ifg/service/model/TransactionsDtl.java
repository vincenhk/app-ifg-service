package com.exam.ifg.service.model;

import com.exam.ifg.service.enums.StatusTransaction;
import com.exam.ifg.service.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MST_TRANSACTIONS_DTL")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsDtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transactions transaction;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", length = 20, nullable = false)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private StatusTransaction status;

    @Column(name = "description", length = 255)
    private String description;
}
