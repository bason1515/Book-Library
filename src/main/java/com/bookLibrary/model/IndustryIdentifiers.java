package com.bookLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndustryIdentifiers {
    private String type;
    private String identifier;

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
