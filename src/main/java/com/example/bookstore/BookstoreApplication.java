package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner testi(BookRepository repository) {
		return (args) -> {
			Book b = new Book("Wautsi", "Meitsi", 2025, "123456", 200.00);
			Book b2 = new Book("Mautsi", "Weitsi", 2502, "654321", 3200.00);

			repository.save(b);
			repository.save(b2);
		};
	}

	@Bean
	public CommandLineRunner categoryTest(CategoryRepository categoryRepository) {
		return (args) -> {
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Sarjakuva");
			Category c3 = new Category("Fantasia");
			Category c4 = new Category("Historia");
			categoryRepository.save(c1);
			categoryRepository.save(c2);
			categoryRepository.save(c3);
			categoryRepository.save(c4);
			categoryRepository.findAll().forEach(cat -> System.out.println(cat.getName()));

		};
	}
}
