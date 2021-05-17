package com.antonio.TrvlAssist.repository;


import com.antonio.TrvlAssist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getById(Long existingProductID);


}
