package com.mrtienthinh.asm.repository;

import com.mrtienthinh.asm.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByName(String name);

    @Query("select p from ProductEntity p where p.name like %:name%")
    List<ProductEntity> findNameCustom(String name);
}