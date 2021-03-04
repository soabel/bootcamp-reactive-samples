package com.bootcamp.reactivesamples;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Integer id ;
    private String title;
    private Integer year;

    private List<Editorial> editorials;


    public Book() {
    }

    public Book(Integer id, String title, Integer year) {
        this.id = id;
        this.title = title;
        this.year = year;

        this.editorials = new ArrayList<>();
        this.editorials.add(new Editorial("Planeta"));
        this.editorials.add(new Editorial("Santillana"));

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Editorial> getEditorials() {
        return editorials;
    }

    public void setEditorials(List<Editorial> editorials) {
        this.editorials = editorials;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
