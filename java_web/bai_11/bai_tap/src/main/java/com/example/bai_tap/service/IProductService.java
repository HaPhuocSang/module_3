package com.example.bai_tap.service;

import com.example.bai_tap.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);

    List<Product> findProductByName(String name);

    Product getProduct(int id);
}
