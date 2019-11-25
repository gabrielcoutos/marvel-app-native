package br.com.couto.marvel.retrofit;

import br.com.couto.marvel.model.CharacterDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelAPI {
     String SUFIX = "?ts=1&apikey=ab64f13f191c62a2c96cfd459a9d9f62&hash=25a1eabd571afc95e4ddfe374fa87da9";

    @GET("characters/{id}"+SUFIX)
    Call<CharacterDTO> getCharacter(@Path("id")Long id);
}
