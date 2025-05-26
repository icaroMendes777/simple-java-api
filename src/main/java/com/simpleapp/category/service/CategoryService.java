package com.simpleapp.category.service;

import org.springframework.stereotype.Service;

import com.simpleapp.category.model.Category;
import com.simpleapp.category.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public void saveAll(List<Category> categorys) {
        categoryRepository.saveAll(categorys);
    }

    public Category update(Long id, Category newCategory) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    return categoryRepository.save(category);
                })
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
