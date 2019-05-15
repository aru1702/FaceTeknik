package com.example.faceteknik.API;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String Regis_URL = "http://127.0.0.1/logincust";
    private Map<String ,String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener)
    {

    }
    public Map<String, String> getParams()
    {
       return params;
    }
}
