package com.antonio.TrvlAssist.repository;

import com.antonio.TrvlAssist.model.Purchase;
import com.antonio.TrvlAssist.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
        Purchase getById(Long id);
        List<Purchase> findAll();
}

