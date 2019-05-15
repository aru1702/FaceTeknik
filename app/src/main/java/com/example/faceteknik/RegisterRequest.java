package com.example.faceteknik;

public class RegisterRequest {

    private String fullname;
    private String username;
    private String email;
    private String password;
    private String lahir;
    private String bio;


    public RegisterRequest(String fullname, String username, String email, String password, String lahir, String bio) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.lahir = lahir;
        this.bio = bio;
    }
}
