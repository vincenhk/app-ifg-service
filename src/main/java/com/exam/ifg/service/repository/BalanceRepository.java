package com.exam.ifg.service.repository;

import com.exam.ifg.service.model.Balance;
import com.exam.ifg.service.model.Users;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BalanceRepository implements PanacheRepository<Balance> {
    public Balance findByUser(Users user) {
        return find("user", user).firstResult();
    }
}
