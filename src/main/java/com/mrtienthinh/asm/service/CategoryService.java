package com.mrtienthinh.asm.service;

import com.mrtienthinh.asm.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity createCategory(CategoryEntity category);
    CategoryEntity updateCategory(CategoryEntity category);
    void deleteCategory(int id);
    List<CategoryEntity> getAllCategory();
    CategoryEntity getCategoryByID(int id);
    List<CategoryEntity> getCategoryByName(String name);
}
