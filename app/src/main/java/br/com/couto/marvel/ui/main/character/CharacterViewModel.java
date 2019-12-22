package br.com.couto.marvel.ui.main.character;

import androidx.lifecycle.ViewModel;

import br.com.couto.marvel.model.Character;

public class CharacterViewModel extends ViewModel {
    private Character character;

    CharacterViewModel(){character = new Character();}
}
