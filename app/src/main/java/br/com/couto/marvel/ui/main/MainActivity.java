package br.com.couto.marvel.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.couto.marvel.R;
import br.com.couto.marvel.adapter.CharactersAdapter;
import br.com.couto.marvel.databinding.ActivityMainBinding;
import br.com.couto.marvel.model.Character;
import br.com.couto.marvel.model.CharacterDTO;
import br.com.couto.marvel.retrofit.MarvelAPI;
import br.com.couto.marvel.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
