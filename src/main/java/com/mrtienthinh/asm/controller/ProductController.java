package com.mrtienthinh.asm.controller;

import com.mrtienthinh.asm.entity.ProductEntity;
import com.mrtienthinh.asm.model.BaseResponse;
import com.mrtienthinh.asm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public BaseResponse getProduct(@RequestParam Map<String, String> params) {
        BaseResponse res = new BaseResponse();
        String id = params.get("id");
        String name = params.get("name");
        if (id != null) {
            res.data = productService.getProductByID(Integer.parseInt(id));
        } else if (name != null) {
            res.data = productService.getProductByName(name);
        } else {
            res.data = productService.getAllProduct();
        }
        return res;
    }

    @PostMapping
    public BaseResponse createProduct(@RequestBody ProductEntity product) {
        BaseResponse res = new BaseResponse();
        res.data = productService.createProduct(product);
        return res;
    }

    @PutMapping
    public BaseResponse putProduct(@RequestBody ProductEntity product) {
        BaseResponse res = new BaseResponse();
        res.data = productService.updateProduct(product);
        return res;
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteProduct(@PathVariable int id) {
        BaseResponse res = new BaseResponse();
        productService.deleteProduct(id);
        return res;
    }

}

