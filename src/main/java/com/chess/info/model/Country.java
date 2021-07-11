package com.chess.info.model;

public class Country {

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
