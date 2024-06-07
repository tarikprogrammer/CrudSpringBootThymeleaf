package com.tarik.crud_product.Dao;

import com.tarik.crud_product.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JpaDao extends JpaRepository<Product,Long> {
    Page<Product>findByDesignationContains(String mc, Pageable pageable);
}
