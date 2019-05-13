package com.example.faceteknik.API;

public class TextPost extends Post {

    private String textContent;

    public TextPost(int id, String username, String date, String textContent) {
        super(id, username, date);

        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }
}
