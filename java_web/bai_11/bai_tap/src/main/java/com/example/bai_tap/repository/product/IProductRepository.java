package com.example.bai_tap.repository.product;

import com.example.bai_tap.dto.ProductDto;
import com.example.bai_tap.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<ProductDto> findAll();

    List<ProductDto> findByCategoryId(int categoryId);

    List<ProductDto> findByPage(int page, int pageSize);

    int getTotalProducts();

    List<ProductDto> searchByName(String name);

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);
}
