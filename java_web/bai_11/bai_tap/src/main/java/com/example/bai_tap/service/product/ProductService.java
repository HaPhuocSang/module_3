package com.example.bai_tap.service.product;

import com.example.bai_tap.dto.ProductDto;
import com.example.bai_tap.entity.Product;
import com.example.bai_tap.repository.product.IProductRepository;
import com.example.bai_tap.repository.product.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDto> findByCategoryId(int categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<ProductDto> findByPage(int page, int pageSize) {
        return productRepository.findByPage(page, pageSize);
    }

    @Override
    public int getTotalProducts() {
        return productRepository.getTotalProducts();
    }

    @Override
    public boolean addProduct(Product product) {
        if (checkNameProduct(product.getName())) {
            return false;
        }
        return productRepository.addProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public List<ProductDto> findProductByName(String name) {
        return productRepository.searchByName(name);
    }

    public boolean checkNameProduct(String name) {
        List<ProductDto> products = productRepository.findAll();
        for (ProductDto product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ProductDto getProduct(int id) {
        List<ProductDto> products = productRepository.findAll();
        for (ProductDto productDto : products) {
            if (productDto.getId() == id) {
                return productDto;
            }
        }
        return null;
    }
}
