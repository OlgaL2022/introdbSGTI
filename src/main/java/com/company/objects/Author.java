package com.company.objects;

public class Author {
    private int bookid;
    private String name;
    private int age;

    public Author(int bookid, String name, int age) {
        this.bookid = bookid;
        this.name = name;
        this.age = age;
    }

    public Author() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

