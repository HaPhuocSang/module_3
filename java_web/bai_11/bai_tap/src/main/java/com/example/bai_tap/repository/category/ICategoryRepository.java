package com.example.bai_tap.repository.category;

import com.example.bai_tap.entity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
