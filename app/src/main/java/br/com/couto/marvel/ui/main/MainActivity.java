package br.com.couto.marvel.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


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
        setSupportActionBar(binding.toolbar);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        return true;
    }
}
