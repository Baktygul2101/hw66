package com.myshop.online.service;


import com.myshop.online.dto.ProductDTO;
import com.myshop.online.exception.ResourceNotFoundException;
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

    public Page<ProductDTO> getProducts(Pageable pageable) {
        return repository.findAll(pageable)
                .map(ProductDTO::from);
        //.toList();
    }

    public ProductDTO getProduct(int id) {
        var product = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return ProductDTO.from(product);
    }


    public Product getProductsById(int id){
        return repository.findAllById(id).orElse(null);
    }

    public Product getProductById(int id) {
        return repository.findById(id).get();
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
}
