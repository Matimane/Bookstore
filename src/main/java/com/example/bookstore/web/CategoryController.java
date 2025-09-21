package com.example.bookstore.web;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

  private final CategoryRepository categoryRepository;

  public CategoryController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @GetMapping("/categorylist")
  public String showCategoryList(Model model) {
    Iterable<Category> categories = categoryRepository.findAll();
    model.addAttribute("categories", categories);
    return "categorylist";
  }

  @GetMapping("/addcategory")
  public String addCategoryForm(Model model) {
    model.addAttribute("category", new Category());
    return "addcategory";
  }

  @PostMapping("/savecategory")
  public String saveCategory(@ModelAttribute Category category) {
    categoryRepository.save(category);
    return "redirect:/categorylist";
  }

}
