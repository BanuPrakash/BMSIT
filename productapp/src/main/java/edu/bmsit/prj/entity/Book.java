package edu.bmsit.prj.entity;

import edu.bmsit.prj.annotation.Column;
import edu.bmsit.prj.annotation.Table;

@Table(name="BOOK_TABLE")
public class Book {
    private String isbn;
    private double price;
    private String category;

    @Column(name="BOOK_ISBN")
    public String getIsbn() {
        return isbn;
    }

    @Column(name="AMT", type = "NUMERIC(12,2)")
    public double getPrice() {
        return price;
    }

    @Column(name="CAT", type="VARCHAR(100)")
    public String getCategory() {
        return category;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
