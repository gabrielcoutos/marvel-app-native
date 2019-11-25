package br.com.couto.marvel.model;

import java.io.Serializable;

public class Thumbnail implements Serializable {
    private String path;
    private String extension;

    public Thumbnail() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
