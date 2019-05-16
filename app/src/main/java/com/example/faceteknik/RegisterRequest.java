package com.example.faceteknik;

import java.util.Map;

public class RegisterRequest {
    private static final String Regis_URL = "http://127.0.0.1/register";
    private Map<String ,String> params;

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
