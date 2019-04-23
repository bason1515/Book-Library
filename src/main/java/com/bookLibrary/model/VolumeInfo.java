package com.bookLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
    private IndustryIdentifiers[] industryIdentifiers;
    private String title;
    private String subtitle;
    private String publisher;
    private String publishedDate;
    private String description;
    private int pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private double averageRating;
    private int ratingsCount;
    private String[] authors;
    private String[] categories;

    public IndustryIdentifiers[] getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public boolean haveISBN(String isbn) {
        for (IndustryIdentifiers id : industryIdentifiers) {
            if (id.getIdentifier().equals(isbn))
                return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setIndustryIdentifiers(IndustryIdentifiers[] industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    @JsonIgnore()
    public int getRatingsCount() {
        return ratingsCount;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

}
