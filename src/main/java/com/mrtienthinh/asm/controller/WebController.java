package com.mrtienthinh.asm.controller;

import com.mrtienthinh.asm.dto.CategoryDto;
import com.mrtienthinh.asm.dto.ProductDto;
import com.mrtienthinh.asm.entity.CategoryEntity;
import com.mrtienthinh.asm.entity.ProductEntity;
import com.mrtienthinh.asm.service.CategoryService;
import com.mrtienthinh.asm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class WebController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index() {
        if (httpSession.getAttribute("isLogin") == null) {
            return "redirect:login";
        }
        return "index";
    }

    @GetMapping("/category")
    public String indexCategory(Model model) {
        if (httpSession.getAttribute("isLogin") == null) {
            return "redirect:login";
        }
        model.addAttribute("categories", categoryService.getAllCategory());
        return "category";
    }

    @GetMapping("/product")
    public String indexProduct(Model model) {
        if (httpSession.getAttribute("isLogin") == null) {
            return "redirect:login";
        }
        model.addAttribute("products", productService.getAllProduct());
        return "product";
    }

    @GetMapping("/createCategory")
    public String createCategory(Model model) {
        if (httpSession.getAttribute("isLogin") == null) {
            return "redirect:login";
        }
        model.addAttribute("category", new CategoryEntity());
        return "create_or_edit_category";
    }

    @GetMapping("/createProduct")
    public String createProduct(Model model) {
        if (httpSession.getAttribute("isLogin") == null) {
            return "redirect:login";
        }
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "create_or_edit_product";
    }

    @GetMapping("/editCategory/{id}")
    public String editCategory(Model model, @PathVariable int id) {
        if (httpSession.getAttribute("isLogin") == null) {
            return "redirect:login";
        }
        model.addAttribute("category", categoryService.getCategoryByID(id));
        return "create_or_edit_category";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(Model model, @PathVariable int id) {
        if (httpSession.getAttribute("isLogin") == null) {
            return "redirect:login";
        }
        model.addAttribute("product", productService.getProductByID(id));
        model.addAttribute("categories", categoryService.getAllCategory());
        return "create_or_edit_product";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam Map<String, String> params) {
        if (httpSession.getAttribute("isLogin") != null) {
            return "redirect:index";
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginDoing(Model model, @RequestParam Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        if (username == null || password == null) {
            return "redirect:/login";
        }
        if (!username.equals("admin") || !password.equals("admin")) {
            return "redirect:/login";
        }
        httpSession.setAttribute("isLogin", true);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        httpSession.removeAttribute("isLogin");
        return "redirect:login";
    }
}
