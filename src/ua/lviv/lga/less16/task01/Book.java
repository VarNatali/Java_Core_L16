package ua.lviv.lga.less16.task01;

import java.io.Serializable;
import java.util.SequencedCollection;

public class Book extends Publication implements Serializable {
    public String name;
    public int year;
    private String autor;
    private int isbn;

    public Book() {
    }

    public Book(String name, int year) {
        super();
        this.name = name;
        this.year = year;
    }

    public Book(String name, int year, String autor, int isbn) {
        super();
        this.name = name;
        this.year = year;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return year;
    }

    public String getAutor() {
        return autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int year) {
        this.year = year;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void orderBook(String nameOrder, int nummerOrder) {
        System.out.println("Book is ordered by: " + nameOrder + ", numer of order is:" + nummerOrder);

    }

    public void addNumberCopies(int addNum) {
        System.out.println("Now number of copies is: " + addNum);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", age=" + year +
                ", autor='" + autor + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
