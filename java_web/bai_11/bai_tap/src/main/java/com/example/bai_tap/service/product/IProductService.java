package com.example.bai_tap.service.product;

import com.example.bai_tap.dto.ProductDto;
import com.example.bai_tap.entity.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> findAll();

    List<ProductDto> findByCategoryId(int categoryId);

    List<ProductDto> findByPage(int page, int pageSize);

    int getTotalProducts();

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);

    List<ProductDto> findProductByName(String name);

    ProductDto getProduct(int id);
}
