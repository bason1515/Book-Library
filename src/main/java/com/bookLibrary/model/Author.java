package com.bookLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonAutoDetect(fieldVisibility = Visibility.NONE)

public class Author implements Comparable<Author> {
    private String author;
    private double averageRating;
    @JsonIgnore
    private int ratingCount;

    public Author(String author, double averageRating, int ratingCount) {
        this.author = author;
        this.averageRating = averageRating;
        this.ratingCount = ratingCount;
    }

    public void calculateAverage(double rating, int weigh) {
        double currAvg = averageRating * ratingCount;
        double addAvg = rating * weigh;
        ratingCount += weigh;
        averageRating = (currAvg + addAvg) / ratingCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public boolean equals(Object v) {
        boolean result = false;
        if (v instanceof String) {
            result = this.author.equals((String) v);
        }
        if (v instanceof Author) {
            Author ptr = (Author) v;
            result = this.author.equals(ptr.getAuthor());
        }
        return result;
    }

    @Override
    public int compareTo(Author a) {
        if (averageRating < a.getAverageRating())
            return 1;
        else if (a.getAverageRating() < averageRating)
            return -1;
        return 0;
    }

}
