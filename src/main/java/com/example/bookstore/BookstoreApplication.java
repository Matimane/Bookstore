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
	public CommandLineRunner categoryTest(CategoryRepository categoryRepository, BookRepository repository) {
		return (args) -> {
			Category scifi = new Category("Scifi");
			Category sarjakuva = new Category("Sarjakuva");
			Category c3 = new Category("Fantasia");
			Category c4 = new Category("Historia");
			categoryRepository.save(scifi);
			categoryRepository.save(sarjakuva);
			categoryRepository.save(c3);
			categoryRepository.save(c4);
			categoryRepository.findAll().forEach(cat -> System.out.println(cat.getName()));

			Book b = new Book("Wautsi", "Meitsi", 2025, "123456", 200.00, sarjakuva);
			Book b2 = new Book("Mautsi", "Weitsi", 2502, "654321", 3200.00, scifi);

			repository.save(b);
			repository.save(b2);

		};
	}
}
