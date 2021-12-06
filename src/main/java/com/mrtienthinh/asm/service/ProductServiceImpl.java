package com.mrtienthinh.asm.service;

import com.mrtienthinh.asm.entity.ProductEntity;
import com.mrtienthinh.asm.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        ProductEntity productEntity = productRepo.save(product);
        return productEntity;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        ProductEntity productEntity = getProductByID(product.getId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setCategoryId(product.getCategoryId());
        productRepo.save(productEntity);
        return productEntity;
    }

    @Override
    public void deleteProduct(int id) {
        ProductEntity productEntity = getProductByID(id);
        productRepo.delete(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity getProductByID(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<ProductEntity> getProductByName(String name) {
        return productRepo.findNameCustom(name);
    }

}

