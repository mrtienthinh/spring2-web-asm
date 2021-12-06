package com.mrtienthinh.asm.repository;

import com.mrtienthinh.asm.entity.CategoryEntity;
import com.mrtienthinh.asm.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findAllByName(String name);

    @Query("select c from CategoryEntity c where c.name like %:name%")
    List<CategoryEntity> findNameCustom(String name);
}
