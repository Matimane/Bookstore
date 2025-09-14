package com.example.bookstore.web;

import com.example.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }
}
