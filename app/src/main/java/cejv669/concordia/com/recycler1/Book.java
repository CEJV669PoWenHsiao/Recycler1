package cejv669.concordia.com.recycler1;

import android.content.Intent;

public class Book {

   private String Name;
   private Integer Pages, ISBN;
   private boolean isLent;

    public Book(String name, Integer pages, Integer ISBN, boolean isLent) {
        Name = name;
        Pages = pages;
        this.ISBN = ISBN;
        this.isLent = isLent;
    }

    public String getName() {
        return Name;
    }

    public Integer getPages() {
        return Pages;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public boolean isLent() {
        return isLent;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPages(Integer pages) {
        Pages = pages;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public void setLent(boolean lent) {
        isLent = lent;
    }


}
