package com.myshop.online.service;


import com.myshop.online.dto.ProductDTO;
import com.myshop.online.model.Product;
import com.myshop.online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }



    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findAllById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }


    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed!!"+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

    //
    public Page<ProductDTO> findAllByCategoryId(int id, Pageable pageable){
        return repository.findAllByCategoryId(id, pageable).map(ProductDTO::from);
    }


}