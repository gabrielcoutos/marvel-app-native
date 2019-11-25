package br.com.couto.marvel.retrofit;

import br.com.couto.marvel.model.CharacterDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MarvelAPI {

    @GET("characters/{id}")
    Call<CharacterDTO> getCharacter(@Path("id")Long id);
}
