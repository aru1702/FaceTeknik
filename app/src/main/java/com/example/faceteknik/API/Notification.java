package com.example.faceteknik.API;

public class Notification {

    private int id;
    private String userPost;
    private String date;
    private boolean alreadyRead;

    public Notification(int id, String userPost, String date, boolean alreadyRead) {
        this.id = id;
        this.userPost = userPost;
        this.date = date;
        this.alreadyRead = alreadyRead;
    }

    public int getId() {
        return id;
    }

    public String getUserPost() {
        return userPost;
    }

    public String getDate() {
        return date;
    }

    public boolean isAlreadyRead() {
        return alreadyRead;
    }
}
