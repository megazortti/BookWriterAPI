package com.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookAuthorDTO {
    private String title;
    private String author;

    public BookAuthorDTO(String title, String author){
        String fName;
        String lName;
        Integer searchIndex; 
        this.title = title;
        searchIndex = author.indexOf(":");
        fName = author.substring(0, searchIndex);
        lName = author.substring(searchIndex+1);
        this.author=lName.substring(0,1).toUpperCase() + lName.substring(1) + ", " + fName.substring(0, 1).toUpperCase() + fName.substring(1);
    }
        
}
