package com.hxy.pojo;

public class Books {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private float bookPrice;
    private String details;

    public Books() {
    }

    public Books(String bookName, int bookCounts, float bookPrice, String details) {
        this.bookName = bookName;
        this.bookCounts = bookCounts;
        this.bookPrice = bookPrice;
        this.details = details;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(int bookCounts) {
        this.bookCounts = bookCounts;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
