package com.example.lab_191026.service;

import com.example.lab_191026.model.enumeration.Category;
import com.example.lab_191026.service.interfaces.CategoryServiceI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceI {

    @Override
    public List<Category> listAll() {
        return List.of(Category.values());
    }
}
