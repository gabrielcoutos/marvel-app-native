package br.com.couto.marvel.ui.main;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.couto.marvel.model.Character;

public class MainViewModel  extends ViewModel {
    private List<Character> characterList;

    public MainViewModel() {
        characterList = new ArrayList<>();
    }

    public void setCharacterList(List<Character> characters){
        this.characterList = characters;
    }
}
