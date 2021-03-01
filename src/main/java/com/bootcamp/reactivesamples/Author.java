package com.bootcamp.reactivesamples;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private Integer id;
    private String name;
    private List<Book> books;
    private Integer birthYear;

    public Author() {
    }

    public Author(Integer id, String name, Integer birthYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public void addBook(Integer id, String title, Integer year) {
        if (this.books == null) {
            this.books = new ArrayList<>();
        }
        this.books.add(new Book(id, title, year));
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                ", birthYear=" + birthYear +
                '}';
    }
}
