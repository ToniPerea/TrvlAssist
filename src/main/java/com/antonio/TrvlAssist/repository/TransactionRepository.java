package com.antonio.TrvlAssist.repository;

import com.antonio.TrvlAssist.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction getById(Long id);
}
