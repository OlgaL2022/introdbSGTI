package com.company.objects;

// Create the same class in your code and add the following fields: id(int), name(String), price(float).
// In your main method, create a List of books and return books that are more expensive than $5.

public class Book {

    private int id;
    private String name;
    private float price;

    public Book(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    /*@Override public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';*/
    }


