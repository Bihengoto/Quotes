package com.mahugu.quotes.models;

public class Quotes {
    private int id;
    private String author;
    private String quote;
    private String permalink;


    public Quotes(int id, String author, String quote, String permalink) {
        this.id = id;
        this.author = author;
        this.quote = quote;
        this.permalink = permalink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }
}
