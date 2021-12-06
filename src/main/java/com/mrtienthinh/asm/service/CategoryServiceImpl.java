package com.mrtienthinh.asm.service;

import com.mrtienthinh.asm.entity.CategoryEntity;
import com.mrtienthinh.asm.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryEntity createCategory(CategoryEntity category) {
        CategoryEntity categoryEntity = categoryRepo.save(category);
        return categoryEntity;
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity category) {
        CategoryEntity categoryEntity = getCategoryByID(category.getId());
        categoryEntity.setName(category.getName());
        categoryRepo.save(categoryEntity);
        return categoryEntity;
    }

    @Override
    public void deleteCategory(int id) {
        CategoryEntity categoryEntity = getCategoryByID(id);
        categoryRepo.delete(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public CategoryEntity getCategoryByID(int id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public List<CategoryEntity> getCategoryByName(String name) {
        return categoryRepo.findNameCustom(name);
    }

}

