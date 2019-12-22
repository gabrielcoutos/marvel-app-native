package br.com.couto.marvel.ui.main;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.couto.marvel.adapter.CharactersAdapter;
import br.com.couto.marvel.adapter.EndListListener;
import br.com.couto.marvel.adapter.OnCharacterClickListener;
import br.com.couto.marvel.model.Character;
import br.com.couto.marvel.model.CharacterDTO;
import br.com.couto.marvel.retrofit.MarvelAPI;
import br.com.couto.marvel.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainViewModel  extends ViewModel implements EndListListener, OnCharacterClickListener {
    private List<Character> characterList;
    private CharactersAdapter adapter;
    private Integer limit = 20;
    private Integer offset = 0;
    private MutableLiveData<Character> clickCharacter;


    public MainViewModel() {
        characterList = new ArrayList<>();
        adapter = new CharactersAdapter(characterList);
        adapter.setmOnEndListListener(this::onEndListListener);
        adapter.setmOnCharacterClickListener(this::onCharacterClick);
        clickCharacter = new MutableLiveData<>();
        getCharacter();
    }

    public void getCharacter(){
        Retrofit retrofit = RetrofitConfig.getInstance();
        MarvelAPI api = retrofit.create(MarvelAPI.class);
        Call<CharacterDTO> call = api.getCharacters(offset);
        call.enqueue(callback);

    }

    private Callback<CharacterDTO> callback = new Callback<CharacterDTO>() {
        @Override
        public void onResponse(Call<CharacterDTO> call, Response<CharacterDTO> response) {
            if(response.code() == 200){
                if(response.body() != null){
                    offset  +=limit;
                    characterList.addAll(response.body().getData().getResults());
                    adapter.notifyDataSetChanged();
                }
            }
        }

        @Override
        public void onFailure(Call<CharacterDTO> call, Throwable t) {

        }
    };

    @Override
    public void onEndListListener() {
        getCharacter();
    }

    public CharactersAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onCharacterClick(Character character) {
        clickCharacter.postValue(character);

    }

    public MutableLiveData<Character> getClickCharacter() {
        return clickCharacter;
    }


}
