package com.example.bai_tap.repository;

import com.example.bai_tap.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    boolean addProduct(Product product);

    boolean updateProduct(int index, Product product);

    boolean deleteProduct(int index);
}
