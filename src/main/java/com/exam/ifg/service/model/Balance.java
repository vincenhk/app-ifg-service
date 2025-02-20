package com.exam.ifg.service.model;

import com.exam.ifg.service.common.Constant;
import com.exam.ifg.service.enums.CurrencyType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "MST_BALANCE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private Users user;

    @Column(name = "balance_amount", nullable = false)
    private BigDecimal balanceAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private CurrencyType currency;

    @Column(name = "last_updated", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FULL_DATE)
    private Timestamp lastUpdated;
}
