package com.mrtienthinh.asm.dto;

import com.mrtienthinh.asm.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;

    public CategoryEntity toEntity() {
        return new CategoryEntity(id, name);
    }
}
