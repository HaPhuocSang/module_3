package com.example.bai_tap.service.category;

import com.example.bai_tap.entity.Category;
import com.example.bai_tap.repository.category.CategoryRepository;
import com.example.bai_tap.repository.category.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
