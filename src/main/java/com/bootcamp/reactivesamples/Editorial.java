package com.bootcamp.reactivesamples;

public class Editorial {
    private String name;

    public Editorial() {
    }

    public Editorial(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "name='" + name + '\'' +
                '}';
    }
}
