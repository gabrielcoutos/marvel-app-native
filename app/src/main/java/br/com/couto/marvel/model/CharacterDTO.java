package br.com.couto.marvel.model;

import java.io.Serializable;

public class CharacterDTO implements Serializable {
    private Payload data;

    public CharacterDTO() {
    }

    public Payload getData() {
        return data;
    }

    public void setData(Payload data) {
        this.data = data;
    }
}
