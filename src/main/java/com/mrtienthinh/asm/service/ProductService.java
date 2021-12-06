package com.mrtienthinh.asm.service;

import com.mrtienthinh.asm.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity createProduct(ProductEntity product);
    ProductEntity updateProduct(ProductEntity product);
    void deleteProduct(int id);
    List<ProductEntity> getAllProduct();
    ProductEntity getProductByID(int id);
    List<ProductEntity> getProductByName(String name);
}