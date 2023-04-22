package com.example.lab_191026.controller;

import com.example.lab_191026.model.Author;
import com.example.lab_191026.model.enumeration.Category;
import com.example.lab_191026.service.interfaces.CategoryServiceI;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryServiceI categoryService;

    public CategoryController(CategoryServiceI categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> findAll() {
        return this.categoryService.listAll();
    }
}
