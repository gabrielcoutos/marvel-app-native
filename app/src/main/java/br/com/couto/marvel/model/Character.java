package br.com.couto.marvel.model;

import java.io.Serializable;

import br.com.couto.marvel.model.comics.ComicsDTO;

public class Character implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Thumbnail thumbnail;
    private ComicsDTO comics;

    public Character() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ComicsDTO getComics() {
        return comics;
    }

    public void setComics(ComicsDTO comics) {
        this.comics = comics;
    }
}
