package com.bookLibrary.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.NONE)

public class Author {
    private String author;
    private double averageRating;
    private int ratingCount;
    
    public void calculateAverage(double rating, int wage) {
        double currAvg = averageRating*ratingCount;
        double addAvg = rating*wage;
        ratingCount += wage;
        averageRating = (currAvg+addAvg)/ratingCount;
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

}
