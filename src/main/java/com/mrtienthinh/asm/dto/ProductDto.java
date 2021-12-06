package com.mrtienthinh.asm.dto;

import com.mrtienthinh.asm.entity.CategoryEntity;
import com.mrtienthinh.asm.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private Integer categoryId;
    private String name;
    private Integer price;
    private Integer quantity;

    public ProductEntity toEntity() {
        return new ProductEntity(id, categoryId, name, price, quantity);
    }
}
