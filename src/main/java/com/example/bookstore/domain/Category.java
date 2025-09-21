package com.example.bookstore.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
  @OneToMany(mappedBy = "category")
  private List<Book> books;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long categoryid;

  private String name;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  public Long getCategoryid() {
    return categoryid;
  }

  public void setCategoryid(Long categoryid) {
    this.categoryid = categoryid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
