package cejv669.concordia.com.recycler1;

import android.content.Intent;

public class Book {

    private String Name;
    private Integer Pages, ISBN;
    private boolean isLent;

    //Database Description Fields

    public static final String TABLE_NAME = "books";
    public static final String COLUMN_ISBN = "isbn";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PAGES = "pages";
    public static final String COLUMN_LENT = "lent";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME
                    + "(" + COLUMN_ISBN + " INTEGER PRIMARY KEY,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_PAGES + " INTEGER,"
                    + COLUMN_LENT + " INTEGER"
                    + ")";


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
