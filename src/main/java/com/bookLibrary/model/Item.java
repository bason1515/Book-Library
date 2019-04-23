package com.bookLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    @JsonProperty(access = Access.WRITE_ONLY)
    String id;
    VolumeInfo volumeInfo;
    
    public boolean haveISBN(String isbn) {
        if(id.equals(isbn)) {
            this.getVolumeInfo().setIsbn(this.id);
            return true;
        }
        for (IndustryIdentifiers id : this.volumeInfo.getIndustryIdentifiers()) {
            if (id.getType().equals("ISBN_13") && id.getIdentifier().equals(isbn)) {
                this.getVolumeInfo().setIsbn(id.getIdentifier());
                return true;
            }
        }
        return false;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

//    @JsonProperty("isbn")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
