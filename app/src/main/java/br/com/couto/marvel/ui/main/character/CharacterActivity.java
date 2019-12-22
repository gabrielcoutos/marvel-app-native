package br.com.couto.marvel.ui.main.character;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import br.com.couto.marvel.R;
import br.com.couto.marvel.databinding.ActivityCharacterBinding;

public class CharacterActivity extends AppCompatActivity {
    private ActivityCharacterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_character);
    }
}
