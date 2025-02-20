package com.exam.ifg.service.repository;

import com.exam.ifg.service.model.TransactionsDtl;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionDtlRepository implements PanacheRepository<TransactionsDtl> {
}
