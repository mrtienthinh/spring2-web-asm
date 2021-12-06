package com.mrtienthinh.asm.controller;

import com.mrtienthinh.asm.entity.CategoryEntity;
import com.mrtienthinh.asm.model.BaseResponse;
import com.mrtienthinh.asm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public BaseResponse getCategory(@RequestParam Map<String, String> params) {
        BaseResponse res = new BaseResponse();
        String id = params.get("id");
        String name = params.get("name");
        if (id != null) {
            res.data = categoryService.getCategoryByID(Integer.parseInt(id));
        } else if (name != null) {
            res.data = categoryService.getCategoryByName(name);
        } else {
            res.data = categoryService.getAllCategory();
        }
        return res;
    }

    @PostMapping
    public BaseResponse createCategory(@RequestBody CategoryEntity category) {
        BaseResponse res = new BaseResponse();
        res.data = categoryService.createCategory(category);
        return res;
    }

    @PutMapping
    public BaseResponse putCategory(@RequestBody CategoryEntity category) {
        BaseResponse res = new BaseResponse();
        res.data = categoryService.updateCategory(category);
        return res;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteCategory(@PathVariable int id) {
        BaseResponse res = new BaseResponse();
        try {
            categoryService.deleteCategory(id);
        }catch (Exception ex) {
            res.message= "Can't delete category! Please delete all product of this category";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}

