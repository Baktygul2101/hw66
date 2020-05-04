package com.myshop.online.repository;



import com.myshop.online.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findAllById(int id);
    Product findByName(String name);
    @Query("select p from Product as p where p.name like CONCAT(:name, '%')")
    public List<Product> getByName(String name);
}
