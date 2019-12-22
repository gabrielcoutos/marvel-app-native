package br.com.couto.marvel.model.comics;

import java.io.Serializable;

public class Comics implements Serializable {

    private String name;

    Comics(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
