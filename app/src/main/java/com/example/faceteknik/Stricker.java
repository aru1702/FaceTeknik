package com.example.faceteknik;

public enum Stricker {

    SATU("@tools:sample/avatars[0]"),
    DUA("@tools:sample/avatars[1]"),
    TIGA("@tools:sample/avatars[3]"),
    EMPAT("@tools:sample/avatars[4]");

    String path;

    Stricker(String path) {
        this.path = path;
    }

    public String toString()
    {
        return path;
    }


}
