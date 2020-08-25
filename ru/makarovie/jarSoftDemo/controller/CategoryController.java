package ru.makarovie.jarSoftDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.makarovie.jarSoftDemo.exception.NoContentException;
import ru.makarovie.jarSoftDemo.model.Category;
import ru.makarovie.jarSoftDemo.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAllCategories (){
        return categoryRepository.findAll().stream()
                .filter(category -> !category.isDeleted())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
        Category category = getCategory(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id,
                                               @RequestBody Category categoryData) {
        Category category = getCategory(id);

        category.setName(categoryData.getName());
        category.setReqName(categoryData.getReqName());
        category.setDeleted(categoryData.isDeleted());

        Category updateCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updateCategory);
    }

    private Category getCategory(long id) {
        Category category = null;
        try {
            category = categoryRepository.findById(id).orElseThrow(() ->
                    new NoContentException("Category with id: " + id + " not exist"));
        } catch (NoContentException e) {
            e.printStackTrace();
        }
        return category;
    }
}
