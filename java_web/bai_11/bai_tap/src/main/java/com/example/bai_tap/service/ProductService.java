package com.example.bai_tap.service;

import com.example.bai_tap.entity.Product;
import com.example.bai_tap.repository.IProductRepository;
import com.example.bai_tap.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean addProduct(Product product) {
        if (checkIdProduct(product.getId())) {
            return false;
        }
        return productRepository.addProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        int index = findIndexProductList(product.getId());
        if (index == -1) {
            return false;
        }
        return productRepository.updateProduct(index, product);
    }

    @Override
    public boolean deleteProduct(int id) {
        int index = findIndexProductList(id);
        if (index == -1) {
            return false;
        }
        return productRepository.deleteProduct(index);
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> products =new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                products.add(product);
            }
        }
        return products;
    }

    public boolean checkIdProduct(int id) {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int findIndexProductList(int id) {
        List<Product> products = productRepository.findAll();
        for (int i = 0; i < products.size(); i++) {
            if (id == productRepository.findAll().get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Product getProduct(int id) {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
