package br.com.couto.marvel.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import br.com.couto.marvel.R;
import br.com.couto.marvel.adapter.CharactersAdapter;
import br.com.couto.marvel.databinding.ActivityMainBinding;
import br.com.couto.marvel.model.Character;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private CharactersAdapter charactersAdapter;
    private List<Character> characterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.setCharacterList(characterList);
        viewModel.getCharacter();
        setupRecycleView();
    }

    private void setupRecycleView(){
        charactersAdapter = new CharactersAdapter(characterList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.recycleCharacter.setLayoutManager(manager);
        binding.recycleCharacter.setAdapter(charactersAdapter);
        viewModel.setAdapter(charactersAdapter);
    }
}
