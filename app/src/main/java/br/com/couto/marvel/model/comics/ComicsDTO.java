package br.com.couto.marvel.model.comics;

import java.io.Serializable;
import java.util.List;

public class ComicsDTO implements Serializable {
    private List<Comics> items;

    ComicsDTO() {}

    public List<Comics> getItems() {
        return items;
    }

    public void setItems(List<Comics> items) {
        this.items = items;
    }
}
