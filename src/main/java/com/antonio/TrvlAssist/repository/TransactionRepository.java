package com.antonio.TrvlAssist.repository;

import com.antonio.TrvlAssist.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction getById(Long id);


    List<Transaction> findAll();

    @Modifying
    @Query("delete from Transaction t where t.product.id = ?1")
    void deleteProductsShoppingCart(Long id);
}
