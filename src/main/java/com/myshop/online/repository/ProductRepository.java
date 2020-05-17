package com.myshop.online.repository;


import com.myshop.online.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findAllById(int id);
    Product findByName(String name);
    @Query("select p from Product as p where p.name like CONCAT(:name, '%')")
    List<Product> getByName(String name);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByName(String name, Pageable pageable);
    List<Product> findAllByNameIgnoreCase(String name);

    @Query(value = "SELECT c FROM Product c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.price LIKE '%' || :keyword || '%'"
            + " OR c.category LIKE '%' || :keyword || '%'")
    public List<Product> search(@Param("keyword") String keyword);


    //
    Page<Product> findAllByCategoryId(int categoryId, Pageable pageable);


}
