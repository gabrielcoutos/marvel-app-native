package br.com.couto.marvel.ui.main;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.couto.marvel.adapter.CharactersAdapter;
import br.com.couto.marvel.model.Character;
import br.com.couto.marvel.model.CharacterDTO;
import br.com.couto.marvel.retrofit.MarvelAPI;
import br.com.couto.marvel.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainViewModel  extends ViewModel {
    private List<Character> characterList;
    private CharactersAdapter adapter;
    private Integer limit = 20;
    private Integer offset;

    public MainViewModel() {
        characterList = new ArrayList<>();
    }

    public void setCharacterList(List<Character> characters){
        this.characterList = characters;
    }

    public void getCharacter(){
        Retrofit retrofit = RetrofitConfig.getInstance();
        MarvelAPI api = retrofit.create(MarvelAPI.class);
        Call<CharacterDTO> call = api.getCharacters();
        call.enqueue(new Callback<CharacterDTO>() {
            @Override
            public void onResponse(Call<CharacterDTO> call, Response<CharacterDTO> response) {
                if(response.code() == 200){
                    if(response.body()!= null){
                        characterList.addAll(response.body().getData().getResults());
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<CharacterDTO> call, Throwable t) {

            }
        });
    }

    public void setAdapter(CharactersAdapter adapter) {
        this.adapter = adapter;
    }
}
