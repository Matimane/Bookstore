package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

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
}
