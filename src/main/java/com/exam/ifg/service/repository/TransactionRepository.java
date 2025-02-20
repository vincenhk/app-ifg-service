package com.exam.ifg.service.repository;

import com.exam.ifg.service.model.Transactions;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionRepository implements PanacheRepository<Transactions> {
}
